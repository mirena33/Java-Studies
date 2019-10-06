function solve(input) {
    let step = +input.pop() % input.length;

    for (let i = 0; i < step; i++) {
        let el = input.pop();
        input.unshift(el);
    }
    return input.join(" ");

    // SOLUTION WITH .REDUCE:

    // return input.reduceRight((acc, curr) => {    reduce right gives us the elements from right to left
    //     if (step) {
    //         acc = [curr, ...acc.slice(0, input.length - 1)];
    //         step--;
    //     }
    //     return acc;
    // }, [...input]).join(" ");
}
