import {configureStore} from '@reduxjs/toolkit' // 리덕스에서 제공하는 리듀서 등록 함수
import  userReducer from './userSlice.jsx' // userSlice.jsx 에서 리듀서 가져오기

// Store : 리듀서 등록

// [1] 리덕스 스토어 변수 생성
                    // [2] configureStroe() 함수로 리듀서 정의 , 등록 
                    // => {reducer :{리듀서명 : 등록할 리듀서1, 리듀서명2 : 등록할 리듀서2}}
export const store = configureStore({reducer : {user : userReducer}})



// Store 을 컴포넌트에서 사용하기 위해 export 
export default store; // store 내보내기