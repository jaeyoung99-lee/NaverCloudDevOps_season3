// 조건에 따라 이미지 보이기 / 안보이기
// src의 이미지를 import 없이 출력하는 방법 : require


import React, { useEffect, useState } from 'react';
import 삐질 from '../images/삐질.png';
import 해적 from '../images/해적.png';

function TwoApp(props) {
    const [show, setShow] = useState(true);
    const [count, setCount] = useState(1);

    const clickButtonEvent = () => {
        setCount(count + 1);
        // 비동기 처리라 아래 코드가 먼저 호출될 수도 있음 => 3의 배수마다가 아니게 됨 ==> 방지하기 위해 아래처럼 useEffect를 이용
        // setShow(count % 3 === 0 ? true : false);
    }

    useEffect(() => {
        setShow(count % 3 === 0 ? true : false);
    }, [count]) // count 변경 시 자동 호출

    return (
        <div>
            <h3 className='alert alert-danger'>TwoApp - 3의 배수마다 이미지 보이기 / 안보이기</h3>
            <button type='button' className='btn btn-danger' onClick={clickButtonEvent}>숫자 증가</button>
            <b style={{fontSize: '4em', color: 'red', marginLeft: '50px'}}>{count}</b>
            <br/><br/>
            {
                // show가 true 일 때 보이는 이미지
                show &&
                <img alt='' src = {삐질}/>
            }

            {
                // show가 false 일 때 보이는 이미지
                !show &&
                <img alt='' src = {해적}/>
            } 

            {/* src의 이미를 import 없이 출력하는 방법 : require */}
            <img alt='' src = {require('../images/훌라후프.png')}/>
        </div>
    );
}

export default TwoApp;