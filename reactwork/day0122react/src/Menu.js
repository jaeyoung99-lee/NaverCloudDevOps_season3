import React from 'react';
import './components/MyStyle.css';
import { NavLink } from 'react-router-dom';

const Menu = () => {
    return (
        <div>
            <ul className='menu'>
                <li>
                    <NavLink to={'/'}>Home</NavLink>
                </li>
                <li>
                    <NavLink to={'/callback'}>CallBack</NavLink>
                </li>
                <li>
                    <NavLink to={'/memo'}>Memo</NavLink>
                </li>
                <li>
                    <NavLink to={'/reducer'}>Reducer</NavLink>
                </li>
                <li>
                    <NavLink to={'/context'}>Context</NavLink>
                </li>
                <li>
                    <NavLink to={'/sweet'}>SweetAlert</NavLink>
                </li>
                <li>
                    {/* get 방식 */}
                    <NavLink to={'/query?color=pink&name=lee&addr=seoul'}>QueryString</NavLink>
                    {/* <NavLink to={'/query'}>QueryString</NavLink> */}
                </li>
            </ul>  
        </div>
    );
};

export default Menu;