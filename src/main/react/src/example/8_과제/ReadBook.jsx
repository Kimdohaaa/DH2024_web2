import axios from "axios"
import { useEffect, useState } from "react"
import { Link } from "react-router-dom"

export default function ReadBook(props){

    const [books, setBooks] = useState([])
    
    useEffect(() => {findAll()}, [])
    
    const findAll = async () => {
        try{
            const response = await axios.get("http://localhost:8080/book")
            console.log(response.data)

            setBooks(response.data)

        }catch(e) {
            console.log(e)
        }
    }

    const [detail, setDetail] = useState({bno : "", bname : "", bcontent : "" })
    const find =  async (bno) => {
        try{
            const response = await axios.get(`http://localhost:8080/book/view?bno=${bno}`)

            if(response.data != null){
                setDetail(response.data)
            }
        }catch (e) {
            console.log(e)
        }
    }
    return(
        <>
            <div>
                <h3> 추천 전체 조회 (상세조회시 추천번호 클릭) </h3>
                <table border="1">
                    <thead>
                        <tr>
                            <th>추천번호</th>
                            <th>책제목</th>
                            <th>비고</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            books.map((book, index) => {
                              return(
                                <tr key={book.bno}>
                                    <td onClick={(e) => find(book.bno)}>{book.bno}</td>
                                    <td>{book.bname}</td>
                                    <td>
                                        <button type="button">
                                            <Link to={`/updatebook?bno=${book.bno}`}> 수정 </Link>
                                        </button>
                                        <button type="button">
                                        <Link to={`/deletebook?bno=${book.bno}`}> 삭제 </Link>
                                        </button>
                                        <button type="button">
                                        <Link to={`/addreview?bno=${book.bno}`}> 리뷰</Link>
                                        </button>
                                    </td>
                                </tr>
                            )
                            })
                        }
                    </tbody>

                </table>
                <br/>
                <hr/>
                <br/>
                <h3> 추천 상세 조회 </h3>
                <table border="1">
                    <thead>
                        <tr>
                            <th>책번호</th>
                            <th>책제목</th>
                            <th>추천내용</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        <tr >
                            <td>{detail.bno}</td>
                            <td>{detail.bname}</td>
                            <td>{detail.bcontent}</td>
                        </tr>
                
                    </tbody>
                </table>
        </div>
    </>
    )
}