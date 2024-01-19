import { ArrowBack, EditNote } from '@mui/icons-material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const PersonDetail = () => {

    const {pnum} = useParams();
    const navi = useNavigate();
    const [selectData, setSelectData] = useState('');

    // pnum에 대한 dto를 얻어서 selectData에 넣기
    const getSelectData = () => {
        const url = "/person/select?pnum=" + pnum;
        axios.get(url)
        .then(res => {
            setSelectData(res.data);
        })
    }

    // 처음 로딩 시 딱 한 번 호출
    useEffect(() => {
        console.log("detail, useEffect")
        getSelectData();
    }, []);

    return (
        <div className='mainbox'>
            <div>
                <h2><b>{selectData.name}</b>님의 개인 정보</h2>
                {
                    selectData.photo && <img alt='' src={require(`../images/${selectData.photo}`)} style={{maxWidth: '350px'}}/>
                }
                <hr/>
                <h6>혈액형 : {selectData.blood}형
                <EditNote style={{fontSize: '2em', float: 'right', cursor: 'pointer'}}
                onClick={() => navi(`/updateform/${selectData.pnum}`)}/>
                </h6>
                <h6>나이 : {selectData.age}세</h6>
                <h6>가입일 : {selectData.writeday}
                <ArrowBack 
                // -1 : 이전 페이지로 이동
                // onClick={() => navi(-1)}
                //목록으로 이동
                onClick={()=>navi("/")}
                style={{fontSize: '2em', float: 'right', cursor: 'pointer'}}/> 
                </h6>
            </div>
        </div>
    );
};

export default PersonDetail;