// a simple example
function printLabel (lablledObj : {label: string}) {
    console.log(lablledObj.label);
}

let myObj = {size: 10, label: "Size 10 Object"};
printLabel(myObj);

// an example of interface pattern
interface SquareConfig {
    color?: string;
    width?: number;
}

function createSquare (config : SquareConfig) : {color: string; area: number} {
    let newSquare = { color: "blue", area: 100 };

    if(config.color) {
        newSquare.color = config.color;
    }

    if(config.width) {
        newSquare.area = config.width * config.width;
    }

    return newSquare;
}