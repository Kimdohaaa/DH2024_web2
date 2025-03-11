import { useEffect, useState } from "react"
import axios from 'axios'; // axios import

export default function Example2(props){
    
    // [1] 입력받은 데이터를 저장하는 state 변수 생성 후 초기값 지정
    const [formDate, setFormDate] = useState({ writer: "" , content : "" , pwd : ""})
    
    // [2] 입력받은 데이터를 렌더링하는 이벤트 함수 선언
    const formDataChange = (e) => { // e : 'onChage' 이벤트의 결과 정보
        // [1] 'onChange' 이벤트를 발생한 HTML DOM(마크업) 반환받기
        console.log(e.target)
        // [2] 'onChange' 이벤트를 발생한 HTML DOM 의 name 속성 값 반환받기
        console.log(e.target.name)
        // [3] 'onChange' 이벤트를 발생한 HTML DOM 의 value 속성 값 반환받기
        console.log(e.target.value)

        // [4] 스프레드 연산자를 이용한 state 변수 상태 변경
            // 새로운 속성 추가 : setXXX({...기존객체, 새로운 속성명 : 새로운 값})
            // -> 이미 존재하는 속성명일 시 기존 속성명의 값 수정
        setFormDate({...formDate, [e.target.name] : e.target.value});
    
    }

    // [3] 현재 state 변수를 Spring 서버에게 보내기 (POST)
    const onPost = async (e) => {
        // 예외 처리 //
        try{
            // state 변수(formData) 를 axios 를 통해 Spring 서버에게 보내기
            const respons = await axios.post("http://localhost:8080/day07/react", formDate);
            console.log(respons);

            if(respons.data == true){
            
                alert("등록 성공")
                // 만약 등록 성공 시 state 변수 초기화
                setFormDate({writer : "", content : "", pwd : ""})
                // 만약 등록 성공 시 자료 렌더링
                onFindAll();

            }else{
            
                alert("등록 실패")
            
            }

        }catch(e){
            console.log(e);
        }
    }

    // [4] 현재 서버에 저장된 정보를 요청하여 가져오기 (GET)
    
    // 1) 컴포넌트가 마운트(생성) 시 최초 1번 실행
    // useEffect(() => {onFindAll()})   // [] (의존성배열) 를 생략 시 무한 렌더링됨 => 의존성 배열 생략시 setBoard() 렌더링 -> findAll() 무한루프 
    // useEffect(() => {onFindAll()}, [boards]) // onFindAll -> setBoards -> onFindAll 무한 렌더링
    useEffect(() => {onFindAll()} , []) // 의존성 배열이 빈 배열 일 때 : 컴포넌트가 생성될 때 최초 1번 onFindAll 메소드가 실행
    
    // 2) 서버로부터 반환받은 데이터를 저장할 state 변수
    const [boards, setBoards] = useState([])
    
    const onFindAll = async () => { // axios 는 주로 동기 통신에서 사용
        // 예외 처리 //
        try{
            // ★ 주의점 : 서버의 도메인이 다르기 때문에 URL 을 서버 도메인까지 다 작성해야함 ★ //
            const response = await axios.get("http://localhost:8080/day07/react");
            console.log(response)
            
            // 3) 서버로부터 받은 정보를 state 변수에 저장
            setBoards(response.data);

        }catch(e){
            console.log(e)
        }
    }
    return(
        <>
            <h4> 입력폼 </h4>
            <form>
                {/* 입력받은 데이터를 실시간으로 state 변수로 관리 */}
                작성자 : <input type="text"  value={formDate.writer} name="writer" onChange={formDataChange}/>
                <br/>
                방문록 : <input type="text" value={formDate.content} name="content" onChange={formDataChange}/>
                <br/>
                비밀번호 : <input type="text" value={formDate.pwd} name="pwd" onChange={formDataChange}/>
                <br/>
                <button type="button" onClick={onPost}> 등록 </button>
                <br/>
                <br/>
                <table border="1" style={{borderCollapse : "collapse"}}>
                    <thead>
                        <tr>
                            <th> 번호 </th>
                            <th> 작성자 </th>
                            <th> 방문록 </th>
                            <th> 비고 </th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            boards.map((board , index) => {
                                return (
                                    <tr key={index}> {/* 보통 인덱스보다는 PK 키 사용*/}
                                        <td>{index + 1}</td>
                                        <td>{board.writer}</td>
                                        <td>{board.content}</td>  
                                        <td> 
                                            <button type="button"> 수정 </button>
                                            <button type="button"> 삭제 </button>
                                        </td>     
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