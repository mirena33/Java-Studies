function solve(input) {
    let juices = {};
    let bottles = {};

    //ANOTHER APPROACH:
    // for(let [name, quantity] of input){
    //     quantity = Number(quantity);

    //     if (!juices.hasOwnProperty) {
    //         juices[name] = 0;
    //     }

    //     juices[name] += quantity;
    //     let currentQuantity = juices[name];

    //     if (currentQuantity >= 1000) {
    //         bottles[name] = Math.trunc(currentQuantity / 1000);
    //     }
    // }


    input
        .forEach((line) => {
            let [name, quantity] = line.split(" => ");
            quantity = Number(quantity);

            if (!juices.hasOwnProperty(name)) {
                juices[name] = 0;
            }

            juices[name] += quantity;
            let currentQuantity = juices[name];

            if (currentQuantity >= 1000) {
                bottles[name] = Math.trunc(currentQuantity / 1000);
            }

        });

    let keys = Object.keys(bottles);
    for (let name of keys) {
        let quantity = bottles[name];

        console.log(`${name} => ${quantity}`);
    }

}

solve(['Orange => 2000',
    'Peach => 1432',
    'Banana => 450',
    'Peach => 600',
    'Strawberry => 549']
)
