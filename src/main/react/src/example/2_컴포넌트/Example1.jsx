
// export default 를 통해 해당 함수를 반환 함수로 지정
export default function Example1(props){
    // ------- JSX 문법 s ------- // 
    return (
        <div>
            {/* JSX 주석 */}
            <h3> 컴포넌트 </h3>
            {/* 다른 컴포넌트 호출*/}
            <Component1/>
            <Component2/> 
            <Component3/>
            <Component4/>
            <Component5/>
            <Component6/>
            <Component7/>
        </div>

    )
    // ------- JSX 문법 e ------- //
}

// [1] 한 줄 코드 작성
function Component1(props){
    return <h4> 한 줄로 입력 시 () 생략 가능 </h4>
}

// [2] 여러 줄 코드 작성
function Component2(props){
    return(
        <div>
            <h4> 두줄로 입력 시 () 로 감싸야 함 </h4>
        </div>
    )
}

// [3] 의미없는 마크업을 통해 JSX 코드 작성
function Component3(props){
    return <> <h4> 의미없는 마크업 을 통해 JSX 문법 감싸기 가능 </h4> </>
}

// [4] 객체 사용
function Component4(props){
    const name = '유재석';
    const age = 40;
    const obj = {name : "강호동", age : 30}

    return(
        <>
            {/* JSX 문법에서는 $ 없이 { } 만 사용 */}
            <h4> {name} 님의 나이 : {age} </h4>
            <h4> {obj.name} 님의 나이 : {obj.age} </h4>
        </>
    )
}

// [5] 삼항 연산자
function Component5(props){
    const loginState = true; // 로그인 상태

    return(
        <>
            {/* JSX 문법에서 {} 안에서 for, if , const 등 선언부 불가*/}
            {/* 삼항 연산자는 가능 */}
            <h4> {loginState == true ? "로그인" : "비로그인"} </h4>
            <h4> {loginState && <p> 로그인 상태일 때만 출력 </p>}</h4>
        </>
    )
}

// [6] map()
function Component6(props){
    const items = ['사과', '딸기', '바나나' ]

    // JSX 문법의 목록(li, option 등) 마크업에서는 key 속성 필수!!
    // => 리액트는 자동렌더링(새로고침) 시 key 의 변화를 감지하여 변화된 key 만 별도로 렌더링하는 기능이 포함되어있기 때문
    // => key 값을 넣지 않을 시 경고 
    // JSX 문법에서는 forEach() 보다는 map() 을 주로 사용

    return(
        <>
            <ul>

                {items.map((item, index) => {
                    <li key={index}> {item} </li>
                })}

            </ul>
        </>
    )
}

// [7] CSS 적용
import './Example1.css' // CSS 파일 import
function Component7(props){
    // 기존 방식 : style="~~~`" => 불가
    // JSX 방식 : style={{CSS 객체}} => 가능
    // JSX 에서는 CSS 가 객체 형태로 인식됨
    // JSX 는 class 가 아닌 className 속성 사용
    // 주의점 : JSX 파일 내에서 객체 형태로 CSS 사용 시 하이픈 대신 카멜표기법 필수! 예] fontSize 

    const cssObj = {color : 'red'}
    return(
        <>
            {/* 방법_1 */}
            <h4 style={{color : "blue"}}> 인라인 형식의 CSS 넣기 </h4>
            {/* 방법_2 : CSS 객체 필요 */}
            <h4 style={cssObj}> 인라인 형식의 객체 CSS 넣기</h4>
            {/* 방법_3 : 생성한 CSS 파일 import 필요 */}
            <h4 className="myClass"> CSS 파일 내 선택자를 이용한 CSS 넣기</h4>
        </>
    )
}