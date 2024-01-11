import React, { useState } from 'react';

function SecondApp(props) {
    // let msg = "Happy Day!!!"; // 단순 출력만 가능, 변경은 불가능

    // useState : 변경도 가능
    // const [변수명, setter함수명]
    const [msg, setMsg] = useState("Nice Day!!!");

    return (
        <div className='box2'>
            <h5 className='alert alert-success'>
                SecondApp 컴포넌트
            </h5>
            <h6>메시지를 입력하세요.</h6>
            <input type='text' className='form-control' value={msg} onChange={(e) => {
                // setter 함수를 통해서 입력 값을 msg에 넣는다.
                setMsg(e.target.value); // msg 변수의 값이 변경됨
            }}/>
            <h1>{msg}</h1>
        </div>
    );
}

export default SecondApp;