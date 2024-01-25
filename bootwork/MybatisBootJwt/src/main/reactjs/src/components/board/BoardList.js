import React from 'react';
import { useNavigate } from 'react-router-dom';

const BoardList = () => {
    const navi = useNavigate();

    return (
        <div>
            <h4 className='alert alert-danger'>
                게시판 목록
                {
                    sessionStorage.token &&
                    <button type='button' className='btn btn-info'
                    onClick={() => navi("/board/form")}
                    style={{float: 'right'}}>
                        글쓰기
                    </button>
                }
            </h4>
        </div>
    );
};

export default BoardList;