// map 반복문, slice, filter


let array = ['red', 'green', 'blue', 'pink', 'orange', 'gray'];

//map을 이용해서 출력하기
array.map((color, idx) => console.log(idx + ":" + color));

console.log("-------------------------------------------");

// 배열의 데이터 잘라내기(slice), 걸러내기(filter)
// blue를 삭제 후 다시 출력

// slice로 blue 잘라내기
console.log("slice로 blue 잘라내기");
let array1 = [...array.slice(0, 2), /* 0~1번을 잘라내기 : red, green */
        ...array.slice(3, array.length) /* 3번부터 length-1까지 잘라내기 : pink, orange, gray */
        ];

array1.map((color, idx) => console.log(idx + ":" + color));

console.log("-------------------------------------------");

// filter로 blue인 2번만 걸러내기
console.log("filter로 blue 걸러내기");
let array2 = array.filter((color, idx) => idx !== 2) /* idx가 2가 아닌 것만 리턴(필터링), 값과 타입을 모두 비교하려면 ==, 동등연산자일 경우 === */

array2.map((color, idx) => console.log(idx + ":" + color));