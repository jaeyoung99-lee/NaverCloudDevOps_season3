// 부모, 자식 간 통신
// 자식 컴포넌트


import { Button } from '@mui/material';
import React from 'react';

// 부모, 자식간의 통신
// 1. 부모 컴포넌트에서 자식 컴포넌트로 props를 통해서 값이나 이벤트 전달을 할 수 있다.
// 2. 자식 컴포넌트에서는 부모 컴포넌트의 값을 props로 받아서 출력은 가능하지만 직접적으로 변경은 불가능하다.
// 3. 만약 변경하려면 부모의 이벤트를 props를 통해서 호출을 해서 그 이벤트 함수에서 변경을 하면 된다.
// props는 부모 컴포넌트가 설정하며, 컴포넌트 자신은 해당 props를 읽기 전용으로만 사용할 수 있다.
// 컴포넌트 내부에서 읽고 또 업데이트 하려면 state를 써야 한다.

function FourChildApp(props) {
    const {name, age, addr} = props; // 읽기 전용이어서 출력만 가능하며 수정은 불가능

    return (
        <div>
            <div className='box'>
                {/* {props.name}님의 나이는 {props.age}이며 고향은 {props.addr}입니다. */}
                {name}님의 나이는 {age}이며 고향은 {addr}입니다.
                <Button color='info' variant='contained' style={{marginLeft: '10px'}} size='small'
                onClick={() => props.incre()}>증가</Button>
            </div>
        </div>
    );
}

export default FourChildApp;