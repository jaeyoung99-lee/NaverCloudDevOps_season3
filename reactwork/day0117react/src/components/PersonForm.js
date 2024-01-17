import React, { useState } from 'react';

const PersonForm = ({onSave}) => {
    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    const [blood, setBlood] = useState('A');
    const [photo, setPhoto] = useState('1.jpg');

    // 추가 버튼 이벤트
    const addButtonEvent = () => {
        if(isNaN(age)){
            alert("나이는 숫자로만 입력해주세요");
            return;
        }

        // 부모 컴포넌트의 메서드를 통해서 입력한 데이터를 보낸다.
        onSave({name, age, blood, photo});

        // 초기화
        setName('');
        setAge('');
    }

    return (
        <table className='table table-bordered' style={{width: '450px'}}>
            <tbody>
                <tr>
                    <th style={{width: '100px', backgroundColor: 'pink'}}>이름</th>
                    <td>
                        <input type='text' className='form-control' style={{width: '130px'}}
                        value={name}
                        onChange={(e) => setName(e.target.value)}/>
                    </td>
                    <th style={{width: '100px', backgroundColor: 'pink'}}>나이</th>
                    <td>
                        <input type='text' className='form-control' style={{width: '130px'}}
                        value={age}
                        onChange={(e) => setAge(e.target.value)}/>
                    </td>
                </tr>
                <tr>
                    <th style={{width: '100px', backgroundColor: 'pink'}}>혈액형</th>
                    <td>
                        <select className='form-select'
                        onChange={(e) => setBlood(e.target.value)}>
                            <option>A</option>
                            <option>B</option>
                            <option>O</option>
                            <option>AB</option>
                        </select>
                    </td>
                    <th style={{width: '100px', backgroundColor: 'pink'}}>사진</th>
                    <td className='input-group'>
                        <img alt='' src={require(`../images/${photo}`)} width={30}/>
                        <select className='form-select'
                        onChange={(e) => setPhoto(e.target.value)}>
                            {
                                [...new Array(20)].map((a, i) => (
                                <option key={i}>{i + 1}.jpg</option>)) 
                            }
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colSpan={4} align='center'>
                        <button type='button' className='btn btn-outline-danger'
                        onClick={addButtonEvent}>
                            DB에 추가하기
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
    );
};

export default PersonForm;