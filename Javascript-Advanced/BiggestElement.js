function solve(arr) {
    // return Math.max(...arr.flat(1));
    return Math.max(...arr.reduce((a, b) => [...a, ...b], []));
}
