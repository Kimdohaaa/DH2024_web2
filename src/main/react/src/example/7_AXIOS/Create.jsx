import axios from "axios"
import { useState } from "react"

// App.jsx 의 App 컴포넌트와 연결된 Create 컴포넌트
export default function Create(props){
    const [formData , setFormDate] = useState({pname: "", pprice : "", pexplain : ""})

    // 제품 등록
    const formDataChange = (e) => {
        
        console.log(e.target.name);

        setFormDate({...formData, [e.target.name] : e.target.value})

    }

    // 등록된 제품 서버와 연결
    const onPost = async () => {
        try{
            const respons = await axios.post("http://localhost:8080/day08/product", formData )
            console.log(respons.data)

            if(respons.data == true){
                alert("등록 성공")
                setFormDate({pname: "" , pprice : "", pexplain : ""})
            }else{
                alert("등록 실패")
            }
        
        }catch(e){
            console.log("제품 등록 오류 : ", e)
        }

    }
    return(
        <>
            <div>
                <div> Create 페이지 </div>

                <input type="text" value={formData.pname} name="pname" onChange={formDataChange}/>
                <br/>
                <input type="text" value={formData.pprice} name="pprice" onChange={formDataChange}/>
                <br/>
                <input type="text" value={formData.pexplain} name="pexplain" onChange={formDataChange}/>
                <br/>
                
                <button type="button" onClick={onPost}> 제품 등록 </button>
            </div>
        </>
    )
}