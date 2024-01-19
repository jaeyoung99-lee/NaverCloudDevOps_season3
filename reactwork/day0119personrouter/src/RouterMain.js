import React from 'react';
import { Route, Routes } from 'react-router-dom';
import PersonList from './components/PersonList';
import PersonForm from './components/PersonForm';
import PersonDetail from './components/PersonDetail';
import PersonUpdateForm from './components/PersonUpdateForm';
import errimg from './images/고윤정 단독.png';
import './components/PersonStyle.css';

const RouterMain = () => {
    return (
        <div>
            <Routes>
                <Route path='/' element={<PersonList/>}/>
                <Route path='/writeform' element={<PersonForm/>}/>
                <Route path='/detail/:pnum' element={<PersonDetail/>}/>
                <Route path='/updateform/:pnum' element={<PersonUpdateForm/>}/>

                {/* 그 이외의 매핑 주소일 경우 호출 */}
                <Route path='*' element={
                    <div style={{margin: '50px'}}>
                        <h1>잘못된 URL 주소입니다.</h1>
                        <img alt='' src={errimg}/>
                    </div>
                }/>
            </Routes>
        </div>
    );
};

export default RouterMain;