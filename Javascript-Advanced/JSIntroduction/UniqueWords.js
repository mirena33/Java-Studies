function solve(data) {
    return [
        ...new Set(data
            .join("")
            .toLowerCase()
            .match(/\w+/gim)) // global case insensitive multiline
    ]
        .join(", ") // set has no join method so we use ... to make an array and join the elements that way
}