import React, { useState } from 'react';

import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';
import SixApp from './SixApp';
import './MyStyle.css';

function MainApp(props) {
    // radio 방식
    const [index, setIndex] = useState(1);
    const onChangeApp = (e) => {
        setIndex(Number(e.target.value));
    }

    return (
        <div style={{margin: '30px'}}>
            <h3 className='alert alert-success'>2024년 1월 16일 화요일 React 수업</h3>
            <label>
                <input type='radio' name='myapp' defaultValue={1} onClick={onChangeApp} defaultChecked/>OneApp
            </label>
            <label style={{marginLeft: '20px'}}>
                <input type='radio' name='myapp' defaultValue={2} onClick={onChangeApp}/>TwoApp
            </label>
            <label style={{marginLeft: '20px'}}>
                <input type='radio' name='myapp' defaultValue={3} onClick={onChangeApp}/>ThreeApp
            </label>
            <label style={{marginLeft: '20px'}}>
                <input type='radio' name='myapp' defaultValue={4} onClick={onChangeApp}/>FourApp
            </label>
            <label style={{marginLeft: '20px'}}>
                <input type='radio' name='myapp' defaultValue={5} onClick={onChangeApp}/>FiveApp
            </label>
            <label style={{marginLeft: '20px'}}>
                <input type='radio' name='myapp' defaultValue={6} onClick={onChangeApp}/>SixApp
            </label>

            <hr/>
            <h4 style={{color: 'blue'}}>
                수업 내용 :&nbsp;
                {
                    index === 1 ? "useRef" : 
                    index === 2 ? "useRef 이용해서 값 입력하기" : 
                    index === 3 ? "하나의 변수에 여러 값 저장하기" : 
                    index === 4 ? "부모, 자식 간 통신" : 
                    index === 5 ? "부모, 자식 간 통신 예제" : "json 데이터 출력"
                }
            </h4>

            <hr/>
            {
                index === 1 ? <OneApp/> : index === 2 ? <TwoApp/> : index === 3 ? <ThreeApp/> : index === 4 ? <FourApp/> : index === 5 ? <FiveApp/> : <SixApp/>
            }
        </div>


    );
    
    // select 방식
    // const [comp, setComp] = useState(1); // 컴포넌트 번호
    // return (
    //     <div>
    //         <h3>2024년 1월 15일 월요일 React 수업</h3>
    //         <hr/>
    //         <select className='form-select' style={{width: '400px'}}
    //         onChange={(e) => {
    //             setComp(Number(e.target.value));
    //         }}>
    //             <option value={1} selected>OneApp - </option>
    //             <option value={2}>TwoApp - </option>
    //             <option value={3}>ThreeApp - </option>
    //             <option value={4}>FourApp - </option>
    //             <option value={5}>FiveApp - </option>
    //         </select>
    //         <br/>
    //         <h5>{comp}번 컴포넌트 선택</h5>
    //         <br/>
    //         {
    //             // 조건 연산자를 이용하여 comp 값에 따라 해당 컴포넌트가 나오도록 하기
    //             comp === 1 ? <OneApp/> : comp === 2 ? <TwoApp/> : comp === 3 ? <ThreeApp/> : comp === 4 ? <FourApp/> : <FiveApp/>
    //         }
    //     </div>
    // );
}

export default MainApp;