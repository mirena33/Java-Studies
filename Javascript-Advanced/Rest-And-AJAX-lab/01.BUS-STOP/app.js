function getInfo() {
    const stopIdInput = document.getElementById("stopId");
    const stopName = document.getElementById("stopName");
    const busContainer = document.getElementById("buses");

    const fetchBusesUrl = `https://judgetests.firebaseio.com/businfo/${stopIdInput.value}.json`;

    busContainer.innerHTML = '';
    stopName.innerHTML = '';
    
    fetch(fetchBusesUrl)
        .then(res => res.json())
        .then(data => {
            const { name, buses } = data;
            stopName.textContent = name;
            Object.entries(buses)
                .forEach(([busId, busTime]) => {
                    const li = document.createElement("li");
                    li.textContent = `Bus ${busId} arrives in ${busTime} minutes.`;
                    busContainer.appendChild(li);
                });
        })
        .catch(err => {
            stopName.textContent = "Error";

        });
}