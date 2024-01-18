import { Button } from '@mui/material';
import axios from 'axios';
import React, { useRef, useState } from 'react';

const FourGuestForm = ({onGuestSave}) => {
    const [photo, setPhoto] = useState('');
    const [nickname, setNickname] = useState('');
    // const [content, setContent] = useState('');

    // 많은 내용을 입력하는 textarea는 state 변수로 줄 경우 입력 시마다 랜더링이 일어나므로 문제가 발생하기도 함
    // 많은 내용을 입력하는 경우는 ref 변수로 대체하는 게 좋음
    const contentRef = useRef('');

    const imageUrl = "https://kr.object.ncloudstorage.com/bitcamp-701ex/bootmyshop/";

    // 파일 업로드 이벤트
    const onUploadEvent = (e) => {
        const uploadFile = new FormData();
        uploadFile.append("upload", e.target.files[0]);

        axios({
            method:'post',
            url:"/guest/upload",
            data:uploadFile,
            headers:{'Content-Type':'multipart/form-data'}
        }).then(res => {
            setPhoto(res.data); // 실제 스토리지에 올라간 사진 파일명이 반환됨
        })
    }

    // 추가 버튼 이벤트
    const addButtonEvent = () => {
        let content = contentRef.current.value;

        if(nickname.length === 0){
            alert("닉네임을 입력해주세요.");
            return;
        }

        if(content.length === 0){
            alert("내용을 입력해주세요.");
            return;
        }

        // 부모 컴포넌트의 함수로 입력 데이터 보내기
        onGuestSave({nickname, content});

        // 입력 값 초기화
        // setNickname('')Ref;
        setNickname('');
        // setContent('');
        contentRef.current.value='';
        setPhoto('');
    }

    return (
        <div>
            <div style={{width: '400px'}}>
                <input type='file' className='form-control' onChange={onUploadEvent}/>
                <img alt='' src={imageUrl + photo} width={130}/>
                <b>{photo}</b>
            </div>
            <div className='input-group' style={{width: '400px'}}>
                <input type='text' placeholder='닉네임' value={nickname}
                onChange={(e) => setNickname(e.target.value)}
                className='form-control'/>
            </div>

            {/* <textarea className='form-control' placeholder='방명록 내용 입력' 
            onChange={(e) => setContent(e.target.value)} value={content}>
            </textarea> */}
            
            <textarea className='form-control' placeholder='방명록 내용 입력' 
            onChange={(e) => {
                contentRef.current.value = e.target.value;
            }} ref = {contentRef}>
            </textarea>
            <Button color='info' variant='contained'
            onClick={addButtonEvent}>
                추가
            </Button>
        </div>
    );
};

export default FourGuestForm;