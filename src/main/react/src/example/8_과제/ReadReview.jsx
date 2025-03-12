import axios from "axios"
import { useEffect, useState } from "react"
import { Link } from "react-router-dom"

export default function ReadReview(props){
    const [reviews, setReviews] = useState([])

    useEffect(() => {find()}, [])
    const find = async () => {
        try{
            const response = await axios.get("http://localhost:8080/review")

            if(response.data){
                setReviews(response.data)
            }
        }catch (e) {
            console.log(e)
        }
    }
    return(
        <>
            <div>
                <h3> 리뷰 조회 </h3>
                <table border="1">
                    <thead>
                        <tr>
                            <th>리뷰번호</th>
                            <th>리뷰내용</th>
                            <th> 책이름 </th>
                            <th>비고</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            reviews.map((r , index) => {
                                return(
                                    <tr key={r.rno}>
                                        <td>{r.rno}</td>
                                        <td>{r.rcontent}</td>
                                        <td>{r.bname}</td>
                                        <td>
                                            <button type="button">
                                                <Link to={`/deletereview?rno=${r.rno}`}>
                                                    삭제
                                                </Link>
                                            </button>
                                        </td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>
            </div>
        </>
    )
}