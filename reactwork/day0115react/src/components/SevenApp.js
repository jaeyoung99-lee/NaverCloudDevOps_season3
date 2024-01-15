// 테이블 사용하여 배열 출력


import React, { useState } from 'react';

function SevenApp(props) {
    const [array, setArray] = useState([
        {title : "귀여운 해적 춘식이", price: '23000', color: 'black', photo: '해적'},
        {title : "귀여운 호랑이 춘식이", price: '14000', color: 'orange', photo: '호랑이'},
        {title : "귀여운 훌라후프 춘식이", price: '35000', color: 'yellow', photo: '훌라후프'},
        {title : "귀여운 산타 춘식이", price: '43000', color: 'red', photo: '산타'},
    ]);

    // const [data, setData] = useState('');

    return (
        <div>
            <h3 className='alert alert-danger'>SevenApp - 배열 출력</h3>
            <table className='table table-bordered' style={{width: '400px'}}>
                <tbody>
                    {
                        array.map((item, i) => (
                            <tr key={i}>
                                <td style={{width: '150px'}}>
                                    <img alt='' src={require(`../images/${item.photo}.png`)} width={130}/>
                                </td>
                                <td>
                                    제목 : {item.title}<br/>
                                    가격 : {item.price}원<br/>
                                    색상 : <b style={{backgroundColor: item.color, color: item.color}}>{item.color}</b> {item.color}<br/><br/>
                                    <button type='button' 
                                    className='btn btn-danger btn-sm'
                                    onClick={() => {
                                        setArray(array.filter((a, idx) => (i !== idx)))
                                    }}>
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
}

export default SevenApp;