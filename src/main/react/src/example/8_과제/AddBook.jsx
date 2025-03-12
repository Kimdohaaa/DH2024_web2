import { useState } from "react"
import axios from 'axios'

export default function AddBook(props){
    const [Data , setData] = useState({bname : "" , bcontent : "" , bpwd : ""})

    // 책 추천 등록
    const DataChange = (e) => {
        setData({...Data, [e.target.name] : e.target.value})
    }

    const addBook = async () => {
        try{
            const obj = {
                bname : Data.bname,
                bcontent : Data.bcontent,
                bpwd : Data.bpwd
            }

            const response = await axios.post("http://localhost:8080/book", obj)
            console.log(response.data)

            if(response.data){
                alert("추천 등록 성공")
                setData({bname : "" , bcontent : "" , bpwd : ""})
            }else{
                alert("추천 등록 실패")
                setData({bname : "" , bcontent : "" , bpwd : ""})
            }

        }catch(e) {
            console.log(e)
        }
    }
    return(
        <>
            <div>
                <h3> 추천 등록 페이지 </h3>
                <input type="text" placeholder="책제목" value={Data.bname} name="bname" onChange={DataChange}/>
                <br/>
                <input type="text" placeholder="추천내용" value={Data.bcontent} name="bcontent" onChange={DataChange}/>
                <br/>
                <input type="text" placeholder="비밀번호" value={Data.bpwd} name="bpwd" onChange={DataChange}/>
                <br/>
                <button type="button" onClick={addBook}> 리뷰 등록 </button>
            </div>
        </>
    )
}