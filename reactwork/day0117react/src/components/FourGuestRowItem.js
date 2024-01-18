import { DeleteForeverOutlined } from '@mui/icons-material';
import React from 'react';

const FourGuestRowItem = ({item, onDelete}) => {

    // .env(공통된 환경변수 등록) - 가져오는 방법
    const imageStorage = process.env.REACT_APP_STORAGE;

    // 삭제 이벤트에서 호출할 함수
    const deleteData = (gnum) => {
        let answer = window.confirm("삭제할까요?");
        if(answer) {
            onDelete(gnum);
        }
    }

    return (
        <div style={{border: '2px groove gray', width: '400px', height: 'auto', padding: '10px', margin: '10px', borderRadius: '30px'}}>
            <span><b>{item.nickname}</b></span>
            <DeleteForeverOutlined style={{marginLeft: '20px', cursor: 'pointer'}} 
            onClick={() => {
                deleteData(item.gnum);
            }}/>
            <span style={{color: 'gray', fontSize: '0.8em', float: 'right'}}>
                {item.writeday}
            </span>
            <br/>
            <img alt='' src={imageStorage + item.photo} style={{width: '200px'}}/>
            <pre style={{marginTop: '10px', fontWeight: 'bold'}}>
                {item.content}
            </pre>
        </div>
    );
};

export default FourGuestRowItem;