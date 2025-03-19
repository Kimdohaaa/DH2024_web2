import { useEffect, useState } from "react"
import { Link, useNavigate } from "react-router-dom"
import axios from 'axios'
import {useDispatch, useSelector} from 'react-redux' // 리덕스에서 제공하는 전역변수 값을 가져오는 함수
import { logout } from "../reduxs/userSlice"

export default function Header(props) {

        // *************************** 리덕스 방법 ***************************
    // [*] 리덕스 전역변수 사용하기
    // *-1) 전역 상태에 저장된 로그인된 회원정보 불러오기
    const loginInfo = useSelector((state) =>  state.user.userInfo); // 'user' 라는 이름의 리듀서 정보(로그인된 회원정보)를 가져오기 
    console.log(loginInfo)
    // *-2) 로그아웃을 하기 위한 useDispatch
    const dispatch = useDispatch()


    // [0] 페이지 전환을 위한 useNavigate() 변수 선언
    const navigate = useNavigate();



    // *************************** useState 방법 ***************************
    // // [1] 현재 로그인 상태를 저장하는 state 변수 선언
    // // const [login, setLogin] = useState({}) // 객체를 저장하기 위해 빈객체 초기값으로 선언

    // // [2] 서버에게 로그인 상태 응답받기
    // const onLoginInfo = async () => {
    //     try {
    //         // 서버와 도메인이 다르기 때문에 세션 허용을 하지 않을 시 세션 공유 불가 
    //         // => {withCredentials : true} 를 통해 세션 허용
    //         const response = await axios.get("http://localhost:8080/api/member/info", { withCredentials: true })
    //         console.log(response.data)

    //         if (response.data != null) {
    //             setLogin(response.data)
    //         }
    //     } catch (e) {
    //         console.log("로그인 정보 조회 오류", e)
    //     }
    // }

    // // [3] useeffect() 를 사용하여 헤더 렌더링 시 onLoginInfo() 함수 실행
    // useEffect(() => { onLoginInfo() }, []) // 컴포넌트가 최초 1번 렌더링
    // console.log(login)


    // [4] 서버에게 로그아웃 요청 , 응답 받기
    const onLogout = async () => {
        try{
            const response = await axios.get("http://localhost:8080/api/member/logout", {withCredentials : true})
            console.log(response)

            alert("로그아웃 성공")
            navigate("/member/login") // 로그아웃성공 시 로그인 페이지로 전환
            
            // 로그아웃 함수 호출
            dispatch(logout())

            // setLogin({})
        }catch(e){
            console.log("로그아웃 통신 오류", e)
        }
    }

    // 로그인 , 로그아웃 시 리렌더링 필요
    // => 인증절차의 경우 보안이 중요하기 때문에 리액트의 SPA 방식을 사용하지 않고 서버에 맡기는 경우가 많음

    return (
        <>
            <div>
                <h3> 여기는 헤더 </h3>

                <ul>
                    {/* 로그인 여부에 따라 삼항연산자를 통해 출력 */}
                    <li> {loginInfo ? 
                    (<>
                        <div>
                            {loginInfo.mid} 님 안녕 
                            <button onClick={onLogout}> 로그아웃 </button>
                        </div> 
                    </>) 
                    :
                    (<>
                     <div> 비로그인 </div>
                    </>)
                    } </li>
                    <li> <Link to="/"> 홈 </Link> </li>
                    <li> <Link to="/member/signup"> 회원가입 </Link> </li>
                    <li> <Link to="/member/login"> 로그인 </Link> </li>
                </ul>
            </div>
        </>
    )
}