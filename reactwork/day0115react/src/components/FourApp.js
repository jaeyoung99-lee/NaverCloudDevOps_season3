// map으로 이미지 배열 출력


import React from 'react';
import img1 from '../images/1.jpg';
import img2 from '../images/2.jpg';
import img3 from '../images/3.jpg';
import img4 from '../images/4.jpg';
import './MyStyle.css';

function FourApp(props) {
    // 4개의 import된 이미지를 배열에 저장
    const myImage = [img1, img2, img3, img4];
    
    const data = [
        {"name" : "강호동", "addr" : "서울", "hp" : "010-2222-3333", "photo" : "1"},
        {"name" : "이미자", "addr" : "부산", "hp" : "010-1244-2141", "photo" : "2"},
        {"name" : "손호준", "addr" : "제주도", "hp" : "010-2342-3324", "photo" : "3"},
        {"name" : "배미숙", "addr" : "경기도", "hp" : "010-5453-5348" , "photo" : "4"},
    ];

    return (
        <div>
            <h3 className='alert alert-danger'>FourApp - map으로 이미지 배열 출력</h3>
            {
                myImage.map((img, idx) => (<img alt='' src={img} width={200}/>))
            }

            <hr/>

            {
                data.map((ele, i) => (
                    <div className='box' key={i}>
                        <h5>이름 : {ele.name}</h5>
                        <h5>주소 : {ele.addr}</h5>
                        <h5>번호 : {ele.hp}</h5>
                        <img alt='프로필 사진' src={require(`../images/${ele.photo}.jpg`)} width={120}/>
                    </div>
                ))
            }

            <hr/>

            <table className='table table-bordered' style={{width: '600px'}}>
                <thead>
                    <tr>
                        <th width='50'>Index</th>
                        <th width='100'>사진</th>
                        <th width='100'>이름</th>
                        <th width='200'>번호</th>
                        <th>주소</th>
                    </tr>
                </thead>
                <tbody>
                {
                    data.map((ele, i) => (
                        <tr key={i}>
                            <td>{i+1}</td>
                            <td><img alt='프로필 사진' src={require(`../images/${ele.photo}.jpg`)} width={120}/></td>
                            <td>{ele.name}</td>
                            <td>{ele.hp}</td>
                            <td>{ele.addr}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    );
}

export default FourApp;