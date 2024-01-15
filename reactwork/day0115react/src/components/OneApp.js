// useEffect


import React, { useEffect, useState } from 'react';

function OneApp(props) {
    const [count, setCount] = useState(0);
    const [number, setNumber] = useState(0);
    const [message, setMessage] = useState('Input Message');

    // count만 증가하는 이벤트
    const increCount = () => {
        setCount(count + 1);
    }

    // number만 증가하는 이벤트
    const increNumber = () => {
        setNumber(number + 1);
    }

    // count, number 모두 증가하는 이벤트
    const increCountNumber = () => {
        setCount(count + 1);
        setNumber(number + 1);
    }

    // useEffect
    // 모든 값 변경 시 무조건 호출
    // useEffect(() => {
    //     console.log("처음 시작 할 때 또는 state 변수 변경시마다 호출")
    // })

    // count 변경 시에만 호출
    useEffect(() => {
        console.log("count 변경 시에만 호출!!")
    }, [count])

    // number 변경 시에만 호출
    useEffect(() => {
        console.log("number 변경 시에만 호출!!")
    }, [number])

    return (
        <div>
            <h3 className='alert alert-success'>OneApp</h3>

            <button type='button' className='btn btn-outline-secondary'onClick={increCount}>
                count만 증가
            </button>
            <button type='button' className='btn btn-outline-secondary' onClick={increNumber}>
                number만 증가
            </button>
            <button type='button' className='btn btn-outline-secondary' onClick={increCountNumber}>
                count, number 모두 증가
            </button>

            <br/>

            <input type='text' value={message} onChange={(e) => setMessage(e.target.value)}/>

            <br/>
            <b style={{fontSize:'2em'}}>count: {count}</b>
            <br/>
            <b style={{fontSize:'2em'}}>number: {number}</b>
            <br/>
            <b style={{fontSize:'20px'}}>{message}</b>
        </div>
    );
}

export default OneApp;