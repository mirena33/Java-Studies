class sortedList {
    constructor() {
        this.collection = [];
        this.size = 0;
    }
    add(element) {
        this.size++;
        if (this.size == 0) {
            this.collection.push(element);
        } else {
            for (let i = 0; i < this.collection.length; i++) {
                if (element <= this.collection[i]) {
                    this.collection.splice(i, 0, element);
                    return;
                }
            }
            this.collection.push(element);
        }

    }
    remove(index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        this.collection.splice(index, 1);
        this.size--;
    }
    get(index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        return this.collection[index];
    }

}