import { useState } from "react";

let a = 0 ;
export default function Example2(props){
    let b = 0;
    
    a++;
    b++

    console.log(`전역변수 :  ${a}`)
    console.log(`지역변수 :  ${b}`)

    // 증가함수
    const 증가함수1 = () => { 
        a++;
        b++
        console.log(a,b)
    }


    // ------- 훅 사용 ------- //
    // (1) state 변수 사용 : useState() => 훅 종류 중에 핵심 함수
    let c = useState(0); // state 상태 변수 선언 => 배열로 반환
    console.log(c) // 배열로 반환됨
    console.log(c[0]); // [0]->변수값
    console.log(c[1])  // [1]->변수값을 수정할 수 있는 함수 제공

    const 증가함수2 = () => {
        c[1](c[0]++) // 증가2 버튼 클릭 시 컴포넌트(함수)가 재실행
                     // a 는 전역변수로 컴포넌트 재실행에 관계가 없기 때문에 값이 계속 누적되어 값 증가
                     // b 는 지역변수로 컴포넌트 재실행 시 0으로 초기화 되기 때문에 값 증가 X
                     // c 는 지역,전역변수가 아닌 리액트가 별도로 상태(값)을 저장 / 관리 해줌 (의존성)
    }


    // (2) state 변수의 일반적인 사용법 -> 구문 분해
        // 형식 : const [변수명 , set 변수명] = useState(초기값)
        const [ count , setCount  ] = useState( 0 );

    const 증가함수3 = () => {
        console.log(count) // 출력 : 0
        // count = count + 1; // 1 증가 => state 변수가 const 일 경우 사용 불가
        console.log(count) // 출력 : ++

        // 렌더링
        // const 일 경우 ++ 이 아닌 + 1 로 증가
        setCount(count + 1) // setXXX(새로운 값) ★ 새로운 값만 가능
        

    }
    return(
        <>
            <div> 일반변수 : {a} , {b} </div>
            <button type="button" onClick={증가함수1}> 증가1 </button>


            <div>
                <p> state 변수1 : {c} </p>
                {/* 증가2 버튼 클릭 시 전역변수 a 와 state 변수 c 증가 */}
                <button type="button" onClick={증가함수2}> 증가2 </button>
            </div>
        
            <div>
                <p> state 변수2 : { count } </p>
                <button onClick={ 증가함수3 } > 증가3 </button>
            </div>
        </>
    )
}
// 컴포넌트(함수)가 한번 return 한 결과(HTML) 은 불변성 => 증가 버튼을 클릭해도 HTML 에 반영 X
