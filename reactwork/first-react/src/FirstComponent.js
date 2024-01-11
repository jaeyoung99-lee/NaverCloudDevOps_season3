import React from "react";
import './MyStyle.css';
import kimdh from './kimdh.png';
import 치타 from './치타.png';

let FirstComponent = () => {
    return(
        <div className="box">
            <h3 className="alert alert-danger">FirstComponent 컴포넌트</h3>
            <h6>public의 이미지 나타내기</h6>
            {/* public 이미지는 직접 경로로 지저애야 함 - 권장 안함 */}
            <img alt = "" src="./꾸벅인사.gif" style={{border: '3px solid pink', width: '100px'}}/>
            <h6>src의 이미지 나타내기</h6>
            <img alt = "" src={kimdh} style={{border: '3px solid pink', width: '100px'}}/>
            <img alt = "" src={치타} style={{border: '3px solid pink', width: '100px', marginLeft: '10px'}}/>
        </div>
    )
}

export default FirstComponent;