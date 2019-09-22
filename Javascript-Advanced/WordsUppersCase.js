function solve(str) {
    return str
        .match(/\w+/gim)
        .map(x => x.toUpperCase())
        .join(", ");
}