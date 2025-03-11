// FETCH 와 AXIOS 를 이용한 동기 / 비동기 통신

// 1. Axios 설치 : 프로젝트 최상위 폴더 터미널 -> npm i axios -> npm install
// 2. Axios 를 사용할 폴더 상단에 import axios from 'axios'

// axios 라이브러리 import
import axios from 'axios'

export default function Example1(props){

    // [1] 이벤트 함수 1 _ onClick 결과 정보
    const onEvent1 = (e) => { // e : event 객체 매개변수 -> onClick 결과정보
        console.log(e);
        console.log(e.target);
        console.log(e.target.value);
    }

    // [2] 이벤트 함수 2 _ onClick 결과 정보 , 일반 매개변수
        // 리액트에서 일반 매개변수 보내기 : {(e) => 함수명(e, 보낼 매개변수)}
    const onEvent2 = (e ,param1) => {
        console.log(e);
        console.log(param1);
    }

    // [3] 이벤트 함수 3 _ AXIOS GET (동기 통신) 
    const onEvent3 = async (e) => {
        console.log(e);

        // [1] Axios 동기 통신 (GET 방식)
        // const 결과를저장할변수명 = await axios.HTTP메소드명('HTTP 주소',{body}, {option});
        const response1 = await axios.get('https://jsonplaceholder.typicode.com/posts'); // GET 통신으로 body 와 option 생략
        console.log("GET 통신 : " , response1);
    
        // [2] 매개변수를 path variable (/ 를 이용한 매개변수 전달) 방식으로 보냄
        const response2 = await axios.get('https://jsonplaceholder.typicode.com/posts/1');
        console.log("path variable 방식 : " ,response2);

        // [3] 매개변수를 queryString (? 를 이용한 매개변수 전달) 방식으로 보냄
        const response3 = await axios.get('https://jsonplaceholder.typicode.com/comments?postId=1');
        console.log("queryString 방식 : " ,response3);
    }

    // [4] 이벤트 함수 4 _ AXIOS POST (동기 통신)
    const onEvent4 = async (e) => {
        console.log(e);

        // [1] AXIOS 동기 통신 (POST)
        const obj = {userId : 1, title : "foo" , body : 'bar'}
        const response1 = await axios.post('https://jsonplaceholder.typicode.com/posts' , obj);
        console.log("POST 통신  : ", response1);
    }

    // [5] 이벤트 함수 4 _ AXIOS PUT (동기 통신)
    const onEvent5 = async (e) => {
        console.log(e)

        // [1] AXIOS 동기통신 (PUT)
        const obj = {id : 1 , userId : 1, title : "foo", body : "var"};
        const response1 = await axios.put("https://jsonplaceholder.typicode.com/posts/1", obj)
        console.log("PUT 통신 : ", response1);
    }

    // [5] 이벤트 함수 5 _ AXIOS DELETE (동기 통신)
    const onEvent6 = async (e) => {
        console.log(e);

        // [1] AXIOS 통신 (DELETE) -> path varibale 방식
        const response1 = await axios.delete("https://jsonplaceholder.typicode.com/posts/1");
        console.log("DELETE 통신 : ", response1);
    }

    return(
        <>
            {/* 1_onClick 이벤트 결과정보를 매개변수로 보냄 */}
            <button type='button' onClick={onEvent1}> 이벤트 함수 1 </button>
            <br/>
            {/* 2_onClick 이벤트 결과정보와 일반 데이터를 매개변수로 보냄 */}
            <button type='button' onClick={(e) => onEvent2(e, 13)}> 이벤트 함수 2 </button>
            <br/>
            {/* 3_ AXIOS (GET 통신) */}
            <button type='button' onClick={onEvent3}> 이벤트 함수 3 (GET) </button>
            <br/>
            {/* 4_ AXIOS (POST 통신) */}
            <button type='button' onClick={onEvent4}> 이벤트 함수 4 (POST) </button>
            <br/>
            {/* 5_ AXIOS (PUT 통신) */}
            <button type='button' onClick={onEvent5}> 이벤트 함수 5 (PUT) </button>
            <br/>
            {/* 6_ AXIOS (DELETE 통신) */}
            <button type='button' onClick={onEvent6}> 이벤트 함수 6 (DELETE) </button>
        </>
    )
}