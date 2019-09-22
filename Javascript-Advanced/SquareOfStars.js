function solve(starsCount) {
    let result = new Array(starsCount);
    for (let i = 1; i <= starsCount; i++) {
        result[i] = `*`
            .repeat(starsCount)
            .split("")
            .join(" ");
    }
    return result.join("\n");
}