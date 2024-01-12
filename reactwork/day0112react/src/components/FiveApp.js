// checkbox, select 이미지 이벤트


import React, { useState } from 'react';
import 파자마 from '../images/파자마.png';
import 컴퓨터 from '../images/컴퓨터.gif';
import 산타 from '../images/산타.png';
import 하트 from '../images/하트.png';
import 해적 from '../images/해적.png';
import 호랑이 from '../images/호랑이.png';

function FiveApp(props) {
    const [show, setShow] = useState(true);
    const [photo, setPhoto] = useState(컴퓨터);
    const [border, setBorder] = useState('inset');

    return (
        <div className='box' style={{width: '700px'}}>
            <h3 className='alert alert-warning'>
                FiveApp
                <img alt='' src = {파자마} style={{width: '60px', float: 'right'}}/>
            </h3>
            <div>
                <label>
                    <input type="checkbox" defaultChecked
                    onClick={(e) => {
                        setShow(e.target.checked);
                    }}/>
                    이미지 보이기 / 숨기기
                </label>
                <br/><br/>
                <div className='input-group'>
                    <select className='form-select' style={{width: '150px'}}
                    onChange={(e) => {
                        setPhoto(e.target.value);
                    }}>
                        <option value = {컴퓨터}>컴퓨터</option>
                        <option value = {산타}>산타</option>
                        <option value = {하트}>하트</option>
                        <option value = {해적}>해적</option>
                        <option value = {호랑이}>호랑이</option>
                    </select>
                    <select className='form-select' style={{width: '150px', marginLeft: '10px'}}
                    onChange={(e) => {
                        setBorder(e.target.value);
                    }}>
                        <option>inset</option>
                        <option>dotted</option>
                        <option>solid</option>
                        <option>dashed</option>
                        <option>double</option>
                        <option>groove</option>
                    </select>
                </div>
                <br/><br/>
                {
                    // show 값이 true 이면 이미지가 보이고, false 이면 이미지가 안보인다.
                    show &&
                    <img alt='' src = {photo} style={{border: `5px ${border} gray`}}/>
                }
            </div>
        </div>
    );
}  

export default FiveApp;