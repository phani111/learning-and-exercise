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
for(var i = 0; i < 3; i++) {
    setTimeout(function () { console.log(i); }, 100 * i);
}

// immediately invoke function expression (IIFE)
for(var i = 0; i < 3; i++) {
    (function(i) {
        setTimeout(function () { console.log(i); }, 100 * i);
    })(i);
}