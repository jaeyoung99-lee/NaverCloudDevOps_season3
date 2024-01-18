import { Alert } from '@mui/material';
import React from 'react';
import { NavLink, Route, Routes } from 'react-router-dom';
import HomeSub1 from './HomeSub1';
import HOmeSub2 from './HomeSub2';
import HomeSub3 from './HomeSub3';

const Home = () => {
    return (
        <div>
            <Alert variant='filled' severity='success'>
                Home 컴포넌트입니다
            </Alert> 
            <h2>서브 메뉴들</h2>
            <NavLink to={"/home/sub1"}>회사연혁</NavLink>
            &nbsp; &nbsp;
            <NavLink to={"/home/sub2"}>회사구조</NavLink>
            &nbsp; &nbsp;
            <NavLink to={"/home/sub3"}>회사오는길</NavLink>
            <br/><br/>
            <Routes>
                <Route path='sub1' element={<HomeSub1/>}/>
                <Route path='sub2' element={<HOmeSub2/>}/>
                <Route path='sub3' element={<HomeSub3/>}/>
            </Routes>
        </div>
    );
};

export default Home;