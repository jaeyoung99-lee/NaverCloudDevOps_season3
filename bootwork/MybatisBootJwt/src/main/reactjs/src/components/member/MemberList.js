import axios from 'axios';
import React, { useEffect, useState } from 'react';
import MemberRowItem from './MemberRowItem';

const MemberList = () => {
    const [memberlist, setMemberlist] = useState([]);

    const getMemberlist = () => {
        axios.get("/member/list")
        .then(res => {
            setMemberlist(res.data.mlist);
        })
    }

    useEffect(() => {
        getMemberlist();
    }, []);

    return (
        <div>
            <h3 className='alert alert-danger'>회원 목록 (총 {memberlist.length}명)</h3>
            <br/>
            <table className='table table-bordered'>
                <tbody>
                    {
                        memberlist &&
                        memberlist.map((row, idx) => (
                            <MemberRowItem  key={idx} row={row}/>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
};

export default MemberList;