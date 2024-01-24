import React from 'react';

const MemberRowItem = ({row}) => {
    const imageUrl = process.env.REACT_APP_STORAGE;

    return (
        <tr>
            <td style={{width: '250px'}} align='center' valign='middle'>
                <img alt='' src={imageUrl + row.photo}
                style={{width: '150px', border: '1px solid gray'}}/>
            </td>
            <td valign='middle'>
                <b>이름 : {row.name}</b><br/>
                <b>아이디 : {row.myid}</b><br/>
                <b>핸드폰 : {row.hp}</b><br/>
                <b>주소 : {row.addr}</b><br/>
                <b>가입일 : {row.gaipday}</b><br/>
                <br/>
                <button type='button' className='btn btn-outline-danger btn-sm'>
                    회원 삭제
                </button>
            </td>
        </tr>
    );
};

export default MemberRowItem;