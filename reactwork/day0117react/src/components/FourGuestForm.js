import axios from 'axios';
import React, { useState } from 'react';

const FourGuestForm = () => {
    const [photo, setPhoto] = useState('');
    const [nickname, setNickname] = useState('');
    const [content, setContent] = useState('');

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

    return (
        <div style={{width: '400px'}}>
            <input type='file' className='form-control' onChange={onUploadEvent}/>
            <img alt='' src={imageUrl + photo} width={130}/>
            <b>{photo}</b>
        </div>
    );
};

export default FourGuestForm;