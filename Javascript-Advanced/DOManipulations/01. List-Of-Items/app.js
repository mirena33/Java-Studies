function createElement(type, content) {
    let e = document.createElement(type);
    if (typeof content === "string") {
        e.innerHTML = content;
    }
    if (typeof content === "object") {
        e.appendChild(content);
    }
    return e;
}

function ctaClickHandler(output, elementCreator, input) {
    return addItem(output, elementCreator, input.value);
}

function addToHTML(parent, child) {
    return parent.appendChild(child);
}

function removeFromHTMLByIndex(parent, index) {
    return parent.removeChild(parent.children[index]);
}
function listClickHandler(list, e) {
    if (e.target.nodeName === "A") {
        return removeItem(
            removeFromHTMLByIndex.bind(undefined, list),
            findChildIndexByRef.bind(undefined, list.children),
            e.target.parentNode
        )
    }
    return;
}

function addItem(output, elementCreator, value) {
    if (value !== "") {
        return output(elementCreator(value))
    }
    return;
}
function findChildIndexByRef(children, child) {
    return Array.prototype.findIndex.call(
        children,
        x => x === child
    )
}
function removeItem(output, elementLocator, element) {
    return output(elementLocator(element));
}

function main() {
    const cta = document.getElementById("addCTA");
    const list = document.getElementById("items");
    const input = document.getElementById("newItemText");
    if (cta === null || items === null || input === null) {
        throw new Error("Missing dom elements");
    }

    const clickHandlers = {
        CTAadd: ctaClickHandler.bind(undefined,
            addToHTML.bind(undefined, list),
            value => {
                let li = createElement("li");
                let a = createElement("a");
                a.setAttribute("href", "javascript:;");
                a.setAttribute("data-action", "CTAdelete");
                a.appendChild(document.createTextNode(`[Delete]`));
                li.appendChild(document.createTextNode(`${value} `));
                li.appendChild(a);
                return li;
            },
            input
        ),
        CTAdelete: listClickHandler.bind(undefined, list),
    }

    cta.addEventListener("click", clickHandlers.CTAadd);
    list.addEventListener("click", clickHandlers.CTAdelete);

    document.body.addEventListener("click", function (e) {
        if (typeof clickHandlers[e.target.dataset.action] === "function") {
            clickHandlers[e.target.dataset.action](e);
        }
    });
}

document.addEventListener("DOMContentLoaded", main);
