// guest DB


import { Alert } from '@mui/material';
import React, { useEffect, useState } from 'react';
import FourGuestForm from './FourGuestForm';
import axios from 'axios';
import FourGuestRowItem from './FourGuestRowItem';
import FourPagination from './FourPagination';

const FourApp = () => {
    const [guestList, setGuestList] = useState([]);
    const [limit, setLimit] = useState(10);
    const [page, setPage] = useState(1);
    const offset = (page -1) * limit;

    // 저장 함수
    const onGuestSave = (data) => { // data에는 닉네임과 글이 들어있음
        axios.post("/guest/insert", data)
        .then(res => {
            // 추가 성공 후 목록 다시 출력
            list();
        })
    }

    // 목록 출력하는 함수
    const list = () => {
        axios.get("/guest/list")
        .then(res => {
            setGuestList(res.data);
        })
    }

    // 처음 시작 시 목록 출력
    useEffect(() => {
        list();
    }, []); // 처음 한 번만 호출

    // 삭제 함수
    const onDelete = (gnum) => {
        axios.delete("/guest/delete?gnum=" + gnum)
        .then(res => {
            // 삭제 성공 후 목록 다시 출력
            list();
        })
    }

    return (
        <div>
            <Alert severity='primary' variant='filled'>
                <h3>FourApp - guest DB</h3>
            </Alert>
            <FourGuestForm onGuestSave={onGuestSave}/>
            <hr/>

            <label>
                페이지 당 표시할 게시물의 수 : &nbsp;
                <select type="number" value={limit}
                onChange={({target:{value}}) => setLimit(Number(value))}>
                    <option value="3">3</option>
                    <option value="5">5</option>
                    <option value="7">7</option>
                    <option value="9">9</option>
                    <option value="12">12</option>
                </select>
            </label>

            <h6><b>총 {guestList.length}개의 방명록 글이 있습니다.</b></h6>
            {
                guestList.slice(offset, offset + limit).map((item, idx) => (
                    <FourGuestRowItem key={idx} item={item} onDelete={onDelete}/>
                ))
            }

            <footer>
                <FourPagination total={guestList.length}
                limit={limit}
                page={page}
                setPage={setPage}/>
            </footer>
        </div>
    );
};

export default FourApp;