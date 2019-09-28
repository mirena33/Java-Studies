function solve(arr) {
    let first = 0;
    let second = 0;

    //DIAGONALS

    for (let row = 0; row < arr.length; row++) {
        first += arr[row][row];
        second += arr[row][arr.length - 1 - row];
    }

    return [first, second];
}

function anotherSolution(data) {
    return data.reduce((result, row, i, arr) => {

        result[0] += row[i];
        result[1] += row[arr.length - 1 - i];
        return result;

    }, [0, 0]
    )
}