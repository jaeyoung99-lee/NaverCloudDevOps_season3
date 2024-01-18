import { Alert } from '@mui/material';
import React from 'react';

const HOmeSub2 = () => {
    return (
        <div>
             <Alert variant='filled' severity='info'>
                   우리 회사 구조도<br/>
                   사장 : 이문희<br/>
                   부장 : 홍길동<br/>
                   차장 : 김길동
            </Alert> 
        </div>
    );
};

export default HOmeSub2;