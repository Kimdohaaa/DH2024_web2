import { useState } from "react";

export default function Example3(props){

    // (1) 기존 방식 : 일반적인 JS 방식
    const 입력함수1 = () => {
        const msg = document.querySelector("#msg1").value;
        console.log(msg)
    }

    // (2) 리액트 방식 (훅 라이브러리의 useState() 메소드 사용)
    // 1_state(상태)변수 선언
    const [msg , setMsg] = useState('') // state(상태) 변수 : 변수값에 따른 컴포넌트 렌더링(새로고침) 제공 
    
    // 2_state 변수를 사용하는 메소드
    const 입력함수2 = (eventObj) => {
        
        console.log(eventObj) // onChange() 함수 실행 후 실행의 결과값(객체)
        console.log(eventObj.target) // target : onChange() 이벤트 함수를 발생 시킨 마크업(대상) 반호나
        console.log(eventObj.target.value) // value : onChange() 이벤트 함수를 발생시킨 마크업(대상)의 value 반환
        
        setMsg(eventObj.target.value)
    }
    // 3_장점 : 사용자 입력한 input 값을 리액트에서 관리(의존성) => AXIOS 로 통신 시 편리


    // (3) 리액트 상태 변경 (이미지)
    const [image , setImage] = useState("강아지1.jpg") // 이미지를 저장하는 state 변수 선언 (초기값으로 임의의 이미지 지정)

    const 변경함수 = () => {
        // setXXX() : state 변수의 값이 변경되면 자동으로 렌더링 => 리액트 UI 업데이트
        setImage(image == "강아지1.jpg" ? "강아지2.jpg" : "강아지1.jpg")
    }
    return(
        <>
            <h3> 일반적인 JS 방식 </h3>
            <input id="msg1"/>
            <button onClick={ 입력함수1 }> 입력1 </button>
        
            <h3> 리액트 JS 방식 </h3>
            {/* value : input 에 입력된 값 */}
            {/* value 에 실제 값을 넣어놓을 시 수정 불가 -> 불변성 때문 */}
            <input value={msg} id="msg2" onChange={ 입력함수2 }/> 

            <h3> 리액트의 상태 변경(이미지) </h3>
            {/* 두 방식이 동일 */}
            {/* 다회성 -> 이름 부여 */}
            <img onClick={ 변경함수 } src={image} />
            {/* 일회성 */}
            <img onClick={ () => {setImage(image == "강아지1.jpg" ? "강아지2.jpg" : "강아지1.jpg")} } src={image} />

        </>
    )

}
/*

[이벤트 함수]

- HTML 이벤트 함수 : HTML 에서 미리 만들어서 제공하는 함수
- 종류 
    1) onclick() : HTML 마커업 클릭 시 클릭 이벤트 함수 실행
    2) onchange() ; HTML 마크업의 값이 변경되엇을 때 변경 이벤트 함수 실행
    ~~~ 등등 ~~~
- 이벤트 함수는 반환값을 제공함 -> 이벤트 함수가 실행된 결과를 객체로 반환
    예] onclick{(e) => { }} => HTML onclick() 함수 실행 후 e(실행결과)를 다음 함수에게 매개변수로 전달

[HTML 이벤트 함수 와 JSX(리액트) 이벤트 함수의 차이점]
1. JSX 에서는 카멜표기법이 필수 
2. JSX 에서는 { } 안에 함수명을 작성하여 함수를 실행

*/