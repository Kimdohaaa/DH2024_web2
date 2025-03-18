import {BrowserRouter, Routes, Route} from 'react-router-dom'
import Home from './Home.jsx'
import Header from './layouts/Header.jsx'
import Footer from './layouts/Footer.jsx'
import Signup from './member/Signup.jsx'
import Login from './member/Login.jsx'

// 리액트 실행 시 최초로 열리는 컴포넌트 //
export default function App(props){
    return(
        <>
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
        </>
    )
}