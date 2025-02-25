console.log('index.js open');

// [1]등록
const add = () => {
    let title = document.querySelector(".title").value
    let content = document.querySelector(".content").value;

    const obj = {title, content};

    console.log(obj);

    axios.post("/day04/task/board", obj)
        .then(r => {
            console.log(r);
            if(r.data == true){
                location.reload(true);
            }else{
                alert('작성 실패');
            }
        })
        .catch(e => {
            console.error(e);
        });

}
// [2] 전체조회
const findAll = () => {
    let tbody = document.querySelector('tbody');
    let html = ``;

    axios.get("/day04/task/board")
    .then(r => {
        r.data.forEach((data) => {
            html += `
                <tr>
                    <td onclick=find(${data.bno})>${data.bno}</td>
                    <td>${data.title}</td>
                    <td>${data.content}</td>
                    <td><button onclick="onUpdate(${data.bno})">수정</button></td>
                    <td><button onclick="onDelete(${data.bno})">삭제</button></td>
                </tr>
            `
        })
        tbody.innerHTML = html;
    })
}
findAll();

const find = (bno) => {

    let find = document.querySelector('.find');
    let html = ``;

    axios.get(`/day04/task/board/view?bno=${bno}`)
    .then(r => {
        console.log(r.data);
        html += `
            <p>제목 :  ${r.data.title}</p>
            <p>내용 : ${r.data.content}</p>
        `
    find.innerHTML = html;
    })

    .catch(e => {console.error(e);});
}

const onUpdate = (bno) => {
    const title = prompt("수정할 제목:");
    const content = prompt("수정할 내용:");

    const obj = {bno, title, content};

    axios.put("/day04/task/board", obj)
    .then(r => {
        if(r.data == true){
            findAll();
        }
    })
    .catch(e => {console.error(e);});

}

const onDelete = (bno) => {
    axios.delete(`/day04/task/board?bno=${bno}`)
    .then(r => {
        if(r.data == true){
            findAll();
        }
    })
    .catch(e => {console.error(e);});
}
