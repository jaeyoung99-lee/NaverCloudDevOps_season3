// 버튼 이벤트 - 숫자 증감 이벤트


import React, { useState } from 'react';
import 노래방 from '../images/노래방.png';

function TwoApp(props) {
    // 함수형에서 state 변수 선언하는 방법
    const [number, setNumber] = useState(0);
    return (
        <div className='box'>
            <h3 className='alert alert-success'>
                TwoApp
                <img alt='' src = {노래방} style={{width: '60px', float: 'right'}}/>
            </h3>
            <div style={{fontSize:'40px', color:'red', marginLeft: '200px'}}>
                {number}
            </div>
            <div style={{marginLeft: '130px'}}>
                <button type='button' className='btn btn-outline-success'
                onClick={() => {
                    if(number === 0) { // 값과 타입까지 비교하려면 ===, 값만 비교하려면 ==
                        alert("0 이하 감소할 수 없습니다.");
                        return; // 함수 종료
                    }
                    setNumber(number - 1);
                }}>숫자 감소</button>
                <button type='button' className='btn btn-outline-success' style={{marginLeft: '10px'}} 
                onClick={() => {
                    if(number === 10) { // 값과 타입까지 비교하려면 ===, 값만 비교하려면 ==
                        alert("10 이상 증가할 수 없습니다.");
                        return; // 함수 종료
                    }
                    setNumber(number + 1);
                }}>숫자 증가</button>
            </div>
        </div>
    );
}

export default TwoApp;