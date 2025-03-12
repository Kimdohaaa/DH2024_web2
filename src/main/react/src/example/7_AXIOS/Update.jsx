import { useEffect, useState } from "react"
import Read from "./Read.jsx";
import axios from "axios";
import { useParams } from "react-router-dom";

// App.jsx 의 App 컴포넌트와 연결된 Update 컴포넌트
export default function Update(props){
   //  const {pno} = useParams();
    const [formData, setFormDate] = useState({pno : "" ,pname: "", pprice : "", pexplain : ""})

    
    const formDataChange = (e) => {
        console.log(e.target.name);

        setFormDate({...formData, [e.target.name] : e.target.value})
    }    
    const onUpdate = async () => {
        try{
            const respons = await axios.put("http://localhost:8080/day08/product", formData)
            console.log(respons.data)

            if(respons.data == true){
                alert("수정 성공")
                setFormDate({pno : "", pname: "" , pprice : "", pexplain : ""})
            }else{
                alert("없는 제품 번호 입니다.")
            }
        }catch(e){
            console.log("제품 수정 오류 : ", e)
        }
    }
    
    return(
        <>
            
            <div>
                <div> Update 페이지 </div>
                 

                수정할 번호 :    <input type="text" value={formData.pno} name="pno" onChange={formDataChange}/>
                <br/>
                수정할 제품명 : <input type="text" value={formData.pname} name="pname" onChange={formDataChange}/>
                <br/>
                수정할 가격 : <input type="text" value={formData.pprice} name="pprice" onChange={formDataChange}/>
                <br/>
                수정할 제품설명 : <input type="text" value={formData.pexplain} name="pexplain" onChange={formDataChange}/>
                <br/>
                <button type="button" onClick={onUpdate}> 제품 수정 </button>
            </div>
        </>
    )
}