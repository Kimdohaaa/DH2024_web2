import  { useState } from 'react';

import Table from '@mui/joy';

export default function Example2 (){
    const [open, setOpen] = useState(false);

    return(
        <>
            <h3> 테이블 </h3>
            
            <Table aria-label="basic table">
                <thead>
                    <tr>
                    <th style={{ width: '40%' }}>Dessert (100g serving)</th>
                    <th>헤헤헿</th>
                    <th>하하핳</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Frozen yoghurt</td>
                        <td>159</td>
                        <td>6</td>
                    </tr>
                    <tr>
                        <td>Ice cream sandwich</td>
                        <td>237</td>
                        <td>9</td>
                    </tr>
               </tbody>
            </Table>

           
        </>
    )
}