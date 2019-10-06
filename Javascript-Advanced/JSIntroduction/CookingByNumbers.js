function solve(array) {
    let number = Number(array.shift());

    let operations = {
        chop: (x) => { return (x / 2) },
        dice: (x) => { return (Math.sqrt(x)) },
        spice: (x) => { return ++x },
        bake: (x) => { return x *= 3 },
        fillet: (x) => { return x *= 0.8 }
    }

    for (let index = 0; index < array.length; index++) {
        number = operations[array[index]](number);
        console.log(number);
    }
}
