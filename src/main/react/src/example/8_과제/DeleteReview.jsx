import axios from "axios";
import { useState } from "react"
import { useLocation } from 'react-router-dom';

export default function DeleteReview(props){
    const [data , setData] = useState({rpwd :""})
    const queryParams = new URLSearchParams(location.search);
    const rno = queryParams.get('rno'); 

    const change = (e) => {
        setData({...data,[e.target.name] : e.target.value})
    }

    const deleteReview = async () => {
        try{
            const obj = {
                rno : rno,
                rpwd : data.rpwd
            }
            const response = await axios.post("http://localhost:8080/review/delete", obj)
        
            if(response.data == true){
                alert("삭제 성공")
                setData({rpwd : ""})
            }else{
                alert("비밀번호를 다시 확인하세요.")
                setData({rpwd : ""})
            }
        }catch (e) {
            console.log(e)
        }
    }
    return(
        <>
            <div>
                <h3> 리뷰 삭제 </h3>
                <input type="text" placeholder="비밀번호" value={data.rpwd} name="rpwd" onChange={change}/>
                <br/>
                <button type="button" onClick={deleteReview}> 리뷰 삭제 </button>
            </div>
        </>
    )
}