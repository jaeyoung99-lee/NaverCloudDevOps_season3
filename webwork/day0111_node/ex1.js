// 화살표 함수


function hello1(){
    console.log("hello1 호출 - 기본 함수")
}

let hello2 = () => console.log("hello2 호출 - 화살표 함수");

// 함수 호출
hello1();
hello2();

function sum1(x, y){
    return x + y;
}

let sum2 = (x, y) => x + y;

console.log(sum1(5, 6));
console.log(sum2(5, 6));