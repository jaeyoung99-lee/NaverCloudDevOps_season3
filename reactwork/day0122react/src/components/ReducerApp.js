import React from 'react';
import ReducerTest1 from './ReducerTest1';
import ReducerTest2 from './ReducerTest2';

/*
useReducer : state 관리가 용이하며 유지, 보수가 편하다
호출 : dispatch(type, action) -> reducer(state, action)
기능
reducer : state를 업데이트하는 역할(은행)
dispatch : state 업데이트를 요구
action : 요구의 내용
*/

const ReducerApp = () => {
    return (
        <div>
            <ReducerTest1/>
            <hr/>
            <ReducerTest2/>        
        </div>
    );
};

export default ReducerApp;