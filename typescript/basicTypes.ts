// #Boolean
let isDone: boolean = false;

// #Number
let decimal: number = 6;
let hex: number = 0xf00d;
let binary: number = 0b1010;
let octal: number = 0o744;

// #String
let color: string = "blue";
color = 'red';

// #String -> template strings
let fullName: string = `Bob Bobbington`;
let age: number = 37;
let sentence: string = `Hello, my name is ${ fullName }
I'll be ${ age + 1 } years old next month.`;

// #Array
let list: number[] = [1, 2, 3];
let anotherWay: Array<number> = [1, 2, 3];

// #Tuple
let x: [string, number];
x = ["hello", 10];

// #Enum
enum Color {Red, Green, Blue};
let c: Color = Color.Green;

// #Enum => set values
enum Color2 {Red = 1, Green = 2, Blue = 4};
let c2: Color2 = Color2.Red;

// #Any
let notSure: any = 4;

// #Void
function warnUser() : void {
    alert("This is my warning message");
}

// #Void => only assign undefined or null
let unusable: void = undefined;

// #Null and undefined
let u: undefined = undefined;
let n: null = null;

// #Type assertions => angle-bracket
let someValue: any = "this is a string";
let strLength: number = (<string>someValue).length;

// #Type assertions => as-syntax
let someValue2: any = "this is another string";
let strLength2: number = (someValue as string).length;