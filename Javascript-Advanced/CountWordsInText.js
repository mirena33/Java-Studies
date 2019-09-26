function addPropIfMissing(a, b) {
    if (typeof a[b] === "undefined") {
        a[b] = 0;
    }
    return a;
}

function solve(str) {
    return str
        .match(/\w+/gim)
        .reduce((a, prop) => {
            addPropIfMissing(a, prop);
            a[prop]++;
            return a;
        }, {})
}
