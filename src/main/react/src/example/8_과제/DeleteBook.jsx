import axios from "axios";
import { useState } from "react";
import { useLocation } from 'react-router-dom';

export default function DeleteBook(props) {
  const [data, setData] = useState({bpwd: "" });
  const location = useLocation(); 
  const queryParams = new URLSearchParams(location.search);
  const bno = queryParams.get('bno'); 
  console.log(bno)
  const change = (e) => {
    setData({ ...data, [e.target.name]: e.target.value });
  };

  const deleteBook = async () => {
    try {
      const obj = {
        bno: bno,
        bpwd: data.bpwd
      };
      console.log(bno);
      console.log(obj)
      const response = await axios.post("http://localhost:8080/book/delete", obj);
      console.log(response.data);

      if (response.data) {
        alert("삭제 성공");
        setData({bpwd: "" }); 
      } else {
        alert("비밀번호를 다시 확인하세요.");
        setData({bpwd: "" }); 
      }
    } catch (e) {
      console.log(e);
    }
  };

  return (
    <>
      <div>
        <h3>책 추천 삭제</h3>
        <input
          type="text" 
          placeholder="비밀번호"
          value={data.bpwd}
          name="bpwd"
          onChange={change}
        />
        <button type="button" onClick={deleteBook}>
          삭제
        </button>
      </div>
    </>
  );
}
