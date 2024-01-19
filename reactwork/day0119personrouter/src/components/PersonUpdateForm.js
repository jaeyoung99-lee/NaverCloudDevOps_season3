import { ArtTrack, Update } from '@mui/icons-material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const PersonUpdateForm = () => {
    const {pnum} = useParams();
    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    const [blood, setBlood] = useState('A');
    const [photo, setPhoto] = useState('1.jpg');
    const [selectData, setSelectData] = useState([]);

    const navi = useNavigate();

    useEffect(() => {
        // 해당 pnum에 대한 데이터를 가져와서 상태 업데이트
        axios.get("/person/select?pnum="+ pnum)
            .then(res => {
                const data = res.data;
                setSelectData(data);
                setName(data.name);
                setAge(data.age);
                setBlood(data.blood);
                setPhoto(data.photo);
            })
            .catch(error => {
                // 오류 처리
                console.error("Error fetching data:", error);
            });
    }, [pnum]);

    // 수정 버튼
    const updateDataEvent = () => {
        // axios를 이용해서 데이터 전송 후 목록으로 이동
        axios.post("/person/update", {name, age, photo, blood, pnum})
        .then(res => {
            // 추가 성공 후 목록으로 이동
            navi("/");
        })
    }
    return (
        <div className='mainbox'>
            <div style={{marginTop: '20px'}}>
                <table className='table table-bordered'>
                    <tbody>
                        <tr>
                            <th style={{width: '100px', backgroundColor: '#CCC'}}>
                                이름
                            </th>
                            <td>
                                <input type='text' value={name} style={{width: '150px'}} className='form-control'
                                onChange={(e) => setName(e.target.value)}/>
                            </td>
                        </tr>
                        <tr>
                            <th style={{width: '100px', backgroundColor: '#CCC'}}>
                                나이
                            </th>
                            <td>
                                <input type='text' value={age} style={{width: '150px'}} className='form-control'
                                onChange={(e) => setAge(e.target.value)}/>
                            </td>
                        </tr>
                        <tr>
                            <th style={{width: '100px', backgroundColor: '#CCC'}}>
                                혈액형
                            </th>
                            <td>
                                <select className='form-select' style={{width: '150px'}}
                                onChange={(e) => setBlood(e.target.value)}>
                                    <option>A</option>
                                    <option>B</option>
                                    <option>O</option>
                                    <option>AB</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th style={{width: '100px', backgroundColor: '#CCC'}}>
                                사진
                            </th>
                            <td className='input-group'>
                                <img alt='' src={require(`../images/${photo}`)} style={{width: '80px', marginRight: '10px'}}/>
                                <select className='form-select' style={{width: '150px', height: '40px'}} value={photo}
                                onChange={(e) => setPhoto(e.target.value)}>
                                    {
                                     [...new Array(20)].map((a, idx) => (<option>{idx + 1}.jpg</option>))   
                                    }
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colSpan={2} align='center'>
                                <button className='btn btn-outline-secondary'
                                    onClick={updateDataEvent}>
                                    <Update/>
                                    <span style={{marginLeft: '10px'}}>수정</span>
                                </button>

                                <button className='btn btn-outline-secondary' style={{ marginLeft: '10px' }}
                                    onClick={() => navi("/")}>
                                    <ArtTrack/>
                                    <span style={{marginLeft: '10px'}}>목록</span>
                                </button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default PersonUpdateForm;