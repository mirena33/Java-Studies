function solve(arg1, arg2, arg3) {

    let stepsFrmHomeToUni = Number(arg1);
    let footprintInMeters = Number(arg2);
    let speedPerHour = Number(arg3);

    let distanceInMeters = stepsFrmHomeToUni * footprintInMeters;
    let speedMeterSec = speedPerHour / 3.6;
    let time = distanceInMeters / speedMeterSec;
    let rest = Math.floor(distanceInMeters / 500);

    let timeMin = Math.floor(time / 60);
    let timeSec = Math.round(time - (timeMin * 60));
    let timeHr = Math.floor(time / 3600);

    console.log((timeHr < 10 ? "0" : "") + timeHr + ":" + (timeMin + rest < 10 ? "0" : "")
     + (timeMin + rest) + ":" + (timeSec < 10 ? "0" : "") + timeSec);
}
