function solve(num) {
    let arrayNum = String(num).split("");
    let isSame = true;
    let firstElement = arrayNum[0];


    arrayNum.forEach(function (element) {
        if (element != firstElement) {
            isSame = false;
        }
    });

    let sum = arrayNum
        .map(Number)
        .reduce((a, b) => a + b);

    console.log(isSame);
    console.log(sum);
}
