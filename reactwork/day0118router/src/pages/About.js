import { Alert } from '@mui/material';
import React from 'react';
import { useParams } from 'react-router-dom';
import simg from '../image/s1.JPG';
import gimg from '../image/s10.JPG';

const About = () => {
    const {emp}=useParams();
    console.log({emp}); //{"emp":"Samsung"}
    console.log({emp}.emp);//Samsung

    return (
        <div>
            <Alert variant='filled' severity='warning'>
                        About 컴포넌트입니다
            </Alert> 
            {
                // emp 값 넘어오지 않은경우 실행할 영역
                emp==null?
                <div>
                    <h1>저는 취업준비생입니다</h1>
                    <img alt='' src={require(`../image/s6.JPG`)}/>
                </div>
                :
                //emp값이 있는경우 실행할 영역
                <div>
                    
                    <h1>저는 {emp} 에 다니고 있습니다</h1>
                    <img alt='' src={(emp==='Samsung'?simg:gimg)}/>
                </div>
            }   
        </div>
       
    );
};

export default About;