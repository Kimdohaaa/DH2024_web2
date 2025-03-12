// App.jsx : 라우터(가상 URL) 역할
import {BrowserRouter, Route, Routes} from 'react-router-dom'

// 라우터로 연결할 컴포넌트 import
import Home from './Home.jsx'       // Home 컴포넌트 import
import Create from './Create.jsx'   // Create 컴포넌트 import
import Read from './Read.jsx'       // Read 컴포넌트 import
import Update from './Update.jsx'   // Update 컴포넌트 import
import Delete from './Delete.jsx'   // Delete 컴포넌트 import
import SideBar from './Sidebar.jsx' // Sidebar 컴포넌트 import

// CSS import
import './App.css'

// 라우터를 이용한 라우팅(가상 URL 연결하기)
export default function App(props){
    return(
        <>
            {/* [1] BrowserRouter 마크업을 통해 라우팅할 모든 라우터를 감쌈 */}
            <BrowserRouter>
                <div id='wrap'>
                    <SideBar/> {/* 사이드바 컴포넌트 */}
                    {/* [2] Routes 마크업을 통해 가상으로 정의한 URL 을 감쌈 */}
                    <Routes>
                        {/* [3] Route 마크업을 통해 가상의 URL 정의, 컴포넌트 연결 */}
                        <Route path='/' element={<Home/>}/>
                        <Route path='/create' element={<Create/>}/>    
                        <Route path='/read' element={<Read/>}/>
                        <Route path='/update' element={<Update/>}/>
                        <Route path='/delete' element={<Delete/>}/>
                    </Routes>
                </div>
            </BrowserRouter>
        </>
    )
}

