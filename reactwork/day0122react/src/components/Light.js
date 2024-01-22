// 불 껐다 켰다 하는 예제


import React from 'react';

const Light = ({room, on, toggle}) => {
    console.log({room, on});

    return (
        <div>
            <button onClick={toggle}>
                {room}
                {on ? "💡" : "⬛"}    
            </button>
        </div>
    );
};

// export default Light;
export default React.memo(Light);