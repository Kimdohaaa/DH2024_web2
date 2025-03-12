// Link 마크업 import
import { Link } from "react-router-dom"

export default function SideBar(props){
    return(
        <>
            <div>
                <ul id="sidemenu">
                    <li> <Link to="/addbook"> 추천 등록 </Link> </li>
                    <li> <Link to="/readbook"> 추천 조회 </Link> </li>

                    <li> <Link to="/readreview"> 리뷰 조회 </Link> </li>
                </ul>
            </div>
        </>
    )
}