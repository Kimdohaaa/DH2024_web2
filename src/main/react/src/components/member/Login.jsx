import { useState } from "react"
import axios from 'axios'
import { useNavigate } from "react-router-dom"
import {useDispatch} from 'react-redux' // useDispatch import
import { login } from "../reduxs/userSlice"  // Slice 의 login 리듀서 함수 import


export default function Login(props){

    // [*] 리덕스 (전역변수) 사용하기
    // *-1) 리덕스를 사용하기 위한 useDispatch() 변수 선언
    const dispatch = useDispatch();

    // [0] 페이지 전환을 위한 useNavigate() 변수 선언
    const navigate = useNavigate();

    // [1] 로그인 정보를 저장할 state 변수 선언
    const [memberInfo, setMemberInfo] = useState({mid : "", mpwd : ""})

    // [2] 입력받은 값을 state 수정 처리하는 함수
    const onInfoChange = (e) => {
        setMemberInfo({...memberInfo, [e.target.name] : e.target.value})
        // console.log(memberInfo)
        
    }

    console.log(memberInfo)
    // [3] 서버로 입력받은 값 전달
    const onLogin = async () => {
        try{
            const response = await axios.post("http://localhost:8080/api/member/login"
                , memberInfo, {withCredentials : true}) 
                    // 서버와 도메인이 다르기 때문에 {withCredentials : true} 를 통해 세션 허용
            console.log(response.data)

            if(response.data){
                // 로그인 성공 시 회원정보 가져오기
                const response2 = await axios.get("http://localhost:8080/api/member/info", {withCredentials : true})

                alert("로그인 성공")
                setMemberInfo({mid : "", mpwd : ""}) // input 초기화
                navigate('/') // 로그인 성공 시 페이지 전환 // 기존 방식

                // *-2) useDispatch() 함수를 이용한 리듀서 함수 action(호출)
                dispatch(login(response2.data)); // 로그인 정보를 매개변수로 보내 전역으로 저장하여 사용

            }else{
                alert("로그인 실패")
                setMemberInfo({mid : "", mpwd : ""}) // input 초기화
            }
        }catch(e){
            console.log("로그인 통신 오류", e)
        }
        
    }
    return(
        <>
            <div>
                <h3> 로그인 페이지 </h3>
                <form>
                    <input type="text" placeholder="아이디" name="mid" 
                    value={memberInfo.mid} onChange={onInfoChange}/> 
                    <br/>
                    <input type="password" placeholder="비밀번호" name="mpwd"
                    value={memberInfo.mpwd} onChange={onInfoChange}/>
                    <button type="button" onClick={onLogin}> 로그인 </button>
                </form>
            </div>
        </>
    )
}