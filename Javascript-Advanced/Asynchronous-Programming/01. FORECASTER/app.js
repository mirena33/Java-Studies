import { weather } from './fetch.js';

const elements = {
    location: () => document.getElementById("location"),
    submit: () => document.getElementById("submit"),
    current: () => document.getElementById("current"),
    upcoming: () => document.getElementById("upcoming"),
    forecast: () => document.getElementById("forecast"),
    content: () => document.getElementById("content")
}

const weatherSymbols = {
    sunny: "&#x2600",
    partlySunny: "&#x26C5",
    overcast: "&#x2601",
    rain: "&#x2614",
    degrees: "&#176"

}

function attachEvents() {
    elements.submit().addEventListener("click", getWeatherInfo);

    function getWeatherInfo() {
        const { code, name } = elements.location().value;

        weather().locations()
            .then((locations) => {
                const { code, name } = locations.find(o => o.name === o.location);

                return Promise.all([
                    weather().today(code),
                    weather().upcoming(code)
                ])
            })
            .then(([today, upcoming]) => {
                generateWeatherInfo(today, upcoming);
            })
            .catch(e => {
                const error = createHTMLElement('h1', [], 'ERROR');
                elements.content().appendChild(error);
            });
    }

    function generateWeatherInfo(today, upcoming) {
        elements.forecast().style.display = "block";

        const { condition, low, high } = today.forecast;
        const { name } = today;
        const symbol = getNormalizedSymbol(today.forecast.condition);

        const divForecastWrapper = createHTMLElement('div', ['forecasts']);
        const spanSymbol = createHTMLElement('span', ['condition', 'symbol'], weatherSymbols[symbol]);
        const spanWrapper = createHTMLElement('span', ['condition']);
        const spanName = createHTMLElement('span', ['forecast-data'], name);

        const degreesRange = `${low}${weatherSymbols.degrees}/${high}${weatherSymbols.degrees}`
        const spanDegrees = createHTMLElement('span', ['forecast-data'], degreesRange);
        const spanCondition = createHTMLElement('span', ['forecast-data'], condition);

        spanWrapper.append(spanName, spanDegrees, spanCondition);
        divForecastWrapper.append(spanSymbol, spanWrapper);

        divForecastWrapper.appendChild(spanSymbol);
        elements.current().appendChild(divForecastWrapper);

        generateUpcomingWeatherInfo(upcoming);
    }

    function generateUpcomingWeatherInfo(upcoming) {
        const divWrapper = createHTMLElement('div', ['forecast-info']);

        upcoming.forecast.forEach(o => {
            const { condition, low, high } = o;
            const symbol = getNormalizedSymbol(o.condition);
            const degreesRange = `${low}${weatherSymbols.degrees}/${high}${weatherSymbols.degrees}`
            const spanUpcoming = createHTMLElement('span', ['upcoming']);
            const spanSymbol = createHTMLElement('span', ['symbol'], weatherSymbols[symbol]);

            const spanDegrees = createHTMLElement('span', ['symbol'], degreesRange);
            const spanCondition = createHTMLElement('span', ['symbol'], condition);

            spanUpcoming.append(spanSymbol, spanDegrees, spanCondition);
            divWrapper.appendChild(spanUpcoming);
        });

        elements.upcoming().appendChild(divWrapper);
    }

    function getNormalizedSymbol(symbol) {
        return symbol.split('').filter(c => c !== ' ').map(c => c.toLowerCase()).join('');
    }


    function createHTMLElement(tagName, classNames = undefined, textContent) {
        const element = document.createElement(tagName);

        if (classNames) {
            element.classList.add(...classNames);
        }

        if (textContent) {
            element.textContent = textContent;
        }

        return element;
    }
}


attachEvents();