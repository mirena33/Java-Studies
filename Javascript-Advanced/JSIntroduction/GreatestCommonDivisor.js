function solve(x, y) {
    while (y) { //while it is not falsy value(0).
        let temp = y;
        y = x % y;
        x = temp;
    }
    return x;
}
