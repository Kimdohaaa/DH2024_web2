import { useState } from "react"
import axios from 'axios'
import { useNavigate } from "react-router-dom"

export default function Signup(props){
    console.log("Signup 컴포넌트 open")
    // [0] 새로고침 없는 페이지 전환을 위한 useNavigate 변수 선언
    const navigate = useNavigate();

    // [1] 입력받은 값들을 저장하는 state 변수 선언
    // => useState() : 값 변경 시 리렌더링됨
    const [memberinfo, setMemberInfo] = useState({mid : "", mpwd : "", mname : ""})
    
    // [2] 입력받은 값을 state 렌더링하는 메소드
    const onInputChange = (e) => {
        {/* [e.target.name] : onChange 를 실행 시킨 name */}
        {/* [e.target.value] : onChange 시킬 value */}
        // setXXX() 은 새로운 주소값을 넣어야함 -> 스프레드연산자 사용
        setMemberInfo({...memberinfo,[e.target.name] : [e.target.value]});
        console.log(memberinfo)
    }

    // [3] 입력받은 첨부파일 state 렌더링하는 메소드 / 첨부파일 미리보기
    // 1) 업로드파일을 저장하는 state 변수 선언 
    const [profile, setProfile] = useState(null);

    // 2) 업로드된 파일을 바이트로 저장하는 state 변수 선언
    const [preview, setPreview] = useState(null)

    const onFileChange = (e) => {
        // 3) 업로드된 파일 가져오기
        // e.target.files[0] : 사용자가 입력한 파일 객체를 반환받음 ([0] : 한개 가져옴)
        const file = e.target.files[0];

        // 4) 업로드된 파일을 state 변수에 저장
        setProfile(file)

        // 5) 미리보기
        if(file){ // 만약 파일이 존재하면
            // 6) 파일 읽기 객체 선언
            // FileReader() : 파일 읽기를 지원하는 JS 객체
            const reader = new FileReader() ;
            
            // 7) 파일 읽기 메소드 정의 => onloadend() 메소드
            // FileReader객체명.onloadend = () => {}
            reader.onloadend = () => {
                // 읽어들인 파일 객체 콘솔에 출력 => result
                // FileReader객체명.result => 바이트 배열로 반환함
                console.log(reader.result) 
                // 8) 반환된 바이트 배열 state 변수에 대입
                setPreview(reader.result)
            }

            // 9) 파일 읽기 => redaAsDataURL()
            // FileReader객체명.readAsdataURL(읽어들일 파일 객체)
            reader.readAsDataURL(file)

        }else{ // 10) 만약 파일이 존재하지 않으면
            // 11) state 변수에 null 대입
            setPreview(null)
        }
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

            // * 첨부파일 존재 여부 검사
            if(profile){ // 만약 첨부파일 존재 시 첨부파일 추가
                formDate.append('uploadfile' , profile);
            }

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
                
                    {/* 미리보기 파일이 존재하면 미리보기(preview) 출력*/}
                    {/* 단축평가 : 전자가 true 면 뒤에 (<></>) 실행*/}
                    {preview && (<><img src={preview} style={{width : "100px"}}/></>)}

                    <br/>
                    <button type="button" onClick={onSignup}> 회원가입 </button>
                </form>
            </div>
        </>
    )
}