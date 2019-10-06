function solve(input) {
    let catalogue = {};
    const alphabeticalSort = (a, b) => a.localeCompare(b);

    for (let line of input) {
        let [name, price] = line.split(' : ');
        price = Number(price);
        let initial = name[0];

        if (!catalogue.hasOwnProperty(initial)) {
            catalogue[initial] = {};
        }

        let products = catalogue[initial];

        if (!products.hasOwnProperty(name)) {
            products[name] = price;
        }
    }

    let sortedInitials = Object.keys(catalogue) // obj convert to arr so we can sort
        .sort(alphabeticalSort);

    for (let init of sortedInitials) {
        console.log(init);

        let products = catalogue[init];
        let sortedProducts = Object.keys(products).sort(alphabeticalSort); // obj convert to arr so we can sort

        for (p of sortedProducts) {
            console.log(`  ${p}: ${products[p]}`);
        }

    }


}
