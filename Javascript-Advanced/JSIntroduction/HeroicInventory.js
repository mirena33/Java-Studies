function solve(input) {
    let heroes = [];

    for (let line of input) {
        let [name, level, items] = line.split(" / ");
        level = Number(level);
        items = items ? items.split(", ") : []; // if there are no items, create empty array

        heroes.push({ name, level, items });
    }

    console.log(JSON.stringify(heroes));
}
