function validate() {
    document.addEventListener("blur", function (e) {
        if (
            e.target.value.match(/@/gi) === null ||
            e.target.value.match(/\./gi) === null
        ) {
            e.target.classList.add("error")
        } else {
            e.target.classList.remove("error")
        }
    }, true); //capture, because there is no input in bubble
}