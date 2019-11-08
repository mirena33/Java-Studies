function solve() {
    class Balloon {
        constructor(color, gasWeight) {
            this.color = color;
            this.gasWeight = gasWeight;
        }
    }

    class PartyBalloon extends Balloon {
        constructor(color, gasWeight, ribbonColor, ribbonLength) {
            super(color, gasWeight);
            this.ribbonColor = ribbonColor;
            this.ribbonLength = ribbonLength;
        }
        get ribbon() {
            return { color: this.ribbonColor, length: this.ribbonLength };
        }
    }

    class BirthdayBalloon extends PartyBalloon {
        constructor(color, gasWeight, ribbonColor, ribbonLength, text) {
            super(color, gasWeight, ribbonColor, ribbonLength);
            this._text = text;
        }

        get text() {
            return this._text;
        }
    }

    return {
        Balloon,
        PartyBalloon,
        BirthdayBalloon
    }
}

//ANOTHER IMPLEMENTATION:

// function Balloon(color, gasWeight) {
//     this.color = color;
//     this.gasWeight = gasWeight;
// }

// function PartyBalloon(color, gasWeight, ribbonColor, ribbonLength) {
//     Balloon.call(this, color, gasWeight);
//     this.ribbonColor = ribbonColor;
//     this.ribbonLength = ribbonLength;

//     Object.defineProperty(this, 'ribbon', {
//         get: function () {
//             return { color: this.ribbonColor, length: this.ribbonLength };
//         }
//     });
// }

// PartyBalloon.prototype = Object.create(Balloon.prototype);
// PartyBalloon.prototype.constructor = PartyBalloon;

// function BirthdayBalloon(color, gasWeight, ribbonColor, ribbonLength, text) {
//     PartyBalloon.call(this, color, gasWeight, ribbonColor, ribbonLength);
//     this._text = text;

//     Object.defineProperty(this, 'text', {
//         get: function () {
//             this._text;
//         }
//     });
// }

// BirthdayBalloon.prototype = Object.create(PartyBalloon.prototype);
// BirthdayBalloon.prototype.constructor = PartyBalloon;