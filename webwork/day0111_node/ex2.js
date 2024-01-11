// 펼침연산자 : ...


let arr1 = [3, 4, 5];
let arr2 = [6, 7, 8];

// arr3에 arr1과 arr2 값을 모두 넣고 싶을 경우
let arr3 = [...arr1, ...arr2, 30, 40]; // arr1값 3, 4, 5가 펼쳐져서 들어가고 arr2값 6, 7, 8이 펼쳐져서 들어감

// 개수 출력
console.log("arr3 = " + arr3.length);

// arr3 데이터 출력
console.log(arr3);

let sum1 = (a, b, c) => a + b + c;
console.log(sum1(3, 5, 7));
console.log(sum1(...arr2));
console.log(sum1(...arr3)); // 총 8개의 값 중 앞의 3개만 인자로 넘어감
