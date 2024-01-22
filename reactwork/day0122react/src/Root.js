import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import RouteMain from './RouteMain';

const Root = () => {
    return (
        <div>
            <BrowserRouter>
                <RouteMain/>
            </BrowserRouter>
        </div>
    );
};

export default Root;