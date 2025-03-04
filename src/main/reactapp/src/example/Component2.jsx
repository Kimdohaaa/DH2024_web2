// 기본 컴포넌트 //
// 1. 컴포넌트 생성 ★ 첫글자 대문자 ★ 
    // function  컴포넌트명 (props) {return JSX 문법 작성}
function Component2(props){ 
    // 기본 컴포넌트에 그 외 컴포넌트 종속 시키기
    return <div> <Header/> 메인 페이지 <Footer/> </div> // 기본 컴포넌트는 index.html 에 종속
}

// 2. 여러 컴퍼넌트 중에서 import 할 경우 반환할 컴포넌트 정의
    // export default 반환할 컴포넌트명;
export default Component2;

// 3. main.jsx 파일로 가

// 그 외 컴포넌트 //
// 1. 헤더 컴포넌트
function Header (props){
    return <div> 헤더 메뉴 </div> // 가상 DOM 생성
}

// 2. 푸터 컴포넌트
function Footer (props){
    return <div> 푸터 메뉴 </div> // 가상 DOM 생성
}

// ★ HTML 을 함수 형식으로 사용 가능 ★ //