console.log('index.js open');

// [1] 등록함수
const  onSave  = async () => {
    let name = document.querySelector('.name').value;
    let kor = document.querySelector('.kor').value;
    let math = document.querySelector('.math').value;

    // 객체 선언 시 대입할 변수명이 객체의 필드명과 동일할 경우 생략 가능
    const obj = { name , kor , math }
    console.log(obj);

    // fetch 대신 Axios 를 이용한 통신 (비동기 통신)
    axios.post('/day04/student', obj)
        .then(r => { // json 이 기본값으로 형변환없이 데이터 바로 사용 가능
            console.log(r)
            if(r.data > 0){
                location.reload(true); // 등록 성공 시 새로고침
            }
        })
        .catch(e => {console.log(e)})

    // fetch (JS 내장 함수) vs ajax(JQUERY) vs  Axios(React) -> 기본값이 JSON 으로 형변환을 하지 않아도 됨
    // Axios 사용하기
    // 1) Axios 설치 -> HTML 에 axios CDN 코드 넣기
    // 2) Axios 문법
        // - axios.HTTP메소드명.('통신할 HTTP URL', {옵션})

    /*
    <Axios 방법_1> ★ 비동기통신 ★
    axios.post('/day04/student', obj)
        .then(r => {console.log(r)}) // json 이 기본값으로 형변환없이 데이터 바로 사용 가능
        .catch(e => {console.log(e)})
    */
    /*
     <Axios 방법_2> ★ 비동기통신 ★
    console.log("axios 실행 전") // [1]
    axios.post('/day04/student', obj)
        .then(r => {console.log(r)}) // [2] // json 이 기본값으로 형변환없이 데이터 바로 사용 가능
        .catch(e => {console.log(e)})
    console.log("axios 실행 후") // [3]
    // 실행순서 : [1] -> [3] -> [2]
    // -> Axios 는 비동기 통신으로 요청 후 응답을 기다리지 않고 다음 코드를 실행함
    */
    /*
    <Axios 방법_3> ★ 비동기통신(해당 방법 사용 시 동기화 통신으로 변환 필요) ★
    console.log("axios 실행 전") // [1]
    const response = axios.post('/day04/student', obj)
    console.log(response.data)  // [2]
    console.log("axios 실행 후") // [3]
    // 실행순서 : [1] -> [2] -> [3]
    // -> Axios 의 응답값이 리턴 되기전에 [2]번 출력 (undefined 출력)
    */

    /*
     <Axios 방법_4> ★ 동기통신 ★
        // axios 앞에 await 키워드를 사용하여 대기하도록 만듦 -> 동기화
        // ★ 주의점 : 동기화 코드가 실행되는 함수명 앞에 async 키워드를 작성해야함 ★
    console.log("axios 실행 전")
    const response = await axios.post('/day04/student', obj)
    console.log(response.data)
    console.log("axios 실행 후")
    */
}
/*
<기존 방식>
const onSave = () => {
    let name = document.querySelector('.name').value;
    let kor = document.querySelector('.kor').value;
    let math = document.querySelector('.math').value;

    const obj = {
        name : name,
        kor : kor,
        math : math
    }
    const option = {
        method : 'POST',
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }

    fetch('/day04/student', option)
        .then(r => r.json())
        .then(data => {
            if(data == true){
                alert("등록 성공")
            }else{
                alert("등록 실패")
            }
        })
        .catch(e => {console.log(e)})
}
*/

// [2] 전체 조회 (동기화 방식 사용)
const onFindAll = async () => {
    try{
        const response = await axios.get('/day04/student')

        const tbody = document.querySelector("tbody");
        let html = ``;



        response.data.forEach(student => {

            html +=`<tr>
                         <td>${student.sno}</td>
                         <td>${student.name}</td>
                         <td>${student.kor}</td>
                         <td>${student.math}</td>
                         <td><button onclick="onUpdate(${student.sno})">수정</button></td>
                         <td><button onclick="onDelete(${student.sno})">삭제</button></td>
                      </tr>`;
        })

        tbody.innerHTML = html;
    }catch(e){
        console.log(e);
    }
}
onFindAll();

// [3] 수정 (동기화 통신)
const onUpdate = async (sno) => {

    try{
        // [1] 수정할 값 받기
        const name = prompt("수정할 이름 : ");
        const kor = prompt("수정할 국어점수 : ");
        const math = prompt("수정할 수학점수 : ");

        // [2] 객체화
        const obj = {sno , name , kor , math};

        // [3] Axios 통신
        const response = await axios.put(`/day04/student`, obj)
        if(response.data == 1){
            onFindAll();
        }else{
            alert("수정 실패");
        }
    }catch(e){console.log(e)}

}

// [4] 삭제 (동기화 통신)
const onDelete = async (sno) => {

    try{
        const response = await axios.delete(`/day04/student?sno=${sno}`)

        if(response.data == 1){
            onFindAll();
        }else{
            alert("삭제 실패");
        }

    }catch(e){console.log(e)}

}