
//자바스크립트 오류 방지
// q
'use strict'

//2.Variable (변수) - rw(read/write)
// let (ES6에서 추가됨)

//block scope
// 코드를 블럭안에 작성하면 밖에서는 블럭 안에 있는것을 볼 수 없다.

// global scope - 어디서든 불러올 수 있다.
let globalName = 'galobal name'

{
let name = 'kimrumm'
    console.log(name);
    name = 'hello';
    console.log(name);

}
console.log(globalName);

// var (don't ever use this!)
// var hoisting - 어디에 선언했는지 상관 없이 선언을 제일 위로 끌어올려주는 것 
// has no block scope

//Note! 
// Immutable 데이터 타입 : 데이터 자체를 절대 변경하지 못하게 한다. - premitive types, froznen objects
// Mutable 데이터 타입 : 변경이 가능한 데이터 타입 - all objets by default are mutable in JS
// - securtiy
// - thred safety
// - reduce human mistakes

// 3.Contant r(read only)
// 변수의 값이 계속 바뀌는 이유가 없다면 contant로 작성하는게 바람직하다.
// 한번 할당하면 값이 절대 바뀌지 않는다.
// favor immutable date type always for a few reasons:

const daysInweek = 7;
const maxNumber = 5;

// 4. Variable types 
// primitive, sing item: number, string Boolean, null, undefiedn, Symbol
// Object, box container
// function, first-class function

const count = 17; // integer
const size = 17.1; // decimal number 
console.log('value: ${count}, type:${typeof count}');
console.log('value: ${size}, type:${typeof size}');

//number - sepicla nuberic values : 
// 무한대의 숫자값 생성
const infinity = 1 / 0;
const nagativeInfinity = -1 / 0;
const nAn = 'not a number' / 2;
console.log(infinity);
console.log(nagativeInfinity);
console.log(nAn);

// bigInt (fairly new, don't use it yet)
const bigInt = 1234567890123456789012345678901234567890n; // over (-2**53) ~ 2*53)
console.log(`value: ${bigInt}, type: ${typeof bigInt}`);

// string
const char = 'c';
const brendan = 'brendan';
const greeting = 'hello ' + brendan;
console.log(`value: ${greeting}, type: ${typeof greeting}`);
const helloBob = `hi ${brendan}!`; //template literals (string) - 많이 쓰임
console.log(`value: ${helloBob}, type: ${typeof helloBob}`);
console.log('value: ' + helloBob + ' type: ' + typeof helloBob);

// boolean
// false: 0, null, undefined, NaN, ''
// true: any other value
const canRead = true;
const test = 3 < 1; // false
console.log(`value: ${canRead}, type: ${typeof canRead}`);
console.log(`value: ${test}, type: ${typeof test}`);

// null
let nothing = null;
console.log(`value: ${nothing}, type: ${typeof nothing}`);

// undefined
let x;
console.log(`value: ${x}, type: ${typeof x}`);

// symbol, create unique identifiers for objects
// 고유한 식별자나 동시다발적으로 일어나는 코드에서 우선순위를 주고 싶을때
const symbol1 = Symbol('id');
const symbol2 = Symbol('id');
//동일한지 아닌지 확인하는 방법
console.log(symbol1 === symbol2);
//동일한 심볼을 만드는 법
const gSymbol1 = Symbol.for('id');
const gSymbol2 = Symbol.for('id');
console.log(gSymbol1 === gSymbol2); // true
// .description 스트링으로 변환해서 출력해야한다.
console.log(`value: ${symbol1.description}, type: ${typeof symbol1}`);

// object, real-life object, data structure
// 일상에서 보는 물건과 물체들을 대표할 수 있는 박스 형태 
const ellie = { name: 'ellie', age: 20 };
ellie.age = 21;

// 자바스크립트의 하이라이트 
// 5. Dynamic typing: dynamically typed language
// 선언할때 어떤 타입인지 선언하지 않고 런타임(프로그램이 동작할때) 할당된 값에 따라서 타입이 변경 될 수 있다.
let text = 'hello';
console.log(text.charAt(0)); //h
console.log(`value: ${text}, type: ${typeof text}`);
text = 1;
console.log(`value: ${text}, type: ${typeof text}`);
text = '7' + 5;
console.log(`value: ${text}, type: ${typeof text}`);
text = '8' / '2';
console.log(`value: ${text}, type: ${typeof text}`);
console.log(text.charAt(0));