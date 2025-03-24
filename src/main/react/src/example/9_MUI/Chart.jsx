import * as React from 'react';
import { BarChart } from '@mui/x-charts/BarChart';
import { LineChart } from '@mui/x-charts/LineChart';

export default function Example3() {
    return(
        <>
        <h3> Bar </h3>
         <BarChart
            xAxis={[{ scaleType: 'band', data: ['인사팀', '영업팀' , '개발팀'] }]}
            series={[
                     { data: [60, 50 , 30] }
                    ,{ data: [70, 90 , 103] }
                    ,{ data: [90, 80 , 110] }
                    ,{ data: [80, 90 , 80] }
                ]}
            width={500}
            height={300}
        />

        <h3> Line </h3>
        <LineChart
            xAxis={[{ scaleType : 'band' , data: ["2023","2024", "2025"] }]}
            series={[
                {
                data: [90, 87, 130],
                },
            ]}
            width={500}
            height={300}
            />
        </>
    )
}