import axios from "axios"
import { useState } from "react"
import { useLocation } from 'react-router-dom';

export default function AddReview(props){
    // 리뷰 추천 등록
    const [review, setReview] = useState({rcontent : "", rpwd : "", bno : ""})
    const location = useLocation(); 
    const queryParams = new URLSearchParams(location.search);
    const bno = queryParams.get('bno'); 
  
    const change = (e) =>{
        setReview({...review,[e.target.name] : e.target.value})
    }

    const addReview = async () => {
        try{
            const obj = {
                bno : bno,
                rcontent : review.rcontent,
                rpwd : review.rpwd
            }
            const response = await axios.post("http://localhost:8080/review", obj)

            if(response.data){
                alert("리뷰 등록 성공")
                setReview({rcontent : "", rpwd : "", bno : ""})
            }
        }catch (e) {
            console.log(e)
        }
    }
    return(
        <>
        <div>
            <h3> 리뷰 등록 페이지 </h3>
            <input type="text" placeholder="리뷰내용" value={review.rcontent} name="rcontent" onChange={change}/>
            <br/>
            <input type="text" placeholder="비밀번호" value={review.rpwd} name="rpwd" onChange={change}/>
            <br/>
            <button type="button" onClick={addReview}> 리뷰 등록 </button>
        </div>
        </>
    )
}