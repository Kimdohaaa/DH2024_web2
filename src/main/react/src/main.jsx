import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
// import './index.css' // CSS 를 기본값 제거 시 지우기~
// import App from './App.jsx'

/* 
--- 기본코드 주석처리 ---
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
*/

// ※※※ day01 ※※※ //

// [1] 컴포넌트 파일의 확장자를 js 로 지정할 경우
import React from "react"; // -> 를 통해 명시해야함
  // 컴포넌트 파일의 확장자가 .jsx 일 경우 생략 가능

// [2] index.html 에 "#root" 구역 가져오기
const root = createRoot( document.querySelector("#root"));

// [3] import 호출할 컴포넌트명 from `해당 컴포넌트 경로`
import Component1 from './example/1_동작구조/Component1.jsx'; 

// root.render(<Component1/>) // !!! 마크업 슬래스로 꼭 닫아주기 !!!


// 기본 컴포넌트 //

// [1] 컴포넌트 호출
// import Component2 from './example/1_동작구조/Component2.jsx';

// [2] 렌더링 ! 렌더링은 한번만 !
  // 기본컴포넌트인 Component2 에 Header 컴포넌트와 Footer 컴포넌트가 종속되어 있음
// root.render(<Component2/>)



// ※※※ day02 : 컴포넌트의 JSX 활용 ※※※ //
// [1] 컴포넌트 JSX 활용
// import Example1 from './example/2_컴포넌트/Example1.jsx';
//root.render(<Example1/>)

// [2] : 컴포넌트의 props 활용
// import Example2 from './example/2_컴포넌트/Example2.jsx';
// root.render(<Example2/>)

// [3] day02 과제
// import Task from './example/2_컴포넌트/task.jsx';
// root.render(<Task/>)

// ※※※ day03 : 훅 ※※※ //
// [1] 리액트 훅 X 컴포넌트
// import Example1 from './example/3_훅/Example1.jsx';
// root.render(<Example1/>)

// [1] 리액트 훅 O 컴포넌트
// import Example2 from './example/3_훅/Example2.jsx';
// root.render(<Example2/>)

// import Example3 from './example/3_훅/Example3.jsx';
// root.render(<Example3/>)

// [2] day03 과제_1

// import Task1 from './example/3_훅/task1.jsx';
// root.render(<Task1/>)

// [3] day03 과제_2
//import Task2 from './example/3_훅/task2.jsx';
//root.render(<Task2/>)




// ※※※ day04 : 훅 / 라우터 ※※※ //
// [1] 훅 : useEffct()
// import Example1 from './example/4_훅/Example1.jsx';
// root.render(<Example1/>)

// [2] 라우터
// import App from './example/5_라우터/Example1.jsx';
// root.render(<App/>)


// ※※※ day05 : AXIOS ※※※ //
// [1] 이벤트 함수와 AXIOS
// import Example1 from './example/6_AXIOS/Example1.jsx';
// root.render(<Example1/>)

// [2] 방문록
// import Example2 from './example/6_AXIOS/Example2.jsx';
// root.render(<Example2/>);

// [3] day05 과제 _ 전화번호부
// import Task1 from './example/6_AXIOS/task1.jsx';
// root.render(<Task1/>)


// ※※※ day06 : AXIOS ※※※ //
// import App from './example/7_AXIOS/App.jsx';
// root.render(<App/>) // 다른 컴포넌트의 가상 URL 이 포함된 라우터 컴포넌트를 .render()


// ※※※ day07 : 과제 ※※※ //
import App from './example/8_과제/App.jsx';
root.render(<App/>)


// ※※※ day05 : AXIOS ※※※ //
// ※※※ day05 : AXIOS ※※※ //
// ※※※ day05 : AXIOS ※※※ //



