// 20250306 훅 과제 //

import { useState } from "react"
let count = 0;
export default function Task1() {
    
    // (1) 여기에 state 변수 만들기
    // useState(초기값) -> 초기값은 모든 타입의 자료 가능
    const [msg , setMsg] = useState(' ')
    
    const handleChange = (event) => {
        // (2) 여기에서 state 변수값 수정하기.
        console.log(event.target.value)

        setMsg(event.target.value)
        let str = event.target.value

        count = str.length
        console.log(count)

    }

    // 입력받은 값 배열에 저장하기
    const [msgList , setMsgList] = useState([])

    const 저장함수 = (e) => {
        msgList.push(msg)/ // 입력받은 값이 저장된 state인 msg 를 msgList 에 저장
        setMsgList(msgList) // 오류
        // 배열은 참조타입 자료로 배열 내의 원소가 변경되었어도 참조타입자체인 배열은 새로운 값이 아님
        
        // 해결 방법 : 새로운 배열을 만들어 복사 (map() , 스프레드 연산자 등 사용) //
        setMsgList([...msgList])
    
    }

    return (
        <>
            <h1> input에 입력하면 실시간으로 글자 수 세기</h1>
            <input value={msg} onChange={handleChange}/>
            <p>글자 수: {count} </p>

            <h1> 입력받은 값을 배열에 저장하기 </h1>
            ,<button onClick={저장함수}> 저장 </button>
       </>
    )
}