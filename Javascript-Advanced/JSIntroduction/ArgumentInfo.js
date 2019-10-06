function solve(...input) {
    Object.entries(
        input
            .reduce((previous, current) => {
                let typeOfArg = typeof current;
                console.log(`${typeOfArg}: ${current}`);

                if (!previous.hasOwnProperty(typeOfArg)) {
                    previous[typeOfArg] = 0;
                }

                previous[typeOfArg]++;

                return previous;
            }, {})
    )
        .map(([type, count]) => `${type} = ${count}`)
        .sort((a, b) => b[1] - a[1])
        .forEach((el) => console.log(el));

}