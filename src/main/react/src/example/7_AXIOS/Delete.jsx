import axios from "axios"
import { useState } from "react"

// App.jsx 의 App 컴포넌트와 연결된 Delete 컴포넌트
export default function Delete(props){
    const [pno , setPno] = useState("")
    
    const formDataChange = (e) => {
        
        console.log(e.target.name);

        setPno(e.target.value)

    }

    const onDelete = async () => {
        try{
            const respons = await axios.delete(`http://localhost:8080/day08/product?pno=${pno}`)

            console.log(respons.data)

            

            if(respons.data == true){
                alert("삭제 성공")
                setPno("")
            }else{
                alert("없는 제품 번호 입니다.")
            }
        }catch(e){
            console.log("제품 삭제 오류 : ", e)
        }
    }
    return(
        <>
            <div>
                <div> Delete 페이지 </div>
                삭제할 번호 :    <input type="text" value={pno} name="pno" onChange={formDataChange}/>

               

                <button type="button" onClick={onDelete}> 제품 삭제 </button>
            </div>
        </>
    )
}