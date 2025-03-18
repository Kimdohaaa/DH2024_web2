import { Link } from "react-router-dom"

export default function Header(props){
    return(
        <>
            <div>
                <h3> 여기는 헤더 </h3>

                <ul>
                    <li> <Link to="/"> 홈 </Link> </li>
                    <li> <Link to="/member/signup"> 회원가입 </Link> </li>
                    <li> <Link to="/member/login"> 로그인 </Link> </li>
                </ul>
            </div>
        </>
    )
}