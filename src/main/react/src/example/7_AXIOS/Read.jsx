import axios from "axios";
import { useEffect, useState } from "react"
import { Link } from "react-router-dom"

// App.jsx 의 App 컴포넌트와 연결된 Read 컴포넌트
export default function Read(props){

    useEffect(() => {findAll()}, [])
    const [products, setProduct] = useState([])

    const findAll = async () => {
        try{
            const respons = await axios.get("http://localhost:8080/day08/product");
            console.log(respons.data)

            setProduct(respons.data)
        }catch(e){
            console("전체 조회 오류 : ", e)
        }
    }

    useEffect(() => {view()}, [])
    const [viewData, setViewData] = useState("")

    const view = async (pno) => {
        try{
            const response = await axios.get(`http://localhost:8080/day08/product/view?pno=${pno}`)
            console.log(response.data)

            setViewData(response.data)
        }catch(e){
            console.log("상세조회오류", e)
        }

    }
    return(
        <>
            <div>
                <div> Read 페이지 (상세조회 시 제품 번호 클릭) </div>

                <table border="1">
                    <thead>
                        <tr>
                            <th> 제품번호 </th>
                            <th> 제품명 </th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            products.map((p, index) => {
                                return(
                                    <tr key={index}>
                                        <td onClick={(e) => view(p.pno)}>
                                            {p.pno}
                                        </td>
                                        <td> {p.pname} </td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>

                <br/>
                <div> 제품 상세 조회 </div>
                <table border="1">
                    <thead>
                            <tr>
                                <th> 제품번호 </th>
                                <th> 제품명 </th>
                                <th> 제품가격 </th>
                                <th> 제품설명</th>
                            </tr>
                        </thead>
                        <tbody>
                                <tr>
                                    <td>{viewData.pno}</td>
                                    <td>{viewData.pname}</td>
                                    <td>{viewData.pprice}</td>
                                    <td>{viewData.pexplain}</td>
                                </tr>
                        </tbody>

                </table>
            </div>
        </>
    )
}