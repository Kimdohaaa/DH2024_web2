// 20250306 리액트 훅 //

let a = 0; // 전역변수
export default function Example1(props){
    
    let b = 0; // 지역변수
    ++a; // a 에 1 증가
    ++b; // b 에 1 증가

    // 증가 버튼을 클릭했을 때 실행되는 함수
    const 증가함수 = () => {
        ++a;
        ++b;

        console.log(a)  
        console.log(b)
        // JS 에서는 값이 3으로 변경됨 -> 다시 렌더링 되지 않았기 때문에 페이지에는 반영이 안됨
        // JSX 에서는 이미 값이 2로 return 했기 때문에 값을 반영하지 못함(불변성)
        // => 훅을 통해서 해결
    }

    return(<>
    
        <div>{++a}</div> {/* a 에 1 증가 출력 : 2 */}
        <div>{++b}</div> {/* b 에 1 증가 출력 : 2 */}
    
        {/* 버튼을 클릭해도 증가하지 않는 이유 : innerHTML 을 하지 않았기 때문 */}
        <button type="button" onClick={증가함수}>증가함수</button>
    
    </>)
}