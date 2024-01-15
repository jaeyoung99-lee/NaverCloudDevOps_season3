// map 반복문


import React from 'react';

function ThreeApp(props) {
    const names = ['리액트', '스프링부트', '자바', '파이썬', '뷰'];
    
    // 방법 1
    // map(element, index)
    // key 값은 unique한 값으로 태그에 넣어야 콘솔에 오류가 안남(보통 인덱스 값을 넣어줌)
    const nameList = names.map((irum, i) => (<li key={i}>{irum}</li>));

    return (
        <div>
            <h3 className='alert alert-info'>ThreeApp - map 반복문</h3>
            {nameList}
            
            <hr/>
            
            {/* 방법 2 */}
            {/* 직접 return문 안에서 반복해서 출력하는 경우 */}
            {
                names.map((irum, i) => (<h6 key={i}>{i} : {irum}</h6>))
            }

            <hr/>

            {/* 방법 3 */}
            {/* 배열이 아닌 특정 숫자 범위로 출력하고자 할 경우 */}
            {
                // [...new Array(10)].map((a, i) => <h5 key={i}>{i}</h5>)

                // images 폴더 안에 있는 이미지 8개를 map을 이용해서 출력 
                [...new Array(8)].map((a, i) => <img alt='' key={i} src = {require(`../images/${i+1}.jpg`)} width={100}/>)
            }
        </div>
    );
}

export default ThreeApp;