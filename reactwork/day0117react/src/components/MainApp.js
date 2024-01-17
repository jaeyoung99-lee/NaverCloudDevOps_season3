import React, { useState } from 'react';
import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';
import SixApp from './SixApp';
import './MyStyle.css';

const MainApp = () => {
    // radio 방식
    const [index, setIndex] = useState(1);

    const onChangeApp = (e) => {
        setIndex(Number(e.target.value));
    }

    return (
        <div style={{margin: '30px'}}>
            <h3 className='alert alert-success'>2024년 1월 17일 수요일 React 수업 : Axios</h3>
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
                    index === 1 ? "1" : 
                    index === 2 ? "2" : 
                    index === 3 ? "3" : 
                    index === 4 ? "4" : 
                    index === 5 ? "5" : "6"
                }
            </h4>

            <hr/>
            {
                index === 1 ? <OneApp/> : index === 2 ? <TwoApp/> : index === 3 ? <ThreeApp/> : index === 4 ? <FourApp/> : index === 5 ? <FiveApp/> : <SixApp/>
            }
        </div>
    );
};

export default MainApp;