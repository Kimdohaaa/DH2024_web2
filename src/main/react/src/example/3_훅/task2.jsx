import { useState } from "react"

/*
과제 : 전화번호부 이름 / 전화번호 입력받아 배열에 저장한 후 배열 내 모든 정보를 ul 로 띄우기 
조건 : useState 사용
*/
export default function Task2(){
    
    const [name , setName] = useState('')
    const [phone , setPhone] = useState('')

    const [nameList, setNameList] = useState([])
    const [phoneList, setPhoneList] = useState([])

    const add = (e) => {
        console.log("이름" , e.target.value)  
        setName(e.target.value)
        
      

    }
    
    const addP = (e) => {
        console.log("전화" , e)
        setPhone(e.target.value)

      
    }


    const addList = () => {
        setNameList([...nameList,name]);
        setPhoneList([...phoneList,phone]);
        console.log(nameList)
        console.log(phoneList)

        setName('')
        setPhone('')
    }

    return(
        <>
            <div>
                이름 : <input value={name} onChange={add}/>
                <br/>
                전화번호 :<input value={phone} onChange={addP}/>
                <br/>
                <button onClick={addList}> 등록 </button>

                <ul>
                  
                    {nameList.map((n, index) => (
                        <li key={index}>
                            이름 : {n} 전화번호 :{phoneList[index]}
                        </li>
                    ))}
                    
                </ul>

                
            </div>

        </>
    )
}