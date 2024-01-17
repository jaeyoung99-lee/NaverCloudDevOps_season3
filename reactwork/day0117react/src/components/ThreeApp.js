// mui Card를 이용한 목록 출력


import { Alert } from '@mui/material';
import React, { useEffect, useState } from 'react';
import ThreeCardApp from './ThreeCardApp';
import axios from 'axios';

const ThreeApp = () => {
    const [personList, setPersonList] = useState([]);

    const list = () => {
        // 백엔드로부터 데이터를 가져와서 배열 변수에 넣기
        axios.get("/person/list")
        .then(res => {
            setPersonList(res.data);
        })
    }

    useEffect(() => {
        console.log("useEffect")
        list(); // 처음 시작 시 무조건 호출
    }, []) // [] 안에 변수 안 쓸 시 처음 시작 시 한 번만 호출

    return (
        <div>
            <Alert severity='warning' variant='filled'>
                <h3>ThreeApp - mui Card를 이용한 목록 출력</h3>
                {
                    personList.map((item, idx) => (
                        <div>
                            <ThreeCardApp key={idx} item={item}/>
                            <hr/>
                        </div>
                    ))
                }
            </Alert>
        </div>
    );
};

export default ThreeApp;