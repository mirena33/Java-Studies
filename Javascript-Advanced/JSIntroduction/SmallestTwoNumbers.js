function solve(arr) {
    return arr
        .slice() // so that we do not modify the original array
        .sort((a, b) => a - b)
        .slice(0, 2)
        .join(" ");
}
