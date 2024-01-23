// 2024년 1월 23일 화요일 수업 할 내용


import React from 'react';
import { useLocation, useSearchParams } from 'react-router-dom';

function useQuery() {
    return new URLSearchParams(useLocation().search);
}

const QueryStringApp = () => {
    // url의 쿼리 스트링 값을 얻는 두 가지 방법
    // 방법 1 : useParams처럼 라우트에 등록 안해도 됨
    let query = useQuery();

    const color = query.get("color");
    const name = query.get("name");
    const addr = query.get("addr");

    // 방법 2 : 직접 받아오기
    const [query2,setQuery2] = useSearchParams();

    const color2 = query2.get("color");
    const name2 = query2.get("name");
    const addr2 = query2.get("addr");

    return (
        <div>
            <h3 className='alert alert-success'>Query String 읽는 방법</h3>
            {/* 방법1 */}
            <div style={{backgroundColor: color}}>
                배경색 : {color}<br/>
                이름 : {name}<br/>
                주소 : {addr}
            </div>
            <br/>
            {/* 방법2 */}
            <div style={{backgroundColor: color2}}>
                배경색 : {color2}<br/>
                이름 : {name2}<br/>
                주소 : {addr2}
            </div>
        </div>
    );
};

export default QueryStringApp;