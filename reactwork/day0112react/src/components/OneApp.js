// 이미지, 스타일, 클래스


// 초기 리액트는 컴포넌트가 클래스로 구현되어 있다.

import React, {Component} from "react";
import './MyStyle.css';
import 고구마 from '../images/고구마.png';
import 고윤정 from '../images/고윤정 단독.png';

// class OneApp extends Component // 아래와 동일하게 사용 가능
class OneApp extends React.Component{
    // class에서 변경 가능한 state 변수 선언하는 방법
    // ES6에서 생성자 선언하는 방법
    constructor(){
        super(); // super 생략 시 오류
        this.state = {
            number: 0
        }
    }

    render(){
        
        // style을 변수로 지정한 후 적용하는 방법
        const imgStyle = {
            border: '2px solid green',
            width: '130px',
            boxShadow: '3px 3px 3px gray'
        }

        const fontStyle = {
            color: 'gray',
            fontFamily: 'Single Day',
            marginTop: '20px'
        }

        const message = "Have a Good Day!!"; // 변경이 필요없는 메시지 변수 선언

        return(
            <div className="box" style={{backgroundColor: 'pink'}}>
                <h3 className="alert alert-danger">
                    OneApp
                    <img alt="" src = {고구마} style={{width: '60px', float: 'right'}}/>
                </h3>
                {/* 변수를 style에 지정하는 방법 */}
                <img alt="" src = {고윤정} style={imgStyle}/>
                <h2 style={fontStyle}>{message}</h2>

                <div style={{fontSize: '40px', color: 'red', marginLeft: '30px'}}>
                    {/* class일 경우 state 변수 출력하는 방법 */}
                    {this.state.number}
                </div>

                <button type="button" className="btn btn-outline-danger" 
                onClick={() => {
                    // number 값 1씩 증가
                    this.setState({
                        number: this.state.number + 1
                    })
                }}>number 증가</button>
            </div>
        )
    }
}

// export default OneApp; // default는 단 한 번만 가능(컴포넌트 하나만 가능), import 시에 임의로 이름 지정
export {OneApp} // default가 빠진 export는 여러번 export 가능, import 시에 {OneApp}으로 import, 이름 변경 안됨