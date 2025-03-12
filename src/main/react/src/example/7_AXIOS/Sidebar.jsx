// Link 마크업 import
import { Link } from "react-router-dom"

export default function SideBar(props){
    return(
        <>
            <div>
                <ul id="sidemenu">
                    <li> 사이드바 메뉴 </li>
                    {/* Link 마크업을 통해 가상 URL 연결 -> a 마크업 사용 시 계속 재렌더링 되기 때문 */}
                    {/* Link 마크업 : 리액트에서 만든 가상 컴포넌트 */}
                    <li> <Link to="/"> 메뉴 1 : HOME </Link> </li>
                    <li> <Link to="/create"> 메뉴 2 : Create </Link> </li>
                    <li> <Link to="/read"> 메뉴 3 : Read </Link> </li>
                    <li> <Link to="/update"> 메뉴 4 : Update </Link> </li>
                    <li> <Link to="/delete"> 메뉴 5 : Delete </Link> </li>
                </ul>
            </div>
        </>
    )
}