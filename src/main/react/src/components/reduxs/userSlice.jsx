import { createSlice } from "@reduxjs/toolkit"; 

// Slice : 상태와 리듀서 정의

// [1] 전역 상태(변수)로 사용할 데이터 초기값 정의
const initialState = {
    userInfo : null ,       // 로그인한 정보를 저장할 속성 생성
    isAuthenticated : false // 인증 여부를 저장할 속성(로그인 여부) 생성
                            // 초기값 false (비로그인) 으로 선언
}

// [2] createSlice() 함수를 이용한 상태와 리듀서 생성
const userSlice = createSlice( {
    name : 'user', // 상태이름 지정 
    initialState,  // 상태의 초기값 지정(false)
    reducers : {   // 실제 상태를 처리하는 함수 (Slice 는 정의하는 곳) => 형식 : reducers : {함수명 : 처리함수}
        
        // 1) 로그인 리듀서
        login : (state, action) => {
            state.isAuthenticated = true ; // 로그인 성공 시 인증 상태 속성을 true 로 바꿈
            state.userInfo = action.payload; // 로그인 함수 action(호출) 시 payload(매개변수로 받은 값)를 state 에 저장
        }, 
        
        // 2) 로그아웃 리듀서
        logout : (state) => {
            state.isAuthenticated = false; // 로그아웃 시 인증 상태 속성을 false 로 변경
            state.userInfo = null // 로그아웃 함수 action(호출) 시 payload(매개변수로 받은 값)를 null 로 변경
        } 

    }
})

// [3] Store 에서 import 하여 사용하기 위해 export
export const [login, logout] = userSlice.actions; // 액션 생성
export default userSlice.reducer; // 리듀서 내보기기