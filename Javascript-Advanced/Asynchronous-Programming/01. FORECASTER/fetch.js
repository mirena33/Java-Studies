export function weather() {
    const baseURL = `https://judgetests.firebaseio.com/`;

    return {
        locations: () => fetch(baseURL + `locations.json`).then(res => res.json()),

        today: (code) => fetch(baseURL + `forecast/today/${code}.json`).then(res => res.json()),

        upcoming: (code) => fetch(baseURL + `forecast/upcoming/${code}.json`).then(res => res.json())
    }
}