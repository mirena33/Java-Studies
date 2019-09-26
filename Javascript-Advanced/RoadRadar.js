function solve(array) {
    let driverKmH = Number(array[0]);
    let driverArea = array[1];
    let exceededKmH = 0;

    switch (driverArea) {
        case `motorway`: exceededKmH = driverKmH - 130; break;
        case `interstate`: exceededKmH = driverKmH - 90; break;
        case `city`: exceededKmH = driverKmH - 50; break;
        case `residential`: exceededKmH = driverKmH - 20; break;
    }

    if (exceededKmH <= 0) {
        console.log(``);
    } else if (exceededKmH <= 20) {
        console.log(`speeding`);
    } else if (exceededKmH <= 40) {
        console.log(`excessive speeding`);
    } else {
        console.log(`reckless driving`);

    }
}
