import { Button } from '@mui/material';
import React, { useState } from 'react';

function FiveWriteForm({onSave}) {
    const [fname, setFname] = useState('');
    const [fphoto, setFphoto] = useState('2.jpg');
    const [fprice, setFprice] = useState(0);

    // 추가 이벤트
    const onAddEvent = () => {
        onSave({fname, fphoto, fprice});

        // 초기화
        setFname('');
        setFprice(0);
    }

    return (
        <div className='input-group'>
            메뉴명 :&nbsp;<input type='text' value={fname} onChange={(e) => setFname(e.target.value)} style={{width: '80px'}}/>&nbsp;&nbsp;
            가격 :&nbsp;<input type='text' value={fprice} onChange={(e) => setFprice(e.target.value)} style={{width: '70px'}}/>&nbsp;&nbsp;
            사진 :&nbsp;
            <select onChange={(e) => setFphoto(e.target.value)}>
                <option value={"2.jpg"}>꼬치 종류</option>
                <option value={"4.jpg"}>카레 종류</option>
                <option value={"8.jpg"}>샌드위치 종류</option>
                <option value={"11.jpg"}>빙수 종류</option>
            </select>
            &nbsp;&nbsp;
            <Button color='warning' variant='outlined' size='small' onClick={onAddEvent}>
                추가
            </Button>

        </div>
    );
}

export default FiveWriteForm;