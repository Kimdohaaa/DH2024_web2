import {configureStore} from '@reduxjs/toolkit' // 리덕스에서 제공하는 리듀서 등록 함수
import  userReducer from './userSlice.jsx' // userSlice.jsx 에서 리듀서 가져오기

import {persistStore, persistReducer} from 'redux-persist' // 리덕스 퍼시스턴스 함수 가져오기
import storage from 'redux-persist/lib/storage' // 브라우저의 로컬 스토리지 가져오기


// Store : 리듀서 등록


// [1] 퍼시스턴스 설정
const persistConfig = {
    storage,     // 로컬스토리지 사용 설정
    key : "root" // 브라우저의 로컬 스토리지에 저장할 키 이름을 "root" 로 지정
}

// [2] 퍼시스턴스에 적용할 리듀서 설정 (회원 리듀서에 적용)
// const 변수명 = (퍼시스턴스 설정 , 설정을 적용할 리듀서 )
const persistedReducer = persistReducer( persistConfig , userReducer)

// [1] 리덕스 스토어 변수 생성
                    // [2] configureStroe() 함수로 리듀서 정의 , 등록 
                    // => {reducer :{리듀서명 : 등록할 리듀서1, 리듀서명2 : 등록할 리듀서2}}
export const store = configureStore({
    //reducer : {user : userReducer}  // 퍼시스턴스가 적용됮 않은 리듀서 주석 처리
    reducer : {user : persistedReducer} // 퍼시스턴스가 적용된 리듀서     
})



// [2] Store 을 컴포넌트에서 사용하기 위해 export 
export const persistor = persistStore (store) // 퍼시스턴스가 적용된 store 내보내기
export default store; // store 내보내기
