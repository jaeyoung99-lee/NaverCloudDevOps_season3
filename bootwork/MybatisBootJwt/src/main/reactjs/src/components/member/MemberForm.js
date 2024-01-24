import { CameraAltOutlined } from '@mui/icons-material';
import axios from 'axios';
import React, { useState } from 'react';
import errimg from '../../image/noimage.jpg';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import DaumPostcodeEmbed from 'react-daum-postcode';
import { useNavigate } from 'react-router-dom';

const MemberForm = () => {
    const [photo, setPhoto] = useState('');
    const [addr, setAddr] = useState('');
    const [open, setOpen] = useState(false); // 다이얼로그 open/close
    const [openPostcode, setOpenPostcode] = useState(false); // 카카오 주소록 open/close
    const [idcheck, setIdcheck] = useState(false); // 아이디 중복 확인을 했는지 체크하기 위한 변수
    const [myid, setMyid] = useState('');
    const [name, setName] = useState('');
    const [pass, setPass] = useState('');
    const [hp, setHp] = useState('');

    const navi = useNavigate();

    const handleClickOpen = () => {
        setOpen(true);
        setOpenPostcode(true);
    };

    const handleClose = () => {
        setOpen(false);
        setOpenPostcode(false);
    };

    // 주소 선택 완료 시 호출될 이벤트
    const selectAddress = (data) => {
        console.dir(data); // dir로 하면 log보다 디테일하게 나옴
        setAddr(`(${data.zonecode}) ${data.address} ${data.buildingName}`);

        // 주소 선택 시 출력 후 카카오 주소록과 다이얼로그를 닫는다.
        handleClose();
    }

    // 네이버 스토리지의 이미지 폴더명
    const imageUrl = process.env.REACT_APP_STORAGE;

    // 파일 업로드 이벤트
    const uploadPhoto = (e) => {
        const uploadFile = new FormData();
        uploadFile.append("upload", e.target.files[0]);
        axios({
            method:"post",
            url:"/member/upload",
            data:uploadFile,
            headers:{'Content-Type' : 'multipart/form-data'}
        }).then(res => {
            setPhoto(res.data); // 사진 변경 - 스토리지에 업로드된 파일명을 서버가 반환
        })
    }

    // 중복 확인 버튼 이벤트
    const buttonIdCheck = () => {
        const url = "/member/idcheck?myid=" + myid;
        axios.get(url)
        .then(res => {
            if(Number(res.data) === 0){
                alert("사용 가능한 아이디입니다.");
                setIdcheck(true);
            }
            else{
                alert("이미 사용중인 아이디입니다.");
                setMyid('');
                setIdcheck(false);
            }
        })
    }

    const saveMemberEvent = () => {
        if(myid.length === 0){
            alert("아이디를 입력 후 중복 확인을 클릭해주세요.");
            return;
        }

        if(!idcheck){
            alert("아이디 중복 확인 버튼을 눌러주세요.");
            return;
        }

        if(name.length === 0){
            alert("이름을 입력해주세요.");
            return;
        }
        if(pass.length === 0){
            alert("비밀번호를 입력해주세요.");
            return;
        }

        // db 저장
        axios.post("/member/insert", {name, myid, pass, hp, addr})
        .then(res => {
            // 멤버 추가 후 어디로 갈지
            navi("/member/list");
        })
    }

    return (
        <div>
            {/* 카카오 주소록을 보기 위한 다이얼로그 */}
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
            >
                <DialogTitle id="alert-dialog-title">
                {"카카오 주소록"}
                </DialogTitle>
                <DialogContent>
                <DialogContentText id="alert-dialog-description">
                    {
                        // 카카오 주소창
                        openPostcode &&
                        <DaumPostcodeEmbed
                            onComplete={selectAddress} // 값을 선택할 경우 실행되는 이벤트
                            autoClose={false} // 값을 선택할 경우 사용되는 DOM을 제거하여 자동 닫힘 설정
                            defaultQuery='' // 팝업을 열 때 검색창의 기본 주소
                        />
                    }
                </DialogContentText>
                </DialogContent>
                <DialogActions>
                <Button onClick={handleClose}>
                    Close
                </Button>
                </DialogActions>
            </Dialog>
            
            <h4 className='alert alert-danger'>회원 가입</h4>
            <table className='table table-bordered' style={{width: '530px'}}>
                <tbody>
                    <tr>
                        <td rowSpan={4} width={200} align='center' valign='middle'>
                            <img alt='' src={imageUrl + photo} border={1} style={{width: '130px', height: '150px'}}
                            onError={(e) => {
                                e.target.src = errimg;
                              }}/>
                            <br/>
                            <input type='file' id='filephoto' style={{display: 'none'}}
                            onChange={uploadPhoto}/>
                            <CameraAltOutlined style={{fontSize: '2em', cursor: 'pointer'}}
                            onClick={() => document.getElementById("filephoto").click()}/>
                        </td>
                        <td width={100} style={{backgroundColor: 'lightgray'}}>이름</td>
                        <td>
                            <input type='text' className='form-control'
                            value={name} onChange={(e) => setName(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td width={100} style={{backgroundColor: 'lightgray'}}>아이디</td>
                        <td className='input-group'>
                            <input type='text' className='form-control' style={{width: '120px'}} value={myid}
                            onChange={(e) => {
                                setIdcheck(false); // 아이디 입력 시 중복 체크 버튼 다시 눌러야 함
                                setMyid(e.target.value);
                            }}/>
                            <button type='button' className='btn btn-sm btn-outline-danger'
                            onClick={buttonIdCheck}>중복확인</button>
                        </td>
                    </tr>
                    <tr>
                        <td width={100} style={{backgroundColor: 'lightgray'}}>비밀번호</td>
                        <td>
                            <input type='password' className='form-control'
                            value={pass} onChange={(e) => setPass(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td width={100} style={{backgroundColor: 'lightgray'}}>핸드폰</td>
                        <td>
                            <input type='text' className='form-control'
                            value={hp} onChange={(e) => setHp(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={3}>
                            <div className='input-group'>
                                <input type='text' className='form-control' style={{width: '400px'}} value={addr}
                                onChange={(e) => setAddr(e.target.value)}/>
                                <button type='button' className='btn btn-sm btn-secondary'
                                onClick={handleClickOpen}>
                                    주소 검색
                                </button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={3} align='center'>
                            <button type='button' className='btn btn-outline-success'
                            onClick={saveMemberEvent}>저장하기</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default MemberForm;