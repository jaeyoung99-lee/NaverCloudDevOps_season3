import { DeleteForeverOutlined } from '@mui/icons-material';
import React from 'react';

function FiveRowItem({row, idx, onDelete}) {
    return (
            <tr>
                <td valign='middle'>{idx + 1}</td>
                <td>
                    <img alt='' src={require(`../images/${row.fphoto}`)} width={70} height={70} border='1' hspace='10'/>
                    {row.fname}
                </td>
                <td valign='middle'>{row.fprice}원</td>
                <td valign='middle'>{row.fdate.toLocaleDateString('ko-KR')}</td>
                <td valign='middle'>
                    <DeleteForeverOutlined style={{cursor: 'pointer'}}
                    onClick={() => onDelete(idx)} // 부모 컴포넌트의 deleteData 호출
                    />
                </td>
            </tr>
    );
}

export default FiveRowItem;<tr>
</tr>