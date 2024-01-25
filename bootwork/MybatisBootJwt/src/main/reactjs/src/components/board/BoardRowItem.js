import { Image } from '@mui/icons-material';
import React from 'react';
import { NavLink } from 'react-router-dom';

const BoardRowItem = (props) => {
    const {row, idx, no} = props;
    console.log(1);
    console.log(props);
    return (
        <tr>
            <td align='center'>{no-idx}</td>
            <td>
                <NavLink style={{cursor: 'pointer', textDecoration: 'none', color: 'black'}}>
                    {row.subject}
                    &nbsp;
                    <span style={{color: 'gray'}}>
                        {row.photo === '' ? '' : <Image/>}
                    </span>
                </NavLink>
            </td>
            <td align='center'>{row.writer}</td>
            <td align='center'>{row.readcount}</td>
            <td align='center'>{row.writeday.substring(0, 10)}</td>
        </tr>
    );
};

export default BoardRowItem;