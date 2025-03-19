import {BrowserRouter, Routes, Route} from 'react-router-dom'
import Home from './Home.jsx'
import Header from './layouts/Header.jsx'
import Footer from './layouts/Footer.jsx'
import store from'./reduxs/store.jsx'
import {Provider} from 'react-redux' // toolkit 이 아닌 redux 에서 지원 
import Login from './member/Login'
import Signup from './member/Signup'

// 리액트 실행 시 최초로 열리는 컴포넌트 //
export default function App(props){
    return(
        <>
         {/* <Provider> 를 통해 감싸진 모든 컴포넌트에 리덕스 스토어 적용 
          -> 감싸진 컴포넌트에서 전역 상태 사용 가능*/}
        <Provider store={store}>
      
            <BrowserRouter> {/* 모든 라우터를 감싸는 BrowserRouter */}
                <div id="wrap">
                    <Header/>
                    
                    <Routes> {/* Routes 안에 있는 컴포넌트만 전환 가능*/}
                        {/*Route 로 가상 URL 연결 */}
                        <Route path='/' element={<Home/>}> </Route>
                        <Route path='/member/signup' element={<Signup/>}> </Route>
                        <Route path='/member/login' element={<Login/>}> </Route>
                    </Routes>

                    <Footer/>
                </div>
            </BrowserRouter>
        </Provider>
        </>
    )
}