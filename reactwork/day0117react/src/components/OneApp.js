// person DB 추가 / 목록


import { Alert } from '@mui/material';
import React, { useEffect, useState } from 'react';
import PersonForm from './PersonForm';
import axios from 'axios';
import PersonRowItem from './PersonRowItem';

const OneApp = () => {
    const [personList, setPersonList] = useState([]);

    // 저장 이벤트
    const personInsert = (data) => {
        console.log(data);
        
        // 스프링부트 서버로 데이터 보내서 db 저장
        axios.post("/person/add", data)
        .then((res) => {
            // 추가 성공 후 목록 다시 출력
            list();
        }).catch(error => {
            console.log("추가 시 에러 발생 : " + error);
        }) 
    }

    const list = () => {
        // 백엔드로부터 데이터를 가져와서 배열 변수에 넣기
        axios.get("/person/list")
        .then(res => {
            setPersonList(res.data);
        })
    }

    const deletePerson = (pnum) => {
        let url = "/person/delete?pnum=" + pnum;
        axios.delete(url)
        .then(res => {
            // 삭제 성공 후 목록 다시 출력
            alert("삭제 성공!!!");
            list();
        })
    }

    useEffect(() => {
        console.log("useEffect")
        list(); // 처음 시작 시 무조건 호출
    }, []) // [] 사이에 변수를 안쓰면 처음 시작 시 한 번만 호출

    return (
        <div>
            <Alert security='success' variant='filled'>
                <h3>OneApp - person DB 추가 / 목록</h3>
            </Alert>
            <PersonForm onSave={personInsert}/>
            <hr/>
            <h5>총 {personList.length}명의 회원이 등록되어 있습니다.</h5>
            <table className='table table-bordered' style={{width: '500px'}}>
                <tbody>
                    {
                        personList.map((rowData, idx) => 
                        <PersonRowItem key={idx} row={rowData} idx={idx} onDelete={deletePerson}/>)
                    }
                </tbody>
            </table>
        </div>
    );
};

export default OneApp;