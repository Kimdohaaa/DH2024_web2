import axios from 'axios'
import { useEffect, useState } from 'react'

export default function Task1 (props){
    const [formData, setFormDate] = useState({tname : "", tphone : ""})

    const formDataChange = (e) => {
        setFormDate({...formData, [e.target.name] : e.target.value})
    }

    const onPost = async (e) => {
        try{
            const response = await axios.post("http://192.168.40.24:8080/task", formData)
            console.log(response)

            if(response.data == true){
                alert("등록성공")
                setFormDate({ tname : "", tphone : ""})
                findAll();
            }else{
                alert("등록 실패")
            }
        }catch(e){
            console.log(e)
        }
    }

    useEffect(() => {findAll()}, [])
    const [boards, setBoards] = useState([])

    const findAll =  async () => {
        try{
            const response = await axios.get("http://192.168.40.24:8080/task")
            console.log(response)

            if (Array.isArray(response.data)) {
                setBoards(response.data);  // 데이터가 배열이면 그대로 설정
            } else {
                console.error("Expected array but got:", response.data);
                setBoards([]);  // 데이터가 배열이 아니라면 빈 배열로 설정
            }
        }catch(e){
            console.log(e)
        }
    }
    return(
        <>
         <h4> 전화번호부 </h4>
            <form>
                {/* 입력받은 데이터를 실시간으로 state 변수로 관리 */}
                이름 : <input type="text"  value={formData.tname} name="tname" onChange={formDataChange}/>
                <br/>
                전화번호 : <input type="text" value={formData.tphone} name="tphone" onChange={formDataChange}/>
                <br/>
                <button type='button' onClick={onPost}> 등록 </button>

                <table border="1">
                    <thead>
                        <tr>
                            <th> 번호 </th>
                            <th> 이름</th>
                            <th> 전화번호 </th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            boards.map((board, index) => {
                                return (
                                <tr key={index}>
                                    <td>{index + 1}</td>
                                    <td>{board.tname}</td>
                                    <td>{board.tphone}</td>
                                </tr>
                                )
                            })

                        }                         
                    </tbody>
                </table>
            </form>

        </>
    )
}