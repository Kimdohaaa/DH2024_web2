import { useState } from "react"
import axios from 'axios'
import { useNavigate } from "react-router-dom"

export default function Signup(props){
    console.log("Signup 컴포넌트 open")
    // [0] 새로고침 없는 페이지 전환을 위한 useNavigate 변수 선언
    const navigate = useNavigate();

    // [1] 입력받은 값들을 저장하는 state 변수 선언
    // => useState() : 값 변경 시 리렌더링됨
    const [memberinfo, setMemberInfo] = useState({mid : "", mpwd : "", mname : "", uploadfile : ""})
    
    // [2] 입력받은 값을 state 렌더링하는 메소드
    const onInputChange = (e) => {
        {/* [e.target.name] : onChange 를 실행 시킨 name */}
        {/* [e.target.value] : onChange 시킬 value */}
        // setXXX() 은 새로운 주소값을 넣어야함 -> 스프레드연산자 사용
        setMemberInfo({...memberinfo,[e.target.name] : [e.target.value]});
        console.log(memberinfo)
    }

    // [3] 입력받은 첨부파일 state 렌더링하는 메소드
    const onFileChange = (e) => {
        // e.target.files[0] : 사용자가 입력한 파일 객체를 반환받음 ([0] : 한개 가져옴)
        console.log(e.target.files[0])
        // 사용자가 입력한 파일 객체를 state 에 대입
        setMemberInfo({...memberinfo, "uploadfile" : e.target.files[0]})
    }

    console.log(memberinfo)

    // [4] 백에게 입력받은 값 전달 (multipart/form-data 형식으로 전달(바이트(=바이너리) 전송))
    const onSignup = async () => {
        try{
            // 1) formData 객체 만들기
            const formDate = new FormData();

            // 2) formData객체명.append('속성명' , 값) 를 통해 객체 value 지정
            formDate.append('mid', memberinfo.mid);
            formDate.append('mpwd' , memberinfo.mpwd);
            formDate.append('mname' , memberinfo.mname);
            formDate.append('uploadfile' , memberinfo.uploadfile);
            
            // 3) axios 에서 사용할 HTTP 헤더 정보 변수 선언
            const option = {headers : {"Content-Type" : "multipart/form-data"}};

            // 4) axios 를 통해 동기통신
            const response = await axios.post("http://localhost:8080/api/member/signup",formDate, option);

            // 5) 응답받기
            const result = response.data;

            // 6) 응답에 따른 처리
            if(result == true){
                alert("회원가입 성공")
                // 7) 회원가입 성공 시 로그인 페이지로 이동
                navigate("/login") // navigate() 사용 시 새로고침 없이 이동 가능
                                   // location.href 사용 시 새로고침 됨 
            }else{
                alert("회원가입 실패")
            }


        }catch(e){
            console.log("회원가입 통신 오류 : ", e)
        }
    } 


    return(
        <>
            <div>
                <h3> 회원가입 페이지 </h3>
                <form>
                    <input type="text" name="mid" placeholder="아이디" 
                    value={memberinfo.mid} onChange={onInputChange}/>
                    <br/>
                    <input type="password" name="mpwd" placeholder="비밀번호" 
                    value={memberinfo.mpwd} onChange={onInputChange}/>
                    <br/>
                    <input type="text" name="mname" placeholder="닉네임" 
                    value={memberinfo.mname} onChange={onInputChange}/>
                    <br/>
                    {/* accept="image/*" : 이미지만 받기 */}
                    <input type="file" accept="image/*" onChange={onFileChange}/> 
                    <br/>
                    <button type="button" onClick={onSignup}> 회원가입 </button>
                </form>
            </div>
        </>
    )
}