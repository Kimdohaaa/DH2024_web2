import { useEffect, useState } from "react"

export default function Example1(props){
    // [1] useEffect() 
    // 형식 : useEffect(이펙트 함수 정의 , 의존성 배열)

    // (1) 의존배열이 없을 때 : 어떤 값이 업데이트 되든 무조건 재렌더링됨
    useEffect(() => {
        console.log("이펙트 함수 실행 1")
        // 실행 시점
        // 1. 생성 (최초 실행 시)
        // 2. 재렌더링(업데이트)
    }) 


    // (2) 의존성 배열이 빈 배열 일 때 : 재렌더링이 아닌 컴포넌트가 최초 한번만 실행해야할 때 사용
    useEffect(() => {
        console.log("이펙트 함수 실행 2")
        // 실행 시점
        // 1. 생성 (최초 실행 시)

    }, [])

    // (3) 의존성 배열에 state 변수가 존재 할 때 : 의존성 배열에 존재하는 state 변수가 변경될 때만 재실행 됨
    // => 업데이트 2 버튼이 onClick 됐을 때 해당 state 변수는 의존성배열에 존재하지 않기 때문에 실행되지 않음
    const [count1 , setCount1] = useState(0);

    useEffect(() => {
        console.log("이펙트 함수 실행  3")
        // 실행 시점
        // 1. 생성 (최초 실행 시)
        // 2. 재렌더링(업데이트)
    }, [count1])


    const [count2, setCount2] = useState(0);

    return(
        <>
            {/* 업데이트1 버튼 클릭 시 (1) 과 (2) 가 실행됨*/}
            <button onClick={(e) => {setCount1(count1+1)}}> 업데이트1 </button>
            {/* 업데이트2 버튼 클릭 시 (1)이 실행됨 -> (3) 의 경우 의존성 배열에 count2 가 없기 때문*/}
            <button onClick={(e) => {setCount2(count2+1)}}> 업데이트2 </button>
        </>
    )
}