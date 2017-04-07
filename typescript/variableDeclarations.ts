// var declarations
var a = 10;

// declare variable inside a function
function f() {
    var message = "this is a message";
    return message;
}
console.log(f())

// access same variable within other functions
function f2() {
    var a = 10;
    return function g() {
        var b = a + 1;
        return b;
    }
}

var g = f2();
console.log(g());

// a more complex example
function f3() {
    var a = 1;

    a = 2;
    var b = g();
    a = 3;

    return b;

    function g() {
        return a;
    }
}

console.log(f3())

// scoping rules
function f4(shouldInitialize: boolean) {
    if (shouldInitialize) {
        var x = 10;
    }
    return x;
}

console.log(f4(true));
console.log(f4(false));

// declare the same variable multiple times
function sumMatrix(matrix : number[][]) {
    var sum = 0;
    for(var i =0; i < matrix.length; i++) {
        var currentRow = matrix[i];
        for(var i = 0; i < currentRow.length; i++) {
            sum = sum + currentRow[i];
        }
    }
    return sum;
}
console.log(sumMatrix([[1,2,3], [4,5,6], [7,8,9]]));

// variable capturing quirks
/*
for(var i = 0; i < 3; i++) {
    setTimeout(function () { console.log(i); }, 100 * i);
}
*/

// immediately invoke function expression (IIFE)
/*
for(var i = 0; i < 3; i++) {
    (function(i) {
        setTimeout(function () { console.log(i); }, 100 * i);
    })(i);
}
*/

// let declaraions
let hello = "Hello!";

function f5(input: boolean) {
    let a = 100;
    if (input) {
        let b = a + 1;
    }
    // error, can not find 'b'
    // return b;
}

// variable declared in catch clause (can not access variable e out of block)


try {
    throw "oh no!";
} catch (e) {
    console.log("Oh, well.");
}

// declare within a distinctly different block
function f6(condition, x) {
    if (condition) {
        let x = 100;
        return x;
    }

    return x;
}

console.log(f6(true, 0));
console.log(f6(false, 0));

function sumMatrix2(matrix: number[][]) {
    let sum = 0;
    for(let i = 0; i < matrix.length; i++) {
        let currentRow = matrix[i];
        for(let i = 0; i < currentRow.length; i++) {
            sum = sum + currentRow[i];
        }
    }
    return sum;
}

console.log(sumMatrix2([[1,2,3], [4,5,6], [7,8,9]]));

function theCityThatAlwaysSleep() {
    let getCity;

    if(true) {
        let city = "Seattle";
        getCity = function () {
            return city;
        }
    }

    return getCity();
}

console.log(theCityThatAlwaysSleep());

// as part of a loop
/*
for(let i = 0; i < 3; i++) {
    setTimeout(function () { console.log(i); }, 100 * i);
}
*/