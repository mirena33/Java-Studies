function deserializeStringToArrayOfValues(str) {
    return str
        .split("|")
        .filter(x => x !== "")
        .map(x => x.trim())
        .map(x => Number(x) ? Math.floor(Number(x) * 100) / 100 : x)
    // parse if number
    //and format the number to the second floating point

}


function solve(data) {
    let keys = deserializeStringToArrayOfValues(data[0]);
    return data
        .slice(1)
        .map(deserializeStringToArrayOfValues)
        .map(x => x.reduce((res, val, i) => { //array to object
            res[keys[i]] = val;
            return res;    //reduce has to return the agregate(res) 
        }, {}))
}

console.log(solve(JSON.stringify(
    ['| Town | Latitude | Longitude |',
        '| Sofia | 42.696552 | 23.32601 |',
        '| Beijing | 39.913818 | 116.363625 |'])));

