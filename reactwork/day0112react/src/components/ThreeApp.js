// 이름, 점수 입력 이벤트


import React, { useState } from 'react';
import 인사 from '../images/인사.png'

function ThreeApp(props) {
    const [irum, setIrum] = useState('유뽀삐');
    const [spring, setSpring] = useState(99);
    const [react, setReact] = useState(100);

    const inputStyle = {
        marginLeft: '10px'
    }

    const resultStyle = {
        position: 'absolute',
        left: '300px',
        top: '285px'
    }
    return (
        <div className='box'>
            <h3 className='alert alert-info'>
                ThreeApp
                <img alt='' src = {인사} style={{width: '100px', float:'right'}}/>
            </h3>
            <div style={{width: '200px'}}>
                <div className='input-group'>
                    <h4>이름</h4>
                    <input type='text' className='form-control' style={inputStyle} value={irum}
                    onChange={(e) => {
                        setIrum(e.target.value);
                    }}/>
                </div>
                <div className='input-group'>
                    <h4>스프링 점수</h4>
                    <input type='text' className='form-control' style={inputStyle} value={spring}
                    onChange={(e) => {
                        setSpring(Number(e.target.value)); // 숫자 타입으로 변환해서 넣기
                    }}/>
                </div>
                <div className='input-group'>
                    <h4>리액트 점수</h4>
                    <input type='text' className='form-control' style={inputStyle} value={react}
                    onChange={(e) => {
                        setReact(Number(e.target.value)); // 숫자 타입으로 변환해서 넣기
                    }}/>
                </div>
            </div>

            <div style={resultStyle}>
                이름 : {irum}<br/>
                스프링 점수 : {spring}점<br/>
                리액트 점수 : {react}점<br/>
                총점 : {spring + react}점<br/>
                평균 : {(spring + react) / 2}점<br/>
                {/* 평균이 90 이상은 '장학생', 80 이상은 '우등생', 나머지는 '노력' */}
                등급 : {((spring + react) / 2) >= 90 ? "장학생" : ((spring + react) / 2) >= 80 ? "우등생" : "노력"}
            </div>
        </div>
    );
}

export default ThreeApp;