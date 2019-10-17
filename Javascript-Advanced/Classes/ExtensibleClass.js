const Extensible = (function () {
    let id = 0;

    return class Extensible {
        constructor() {
            this.id = id++;
        }

        extend(template) {
            Object.entries(template)
                .forEach(([key, value]) => {
                    if (typeof value === 'function') {
                        Object.getPrototypeOf(this)[key] = value;
                    } else {
                        this[key] = value;
                    }
                })
        }
    }
}())