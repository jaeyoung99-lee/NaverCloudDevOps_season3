import React, { useState } from 'react';

import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';
import SixApp from './SixApp';
import SevenApp from './SevenApp';
import EightApp from './EightApp';

function MainApp(props) {
    // radio 방식
    const [index, setIndex] = useState(1);
    const onChangeApp = (e) => {
        setIndex(Number(e.target.value));
    }

    return (
        <div style={{margin: '30px'}}>
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
            <label style={{marginLeft: '20px'}}>
                <input type='radio' name='myapp' defaultValue={7} onClick={onChangeApp}/>SevenApp
            </label>
            <label style={{marginLeft: '20px'}}>
                <input type='radio' name='myapp' defaultValue={8} onClick={onChangeApp}/>EightApp
            </label>

            <hr/>
            <h4 style={{color: 'blue'}}>
                수업 내용 :&nbsp;
                {
                    index === 1 ? "useEffect" : 
                    index === 2 ? <div>조건에 따라 이미지 보이기 / 안보이기 <br/> src의 이미를 import 없이 출력하는 방법 : require</div> : 
                    index === 3 ? "map 반복문" : 
                    index === 4 ? "map으로 이미지 배열 출력" : 
                    index === 5 ? "배열 추가 / 삭제" : 
                    index === 6 ? "연습문제" : 
                    index === 7 ? "테이블 사용하여 배열 출력" : "mui 이미지 사용 연습"
                }
            </h4>

            <hr/>
            {
                index === 1 ? <OneApp/> : index === 2 ? <TwoApp/> : index === 3 ? <ThreeApp/> : index === 4 ? <FourApp/> : index === 5 ? <FiveApp/> : index === 6 ? <SixApp/> : index === 7 ? <SevenApp/> : <EightApp/> 
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