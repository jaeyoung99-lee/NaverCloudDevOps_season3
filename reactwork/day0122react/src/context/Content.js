import React, { useContext } from 'react';
import { ThemeContext } from './ThemeContext';
import { UserContext } from './UserContext';

const Content = () => {
    const {isDark, doll} = useContext(ThemeContext);
    const user = useContext(UserContext);

    return (
        <div className='content' style={{backgroundColor: isDark ? "gray" : "white"}}>
            <p>
                {user}님! 즐거운 하루 되세요!!!
                <img alt='' src={require(`../image/${doll}`)}/>
            </p>
        </div>
    );
};

export default Content;