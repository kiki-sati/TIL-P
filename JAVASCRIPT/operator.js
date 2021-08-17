// 1. String convatenation
console.log('my' + 'cat');
console.log('1' + 2);
console.log('string literals : 1 + 2 = ${1 + 2}');

// 2. Numeric operators
console.log(1 + 1); // add
console.log(1 - 1); // substract
console.log(1 / 1); // divide
console.log(1 * 1); // mutiply
console.log(5 % 2); // remainder
console.log(2 ** 3); // exponentiation

//3. Increment and decrement operators
let counter = 2;
//하나를 증가한 다음에 카운터의 값을 할당하는 것 
const preIncrement = ++counter;
// counter = counter + 1;
// preIncrement = counter;
console.log(`preIncrement: ${preIncrement}, counter: ${counter}`);

const postIncrement = counter++;
// 먼저 변수의 값을 할당한다음에 그 뒤에 카운터의 값을 증가시키는 것 
// postIncrement = counter;
// counter = counter + 1;
console.log(`postIncrement: ${postIncrement}, counter: ${counter}`);

const preDecrement = --counter;
console.log(`preDecrement: ${preDecrement}, counter: ${counter}`);
const postDecrement = counter--;
console.log(`postDecrement: ${postDecrement}, counter: ${counter}`);

// 4. Assignment operators
// 할당하는 오퍼레이터 
let x = 3;
let y = 6;
x += y; // x = x + y;
x -= y;
x *= y;
x /= y;

// 5. Comparison operators
// 비교하는 오퍼레이터 
console.log(10 < 6); // less than
console.log(10 <= 6); // less than or equal
console.log(10 > 6); // greater than
console.log(10 >= 6); // greater than or equal

// 6. Logical operators: || (or), && (and), ! (not)
const value1 = true;
const value2 = 4 < 2;

// || (or), finds the first truthy value
// 세개중에 하나라도 트루가 있으면 출력
// 함수를 호출하는 아이들을 제일 뒤에 배치하는것이 효율적인 코드작성법
console.log(`or: ${value1 || value2 || check()}`);

// && (and), finds the first falsy value
// 세개가 다 트루가 되어야 출력됨 
// 이것도 마찬가지로 제일 해비한 오퍼레이션이 뒤에 오는것이 좋다.
console.log(`and: ${value1 && value2 && check()}`);

// often used to compress long if-statement
// nullableObject && nullableObject.something

function check() {
  for (let i = 0; i < 10; i++) {
    //wasting time
    console.log('😱');
  }
  return true;
}

// ! (not)
// 값을 반대로 바꿔준다.
console.log(!value1);

// 7. Equality
const stringFive = '5';
const numberFive = 5;

// == loose equality, with type conversion
// 타입을 변경해서 검사를 한다.
console.log(stringFive == numberFive);
console.log(stringFive != numberFive);

// === strict equality, no type conversion
// 타입을 신경써서 타입이 다르면 넌 다른애들이야!
// 왠만하면 strict equality로 검사하는것이 좋다.
console.log(stringFive === numberFive);
console.log(stringFive !== numberFive);

// object equality by reference
const ellie1 = { name: 'ellie' };
const ellie2 = { name: 'ellie' };
const ellie3 = ellie1;
console.log(ellie1 == ellie2);
console.log(ellie1 === ellie2);
console.log(ellie1 === ellie3);

// equality - puzzler
console.log(0 == false);
console.log(0 === false);
console.log('' == false);
console.log('' === false);
console.log(null == undefined);
console.log(null === undefined);

// 8. Conditional operators: if
// if, else if, else
const name = 'df';
if (name === 'ellie') {
  console.log('Welcome, Ellie!');
} else if (name === 'coder') {
  console.log('You are amazing coder');
} else {
  console.log('unkwnon');
}

// 9. Ternary operator: ?
// condition ? value1 : value2;
// if를 간단하게 출력
console.log(name === 'ellie' ? 'yes' : 'no');

// 10. Switch statement
// use for multiple if checks
// use for enum-like value check
// use for multiple type checks in TS
const browser = 'IE';
switch (browser) {
  case 'IE':
    console.log('go away!');
    break;
  case 'Chrome':
  case 'Firefox':
    console.log('love you!');
    break;
  default:
    console.log('same all!');
    break;
}

// 11. Loops
// while loop, while the condition is truthy,
// body code is executed.
let i = 3;
while (i > 0) {
  console.log(`while: ${i}`);
  i--;
}

// do while loop, body code is executed first,
// then check the condition.
do {
  console.log(`do while: ${i}`);
  i--;
} while (i > 0);

// for loop, for(begin; condition; step)
for (i = 3; i > 0; i--) {
  console.log(`for: ${i}`);
}

for (let i = 3; i > 0; i = i - 2) {
  // inline variable declaration
  console.log(`inline variable for: ${i}`);
}

// nested loops
for (let i = 0; i < 10; i++) {
  for (let j = 0; j < 10; j++) {
    console.log(`i: ${i}, j:${j}`);
  }
}

// break, continue
// Q1. iterate from 0 to 10 and print only even numbers (use continue)
// 숫자를 0~10까지 짝수만 프린트.
for (let i = 1; i < 11; i++) {
    if (i % 2 ===0) {
        console.log(`q1. ${i}`);
    }
    
}

// Q2. iterate from 0 to 10 and print numbers until reaching 8 (use break)

for (let i = 0; i < 11; i++) {
  if (i > 8) {
    break;
  }
  console.log(`q2. ${i}`);
}
