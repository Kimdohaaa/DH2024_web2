// 20250306 훅 과제 //

import { useState } from "react"
let count = 0;
export default function Task1() {
    
    // (1) 여기에 state 변수 만들기
    const [msg , setMsg] = useState(' ')
    
    const handleChange = (event) => {
        // (2) 여기에서 state 변수값 수정하기.
        console.log(event.target.value)

        setMsg(event.target.value)
        let str = event.target.value

        count = str.length
        console.log(count)

    }

    return (
        <>
            <h1> input에 입력하면 실시간으로 글자 수 세기</h1>
            <input value={msg} onChange={handleChange}/>
            <p>글자 수: {count} </p>
        </>
    )
}