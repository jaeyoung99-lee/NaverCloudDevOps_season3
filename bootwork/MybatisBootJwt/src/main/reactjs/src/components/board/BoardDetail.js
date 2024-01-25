import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const BoardDetail = () => {
    const [selectData, setSelectData] = useState('');
    const {num} = useParams();
    const navi = useNavigate();
    const imgUrl = process.env.REACT_APP_STORAGE;

    const getSelectPage = () => {
        const url = "/board/detail?num=" + num;

        axios.get(url)
        .then(res => {
            setSelectData(res.data);
        })
    }
    
    useEffect(() => {
        getSelectPage();
    }, []);

    return (
        <div>
            {
                selectData &&
                <div style={{margin: '50px', width: '700px'}}>
                    <h3><b>{selectData.subject}</b></h3>
                    <div className='input-group'>
                        <h5>
                            {selectData.writer}({selectData.myid})
                        </h5>
                        <span style={{marginLeft: '100px', color: 'gray'}}>
                            조회 {selectData.readcount}
                        </span>
                        <span style={{marginLeft:'100px',color:'gray'}}>
                            {selectData.writeday}
                        </span>
                    </div>
                    <div className='input-group' style={{marginTop:'20px'}}>
                        {
                            selectData.photo == '' ? "" :
                            <img alt='' src={imgUrl + selectData.photo}
                            style={{maxWidth: '300px'}}/>
                        }                    
                    </div>
                    <pre style={{fontWeight: 'bold', marginTop: '20px'}}>{selectData.content}</pre>
                    
                    <br/><br/>
                    
                    <button type='button' className='btn btn-outline-secondary btn-sm'
                    style={{width: '80px'}} onClick={() => navi("/board/list")}>
                        목록
                    </button>
                    <button type='button' className='btn btn-outline-secondary btn-sm'
                    style={{width: '80px', marginLeft: '5px'}} onClick={() => navi("/board/form")}>
                        글쓰기
                    </button>
                </div>
            } 
        </div>
    );
};

export default BoardDetail;