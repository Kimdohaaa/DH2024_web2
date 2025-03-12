import axios from "axios"
import { useState } from "react"
import { useLocation } from 'react-router-dom';


export default function UpdateBook(props){
    const [data, setData] = useState({bno : "", bname : "", bcontent : "", bpwd : ""})
    const queryParams = new URLSearchParams(location.search);
    const bno = queryParams.get('bno'); 

    const updatebook = (e) => {
        setData({...data,[e.target.name] : e.target.value})
    }

    const onUpdate = async () => {
        try{
            
            const obj = {
                bno : bno,
                bname : data.bname,
                bcontent : data.bcontent,
                bpwd : data.bpwd
            }
            console.log(bno)

            const response = await axios.put("http://localhost:8080/book", obj)

            if(response.data){
                alert("수정 성공")
                setData({bno : "", bname : "", bcontent : "", bpwd : ""})
            }else{
                alert("비밀번호를 다시 확인하세요.")
                setData({bno : "", bname : "", bcontent : "", bpwd : ""})
            }
        }catch(e){
            console.log(e)
        }
    }
    return(
        <>
            <div>
            <h3> 책 수정 페이지 </h3>
                <input type="text" placeholder="수정할 책제목" value={data.bname} name="bname" onChange={updatebook}/>
                <br/>
                <input type="text" placeholder="수정할 추천내용" value={data.bcontent} name="bcontent" onChange={updatebook}/>
                <br/>
                <input type="text" placeholder="비밀번호" value={data.bpwd} name="bpwd" onChange={updatebook}/>
                <br/>
                <button type="button" onClick={onUpdate}> 추천 수정 </button>
            </div>
        </>
    )
}