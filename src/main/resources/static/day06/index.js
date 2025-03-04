console.log("index.js open")

// JS 기본 문법 정리 (react 에서 필요한 기본 문법) //

// [1] 변수 선언 [let(변수) / const(상수)]
let count1 = 0; // 변수 선언
count1 = 1; // 변수이므로 값 수정 가능

const count2 = 0; // 상수 선언
// count2 = 1; // 오류 발생(상수이므로 값 변경 불가)

// ★ 주의점 : 상수 객체를 선언한 경우 객체의 값은 속성이므로 수정 가능 ★ //
const obj = {name : "유재석"}; // 상수 객체 선언
obj.name = "강호동"; // 오류 X(객체의 값은 속성이므로 수정 가능)

// [2] 함수
// 2-1) 함수 선언
function fun1(param1, param2){ } // 기본함수 선언
const fun2 = function (param1, param2){ } // 익명함수 선언(주로 변수, 상수에 저장하여 사용)
const fun3 = (param1, param2) => { } // 화살표,람다식 함수(주로 변수, 상수에 저장하여 사용)

// 2-2) 함수 호출 , 사용
fun1(1, 2);
fun2("유재석", "강호동");
fun3(1, "강호동");

// + 기본 매개변수 정의 : 인자가 없을 떄 기본값 대입 가능 + //
const fun4 = (param1, param2, param3 = "기본값") => { }
fun4("유재석", 10); // "유재석" , 10 , "기본값"

// [3] 객체 : key 와 value 의 entry  
// 3-1) 객체 : {key : value, key : value} 
const obj2 = {name : "유재석" , age : 10}

// + 속성명 단축 가능 + //
const name3 = "강호동";
const age3 = 50;
const obj3 = {name3, age3} // == {name3 : name3, age3 : age3}
// + 객체 속성 값 호출 + //
console.log(obj3.name3); // "강호동"
console.log(obj3.age3);  // 50

// 3-2) 리스트 , 배열 : [value, value, value]
const array1 = [1,2,3,4,5];
console.log(array1) // 1,2,3,4,5
console.log(array1[0]) // 1 -> 배열 내 0 번째 원소 출력

// 3-3) 스프레드 연산자 : ... 배열이나 객체를 복사하거나 합칠 때 사용
const array2 = [...array1 ,6,7]  // 스프레드 연산자를 통해 array1 배열과 array2 를 합침 
console.log(array2) // 1,2,3,4,5,6,7

const obj4 = {...obj3, phone : "123"} // 스프레드 연산자를 통해 obj3 객체와 obj4 객체를 합침
console.log(obj4) // name3 : "강호동" , age3 : 50 , phone : "123"

// [4] 백틱 : 문자열 템플릿 , + 연산자가 아닌 백틱 안에 ${ }를 이용하여 문자열과 표현식을 연결할 때 사용
const str4 = "react";
console.log(`Hello ${str4}`) // Hello react
// ★ 주의점 : ${ } 안에 if , for , 선언문 등 선언부 불가 => 연산 , 함수호출 , 삼항연산자 등 호출부 가능 ★ //

// [5] 구조 분해 할당 : 객체나 배열에서 값을 분해 추출하는 방법
const user =  {name5 : "하하", age5 : 30}
const {name5 , age5} = user // 객체 내 동일한 속성명으로 변수를 여러 개 분해하여 저장
console.log(name5)
console.log(age5)

// [6] 비구조화 할당 , 나머지 연산자 : 배열 또는 객체 뒤에 ...(스프레드)를 이용하여 나머지는 객체 또는 배열로 저장하는 방법
const [array6,...rest] = [1,2,3,4]
console.log(array6) // 1 
console.log(rest)   // 2,3,4

const {name6 ,...rest2} = {name6 : "서장훈", age : 70 , phone : "010"}
console.log(name6) // "서장훈"
console.log(rest2) // { age : 70 , phone : "010"}

// [7] 삼항 연산자 : 조건 ? true 코드 : false 코드
const loginState = true; 
console.log(loginState == true ? "로그인" : "비로그인") // "로그인"
// + 단축 연산 , 평가 + //
// 1_ 조건(A) && true 코드(B) : 만약 조건이 true 이면 B 반환 false 면 A 반환
// 2_ 조건(A) || false 코드(B) : 만약 조건이 true 이면 A 반환 false 면 B 반환  
console.log(loginState && "로그인") // A 가 true -> B 반환 : "로그인"
const loginState2 = false;
console.log(loginState2 && "로그인") // A 가 false -> A 반환 : false
console.log(loginState2 || "비로그인") // A 가 true -> A 반환 : "비로그인"
console.log(loginState2 || "비로그인") // A 가 false -> B 반환 : "비로그인"

// [8] 비동기 , 동기
// 8-1) 비동기식 통신 : 요청을 보내고 응답을 기다리지 않고 다음 코드 진행
const fun8 = () => { 
    fetch('')
        .then(r => r.json())
        .then(data => {})
        .catch(e => {console.log(e)})
}

// 8-2) 동기 통신 : 요청을 보내고 응답이 올 때까지 대기 (async 키워드 , await 키워드)
const fun9 = async () => {
    await axios.get()   // fetch 대시 axios 를 사용하여 json 으로 타입변환이 자동으로 됨
        .then(data => {})
        .catch()
}

const fun10 = async () => {
    try{
        const response = await axios.get('')
        const data = response.data
    }catch(error){
        console.log(error)
    }
}

// [9] 반복문
const array9 = [10,20,30,40,50]
// 9-1) 일반 for 문
for(let i = 0 ; i < array9.length ; i++){
    console.log(array9[i])
}

// 9-2) 향상된 for 문
for(let i in array9){ // in : 인덱스 순회
    console.log(i) // 0,1,2,3,4
}
for(let i of array9){ // of : 원소 순회
    console.log(i) // 10,20,30,40,50
}

// 9-3) forEach((반복변수명) => {반복문})
array9.forEach( (i, index)  => {console.log(i, index)})
    // 10 0, 20 1, 30 2, 40 3, 50 4 -> 원소값과 인덱스 같이 순회

    // 9-4) map() 문
array9.map((i , index) => {
    console.log(i, index)
    return i * 10;  // return 가능
})
    // 10 0, 20 1, 30 2, 40 3, 50 4 -> 원소값과 인덱스 같이 순회
// ★ forEach() 문과 map() 문의 차이점 : map 은 리턴이 가능 ★ //

// 9-5) filter() : 조건에 맞는 값만 return 가능
const array11 = array9.filter((i, index) => {return i % 4 === 0}) // 4배수 값만  return
console.log(array11) // 20,40 -> 조건에 맞는(4 배수) 값만 출력
