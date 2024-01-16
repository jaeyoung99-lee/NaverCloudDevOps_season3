// json 데이터 출력


import React, { useRef } from 'react';
import cate from '../data/CateData.json';

function SixApp(props) {
    const navData = cate.navData;
    const cateData = cate.categoryData;

    // 이미지에 적용할 ref 변수 선언
    const mainPhotoRef = useRef(null);

    return (
        <div>
            <h3 className='alert alert-danger'>SixApp - json 데이터 출력</h3>
            <div className='nav_container'>
                <ul className='nav_category'>
                    {
                        navData.map((item, i) => 
                        <li key={i}>
                            <div>
                                <img alt='' src={item.img} className='imgcategory'
                                onClick={(e) => {
                                    // 선택한 src 값을 ref 변수의 src로 보낸다.
                                    mainPhotoRef.current.src = e.target.src;
                                }}/>
                            </div>
                            <div>{item.title}</div>
                        </li>)
                    }
                </ul>
            </div>
            <div className='nav_container'>
                <ul className='nav_category'>
                    {
                        cateData.map((item, i) => 
                        <li key={i}>
                            <div>
                                <img alt='' src={item.img} className='imgcategory'
                                onClick={(e) => {
                                    // 선택한 src 값을 ref 변수의 src로 보낸다.
                                    mainPhotoRef.current.src = e.target.src;
                                }}/>
                            </div>
                            <div>{item.title}</div>
                        </li>)
                    }
                </ul>
            </div>

            {/* 아이콘 클릭 시 작은 이미지를 가져와서 출력할 메인 이미지 */}
            <div>
                <img alt='' src='' style={{width: '300px', height: '300px', border: '5px inset gray', margin: '10px 300px'}}
                ref={mainPhotoRef}/>
            </div>
        </div>
    );
}

export default SixApp;