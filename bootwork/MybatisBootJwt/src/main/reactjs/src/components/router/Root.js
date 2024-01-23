import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import RouterMain from './RouterMain';

const Root = () => {
    return (
        <div>
            <BrowserRouter>
                <RouterMain/>
            </BrowserRouter>
        </div>
    );
};

export default Root;