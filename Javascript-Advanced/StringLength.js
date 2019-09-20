function solve(arr1, arr2, arr3){
    let sumLength;
    let avrgLenth;

    let firstLength = arr1.length;
    let secondLength = arr2.length;
    let thirdLength = arr3.length;

    sumLength = firstLength + secondLength + thirdLength;
    avrgLenth = Math.floor(sumLength / 3);

    console.log(sumLength);
    console.log(avrgLenth);
}