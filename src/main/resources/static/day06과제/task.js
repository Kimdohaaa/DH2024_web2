// 1. let과 const를 사용해서 name(이름)과 age(나이)를 저장하고 값을 출력해 보세요.
const name1 = "강호동"
const age1 = 30;

let task1 = document.querySelector(".task1")
let html = `1번 : 이름 : ${name1} 나이 : ${age1}`
task1.innerHTML += html;

// 2. 숫자 두 개를 받아서 곱한 값을 반환하는 화살표 함수를 작성하세요.
const fun1 = () => {
    let task2_1 = document.querySelector("#task2_1")
    let task2_2 = document.querySelector("#task2_2")

    let i = Number(task2_1.value)
    let j = Number(task2_2.value)
    let task2 = document.querySelector("#task2_answer")
    task2.innerHTML += `2번 정답 : ${i * j}`
}


// 3. name과 age를 활용해서 "저는 [이름]이고, [나이]살입니다." 를 출력하세요.
const name = "Alice";
const age = 25;

let task3 = document.querySelector(".task3")
let html3 = `3번 : 저는 ${name} 이고, 나이는 ${age} 입니다.`
task3.innerHTML += html3;

// 4. user 객체에서 name과 email 값을 추출해 변수를 만들고 출력하세요.
const user = { name4: "Alice", email: "alice@example.com", age: 25 };
const {name4 , email} = user

let task4 = document.querySelector(".task4")
task4.innerHTML += ` 4번 : 이름 : ${user.name4} 이메일 : ${email} ` 

// 5. arr1과 arr2를 합쳐 result 배열을 만드세요.
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

const totalArr = [arr1,... arr2]
let task5 = document.querySelector(".task5")
task5.innerHTML += `5번 : ${totalArr}`; 

// 6. greet 함수가 name 값을 받지 않으면 "Guest" 라고 출력하도록 만드세요.
const greet = (name) => `Hello, ${name == null ? "Guest" : ""}!`;

let task6 = document.querySelector(".task6")
task6.innerHTML += `6번 : ${greet()}`; 


// 7. 객체를 만들 때 name, age 변수를 그대로 사용하세요.
const name2 = "Alice";
const age2 = 25;

const obj = {name2 , age2};

let task7 = document.querySelector(".task7")
task7.innerHTML += `7번 : 객체 ${obj.name2} ${obj.age2}`; 

// 8. 첫 번째 값을 first, 나머지를 rest에 저장하세요.
const numbers = [10, 20, 30, 40];
const [first,...rest] = [10, 20, 30, 40]; 
let task8 = document.querySelector(".task8")
task8.innerHTML += `8번 : first ${first} 나머지 ${rest}`; 


// 9. isLoggedIn이 true면 "Welcome!", false면 "Please log in."을 출력하세요.
const isLoggedIn = true;

let task9 = document.querySelector(".task9")
let state = isLoggedIn == true ? "welcome!" : "Please log in."; 
task9.innerHTML += `9번 : ${state}`

// 10. 동기 fetch를 사용해서 JSONPlaceholder API에서 https://jsonplaceholder.typicode.com/posts/1 데이터를 가져오세요.
const fun2 = async () => {
    await fetch( 'https://jsonplaceholder.typicode.com/posts/1' )
        .then( r => r.json() )
        .then( data => {
            console.log( data );
            let task10 = document.querySelector(".task10") 
            task10.innerHTML += `10번 : <br/> 바디 : ${data.body} <br/> 아이디 :  ${data.id} <br/> 타이틀 : ${data.title}`
        })
        .catch( e => { console.log(e); } )
} // f end
fun2();


// 11. 배열 ages에서 각 나이를 기준으로 "성인" 또는 "미성년자"를 판단하여 새로운 배열을 만들어 출력하세요.
const ages = [25, 12, 20, 8];
const task11 = ages.filter((i) => {return i > 19})
console.log(task11)

let task111 = document.querySelector(".task11") 
task111.innerHTML += `11번 : ${task11}`