// 연습문제


import React, { useState } from 'react';

function SixApp(props) {
    const [mycar, setMycar] = useState(['2', '7']);
    const [carno, setCarno] = useState('');

    return (
        <div>
            <h3 className='alert alert-danger'>SixApp - 연습문제</h3>
            <input type='text' 
            placeholder='자동차 번호(1 ~ 15) 입력 후 엔터키' 
            className='form-control' 
            style={{width: '300px'}} 
            value={carno} 
            onChange={(e) => setCarno(e.target.value)}
            onKeyUp={(e) => {
                if(e.key === "Enter"){
                    // 1 ~ 15가 아니면 경고 후 종료
                    if(e.target.value < 1 || e.target.value > 15){
                        alert("1 ~ 15 사이 숫자만 입력 가능합니다!");
                        return;
                    }
                    
                    // 배열 mycar에 carno 값 추가
                    setMycar(mycar.concat(e.target.value));

                    // carno 값 초기화
                    setCarno('');
                }
            }}
            />
            <br/>
            {/* 1 ~ 15 사이 번호 입력 후 엔터키를 누르면 해당 자동차 이미지로 출력 */}
            {/* 해당 자동차 이미지에서 더블 클릭하면 자동차 삭제하기 */}
            {
                // mycar 배열 이미지로 출력(width='100')
                mycar.map((car, i) => (<h6 key={i}
                onDoubleClick={(e) => {
                    setMycar(mycar.filter((item, idx) => i !== idx));
                    alert(`자동차 ${i}번 인덱스 이미지 삭제!!!`);
                }}>carno[{i + 1}] : <img alt='' src={require(`../images/mycar${car}.png`)} style={{width: '100px'}}/></h6>)) 
            } 
        </div>
    );
}

export default SixApp;