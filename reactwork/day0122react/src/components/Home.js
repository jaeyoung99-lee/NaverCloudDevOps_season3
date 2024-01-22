import React from 'react';
import img1 from '../image/s3.JPG';

const Home = () => {
    return (
        <div>
            <img alt='' src={img1}/>
            <h4 className='alert alert-danger'>
                오늘(2024-01-22) 공부할 내용
                <br/>
                1. useCallback <br/>
                2. useMemo <br/>
                3. useReducer <br/>
                4. useContext <br/>
                5. SweetAlert <br/>
                6. QueryString - useSearchParams <br/>
            </h4>
        </div>
    );
};

export default Home;