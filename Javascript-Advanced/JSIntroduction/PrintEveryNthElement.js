function solve(arr) {
    
    let step = +arr.pop();
    return arr
        .filter((element, index) => index % step === 0)
        .join("\n");
}
