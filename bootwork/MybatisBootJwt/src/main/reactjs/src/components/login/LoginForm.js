import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Swal from 'sweetalert2';

const LoginForm = () => {
    const [myid, setMyid] = useState('');
    const [pass, setPass] = useState('');
    const [token, setToken] = useState(null);

    useEffect(() => {
        let session_token = sessionStorage.token;
        console.log(session_token);
        setToken(session_token);
    }, []); // 처음 시작 시 한 번만 호출

    const buttonLoginEvent = () => {
        axios.post("/login/auth", {myid, pass})
        .then(res => {
            if(res.data.result === 'noid'){
                Swal.fire("회원 아이디가 아닙니다.");
            }
            else if(res.data.result === 'nopass'){
                Swal.fire("비밀번호가 맞지 않습니다.");
            }
            else{
                // 토큰을 얻어서 세션 스토리지에 token이라는 이름으로 저장
                sessionStorage.token = res.data.token;
                // 아이디도 세션 스토리지에 저장(창 닫는 순간 기록 없애려면 세션 스토리지에 저장하고 창 닫아도 기록 안 없애려면 로컬 스토리지에 저장)
                sessionStorage.myid = myid;
                setToken(res.data.token); // 비동기라서 바로 위에 줄이 먼저 실행될 수 있으므로 res.data.token 대신 sessionStorage.token을 넣으면 안됨
                window.location.reload();
            }
        })
    }

    return (
        <div>
            {
                token == null ?
                <div>
                    <h4 className='alert alert-danger'>로그인 폼</h4>
                    <table className='table table-bordered' style={{width: '250px'}}>
                        <tbody>
                            <tr>
                                <th width={100} style={{backgroundColor: '#ccc'}}>아이디</th>
                                <td>
                                    <input type='text' className='form-control' value={myid}
                                    onChange={(e) => setMyid(e.target.value)}/>
                                </td>
                            </tr>
                            <tr>
                                <th width={100} style={{backgroundColor: '#ccc'}}>비밀번호</th>
                                <td>
                                    <input type='password' className='form-control' value={pass}
                                    onChange={(e) => setPass(e.target.value)}/>
                                </td>
                            </tr>
                            <tr>
                                <td colSpan={2} align='center'>
                                    <button type='button' className='btn btn-outline-success'
                                    onClick={buttonLoginEvent}>
                                        회원 로그인
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                :
                <div>
                    <h4 className='alert alert-danger'>{sessionStorage.myid}님이 로그인 중입니다.</h4>
                    <br/><br/>
                    <img alt='' src={require("../../image/증명사진.png")} style={{width: '130px'}}/>
                    <br/><br/>
                    <button type='button' className='btn btn-danger'
                    onClick={() => {
                        sessionStorage.removeItem("token");
                        setToken(null);
                        setMyid('');
                        setPass('');
                        window.location.reload();
                    }}>
                        로그아웃
                    </button>    
                </div>
            }
        </div>
    );
};

export default LoginForm;