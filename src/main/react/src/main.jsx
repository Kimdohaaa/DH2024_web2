import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css' // CSS 를 기본값 제거 시 지우기~
import App from './App.jsx'

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
import Component2 from './example/1_동작구조/Component2.jsx';

// [2] 렌더링 ! 렌더링은 한번만 !
  // 기본컴포넌트인 Component2 에 Header 컴포넌트와 Footer 컴포넌트가 종속되어 있음
// root.render(<Component2/>)



// ※※※ day02 : 컴포넌트의 JSX 활용 ※※※ //
// 컴포넌트 불러오기
import Example1 from './example/2_컴포넌트/Example1.jsx';
root.render(<Example1/>)