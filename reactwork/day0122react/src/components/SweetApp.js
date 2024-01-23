import React, { useState } from 'react';
import img1 from '../image/C1.png';
import img2 from '../image/C2.png';
import img3 from '../image/C3.png';
import img4 from '../image/C4.png';
import img5 from '../image/C5.png';
import { Button } from '@mui/material';
import Swal from 'sweetalert2';

const SweetApp = () => {
    const [sangpum, setSangpum] = useState("체크자켓");

    return (
        <div>
            <h3 className='alert alert-danger'>SweetAlert 사용법</h3>
            <hr/>
            <Button variant='outlined' color='warning'
            onClick={() => {
                Swal.fire("안녕하세요!");
            }}>
                기본 Alert
            </Button>
            <br/><br/>
            <Button variant='outlined' color='error'
            onClick={() => {
                Swal.fire({
                    title : "Swal Test",
                    html : "오늘은 즐거운<br/>월요일<br/>아침부터 눈이 왔어요!<br/>행복했어요!!",
                    // html 태그가 없으면 html 대신 text 쓰면 됨
                    icon : "warning",
                    confirmButtonText : "확인",
                    confirmButtonColor : "#3085d6",
                    cancelButtonText : "취소",
                    cancelButtonColor : "#pink",
                    showCancelButton : true
                }).then(result => {
                    if(result.isConfirmed){
                        Swal.fire("시키는대로 처리했어요!");
                    }
                    else{
                        Swal.fire("취소했어요!");
                    }
                });
            }}>
                확인, 취소 Alert
            </Button>
            <br/><br/>
            <button type='button' className='btn btn-success'
            onClick={() => {
                Swal.fire({
                    title : "사진 넣기",
                    html : `<h5>사진을 넣어볼까요!!</h5>`,
                    imageUrl : img1,
                    imageWidth : 70,
                    imageHeight : 80,
                    showCancelButton : true,
                    confirmButtonText : "삭제",
                    cancelButtonText : "삭제 취소"
                })
            }}>
                사진 넣기
            </button>
            <br/><br/>
            <button type='button' className='btn btn-info btn-sm'
            onClick={() => {
                Swal.fire({
                    title : "Input Your Email",
                    input : "email",
                    inputLabel : "Your Email Address",
                    inputPlaceholder : "Enter Your Email Address"
                }).then(result => {
                    Swal.fire(`당신의 이메일 주소는 [${result.value}]`);
                })
            }}>
                이메일
            </button>
            <br/><br/>
            <button type='button' className='btn btn-success'
            onClick={() => {
                Swal.fire({
                    icon : "info",
                    title : "상품 삭제",
                    text : `${sangpum} 상품을 삭제하시겠습니까?`,
                    showCancelButton : true,
                    confirmButtonText : "삭제",
                    cancelButtonText : "취소"
                }).then(result => {
                    if(result.isConfirmed){
                        Swal.fire(`${sangpum} 상품을 삭제했습니다.`);
                    }
                    else{
                        Swal.fire(`${sangpum} 상품 삭제를 취소했습니다.`);
                    }
                })
            }}>
                상품 삭제
            </button>
            <br/><br/>
            <button type='button' className='btn btn-warning'
            onClick={() => {
                let arr = [
                    {photo : img1, msg : "영숙"},
                    {photo : img2, msg : "상철"},
                    {photo : img3, msg : "영자"},
                    {photo : img4, msg : "영철"},
                    {photo : img5, msg : "순자"}
                ];
                
                let s = "";
                
                for(let m of arr){
                    s += 
                        `
                        <img alt='' src=${m.photo} width={40}/><b>${m.msg}</b><br/>
                        `;
                }

                Swal.fire({
                    icon : "warning",
                    title : "좋아요 누른 사람",
                    html : s
                })
            }}>
                배열 출력
            </button>
        </div>
    );
};

export default SweetApp;