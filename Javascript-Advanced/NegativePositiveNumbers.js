function solve(arr) {

    const actionsMap = {
        true: "unshift",
        false: "push"
    }

    return arr
        .reduce((result, x) =>
            result[actionsMap[x < 0](x)] && result, [])
}
