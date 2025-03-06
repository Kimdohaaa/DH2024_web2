// props (컴포넌트의 매개변수) //
// React 를 통해 렌더링할 컴포넌트를 export default 키워드를 통해 지정
// [1] 부모 컴포넌트
export default function Example2(props){
    return(
        <>
            {/* 1) 자식컴포넌트 호출 및 매개변수 전달 */}
            <SubComponent1 name="유재석"/>
            <SubComponent1 name="강호동" age="10"/>
            
            {/* 2) 자식 컴포넌트의 자식요소 전달 : 자식컴포넌트 사이의 innerHTML 값이 props.children 에 대입됨 */}
            {/* ★ 실제 출력 위치는 부모컴포넌트 내가 아닌 자식요소의 props.children 위치에 출력됨 ★ */}
            <SubComponent2>
                {/* 자식 컴포넌트에게 전달되는 자식요소 */}
                여기가 props.children 구역 
            </SubComponent2>
            <SubComponent2>
                {/* 자식 컴포넌트에게 전달되는 자식요소 */}
                <button> 부모컴포넌트가 전달한 button 마크업 </button>
            </SubComponent2>

            {/* 3) 구문 분해*/}
            <SubComponent3 name="유재석" age="40"/>
            <SubComponent3 name="강호동" age="50"/>

            {/* 2) 구문 분해를 이용한 매개변수의 기본값 지정*/}
            <SubComponent4/> {/* 인자값을 자식컴포넌트로 전달하지 않을 시 기본값 지정 */}
            <SubComponent4 nation="미국"/> 
        </>
    )
}

// [2] 자식 컴포넌트의 매개변수
function SubComponent1(props){ // 부모컴포넌트가 보낸 인자값을 매개변수로 받음
    console.log(props)
    // props.name = "하하" // 불가 : props 는 읽기모드만 가능
    return(
        <>
            <h3> {props.name} 안녕 </h3>
            <h3> 나이 : {props.age} </h3>
        </>
    )
}

// [3] 자식 컴포넌트의 자식요소
function SubComponent2(props){
    console.log(props)
    return(
        <>
            {/* children : props 매개변수 내 자식요소 불러오기 */}
            <h3> {props.children} </h3>
        </>
    )
}

// [4] 구문 분해 : {name(사용하고싶은 속성명)} = {name : "" , age : ""}
/*    
function SubComponent3(props){ // props 를 매개변수로 받을 때 구문 분해를 사용하지 않은 경우
    return(
        <> 
            {props.name} 님 나이는 {props.age} 살
        </>
    )
}
*/
function SubComponent3({name , age}){ // props 를 매개변수로 받을 때 구문 분해를 사용한 경우
    return(
        <>
            <h3> {name} 님 나이는 {age} 살 </h3>
        </>
    )
}

// [5] 구문 분해를 이용한 props 의 기본값 지정
function SubComponent4({nation = "대한민국"}){ // 부모컴포넌트로부터 전달받은 props 의 기본값 지정
                                              // 부모 컴포넌트가 해당 값을 매개변수로 보내지 않을 시 기본갑 대입
    return(
        <>
            <h3> {nation} 매개변수 기본값 지정</h3>
        </>
    )

}
