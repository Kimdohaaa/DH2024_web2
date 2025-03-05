// [1] 컴포넌트 생성 후 렌더링
/*
    1. 지정한 폴더에 첫글자를 대문자로 하는 .js / .jsx(권장) 확장자를 가지 파일 생성
    2. 함수형 컴포넌트(권장) / 클래스형 컴포넌트 생성 
    3. return 에서 jsx(HTML + JS) 문법을 활용하여 화면 구현
    ※ JSP : HTML + JAVA ※
    4. 함수형 컴포넌트 반환
    5. main.jsx 소스파일에서 const root = creatRoot(~~~) 를 통해 index.html 의 root 구역 가져오기
    6. main.jsx 소스파일에서 import 생성한 컴포넌트명 from `해당 컴포넌트경로` 를 통해 컴포넌트 가져오기
    7. main.jsx 에서 root.render(<렌더링할 컴포넌트명/>)을 통해 index.html 에 JSX 를 HTML 로 렌더링


*/  


function Component1(){ // ---(2) : 함수형 컴포넌트 생성
    return <div>내가 만든 컴포넌트</div> // ---(3) : JSX 문법을 활용하여 화면 구현
}

export default Component1 ;// ---(4) : 함수형 컴포넌트 반환
