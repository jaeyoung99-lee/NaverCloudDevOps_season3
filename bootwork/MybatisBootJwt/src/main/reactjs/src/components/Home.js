import React from 'react';
import mainImage1 from '../image/해적.png';
import mainImage2 from '../image/호랑이.png';

const Home = () => {
    return (
        <div>
            <h1>React + Spring Boot 프로젝트</h1>
            <img alt='' src={mainImage1} style={{width: '300px', margin: '10px', border: '5px groove orange'}}/>
            <img alt='' src={mainImage2} style={{width: '300px', margin: '10px', border: '5px groove orange'}}/>
        </div>
    );
};

export default Home;