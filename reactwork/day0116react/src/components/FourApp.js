// 부모, 자식 간 통신
// 부모 컴포넌트


import React, { useState } from 'react';
import FourChildApp from './FourChildApp';

function FourApp(props) {
    const [count, setCount] = useState(0);

    // count를 1씩 증가시키는 함수
    const changeCount = () => {
        setCount(count + 1);
    }

    return (
        <div>
            <h3 className='alert alert-danger'>FourApp - 부모, 자식 간 통신</h3>
            <h4><b>방문 횟수 : {count}회</b></h4>
            <FourChildApp name={"캔디"} age={"23세"} addr={"제주도"} incre={changeCount}/>
            <FourChildApp name={"안쏘니"} age={"27세"} addr={"LA"} incre={changeCount}/>
            <FourChildApp name={"테리우스"} age={"31세"} addr={"하와이"} incre={changeCount}/>
        </div>
    );
}

export default FourApp;