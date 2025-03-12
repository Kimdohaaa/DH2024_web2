import {BrowserRouter, Route, Routes} from 'react-router-dom'

import AddBook from './AddBook.jsx'
import ReadBook from './ReadBook.jsx'
import UpdateBook from './UpdateBook.jsx'
import DeleteBook from './DeleteBook.jsx'
import AddReview from './AddReview.jsx'
import ReadReview from './ReadReview.jsx'
import DeleteReview from './DeleteReview.jsx'
import SideBar from './Sidebar'

import './App.css'

export default function App(props){
    return(
        <>
            <BrowserRouter>
                <div id="wrap">
                    <SideBar/>
                    <Routes>
                        <Route path="/addbook" element={<AddBook/>}></Route>
                        <Route path="/readbook" element={<ReadBook/>}></Route>
                        <Route path="/updatebook" element={<UpdateBook/>}></Route>
                        <Route path="/deletebook" element={<DeleteBook/>}></Route>
                        <Route path="/addreview" element={<AddReview/>}></Route>
                        <Route path="/readReview" element={<ReadReview/>}></Route>
                        <Route path="/deletereview" element={<DeleteReview/>}></Route>
                    </Routes>
                </div>
            </BrowserRouter>
        </>
    )
}