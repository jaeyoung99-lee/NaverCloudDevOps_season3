import React, { useReducer, useState } from 'react';
import Student from './Student';

// reducer 설정 시 초기값으로 미리 지정
const initialState = {
    count : 2,
    students : [
        {
        id : new Date(),
        name : '이영자',
        isHere : false
        },
        {
        id : new Date(),
        name : '캔디',
        isHere : true
        }
    ]
}

const reducer = (state, action) => {
    switch(action.type){
        case 'add-student':
            // payload를 통해서 name을 전달받을 것임
            const name = action.payload.name;

            // 추가할 학생 정보 구성
            const addStudent = {
                id : new Date(),
                name, // name : name, -> 변수명이 같을 경우 콜론(:) 뒤를 생략해도 됨
                isHere : false
            }

            const data = {
                count : state.count + 1,
                students : [ 
                    ...state.students,
                    addStudent
                ]
            }

            return data;
        case 'delete-student':
            return {
                count : state.count - 1,
                students : state.students.filter(s => s.id !== action.payload.id)
            };
        case 'mark-student':
            return {
                count : state.count,
                students : state.students.map(s => {
                    if(s.id === action.payload.id){
                        return {
                            ...s,
                            isHere : !s.isHere
                        }
                    }
                    
                    return s;
                })
            };
        default:
            return state;
    }
}

const ReducerTest2 = () => {
    const [name, setName] = useState('');
    const [studentInfo, dispatch] = useReducer(reducer, initialState);

    return (
        <div>
            <h5 className='alert alert-danger'>Reducer 예제 #2</h5>
            <h6>Reducer 학생 관리 시스템</h6>
            <h6>총 학생 수 : {studentInfo.count}</h6>
            <div className='input-group' style={{width: '200px'}}>
                <input type='text' className='form-control' value={name}
                onChange={(e) => setName(e.target.value)}/>
                &nbsp;&nbsp;
                <button type='button' className='btn btn-outline-danger btn-sm'
                onClick={() => dispatch({'type':'add-student', payload:{name}})}>추가</button>
                <hr/>
                {
                    studentInfo.students.map((stu, idx) => 
                    <Student key={idx} stu={stu} dispatch={dispatch}/>)
                }
            </div>
        </div>
    );
};

export default ReducerTest2;