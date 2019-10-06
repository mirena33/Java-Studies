function createArticle() {
	let input = document.getElementById("createTitle");
	let textArea = document.getElementById("createContent");
	let articles = document.getElementById("articles");

	if (input === null || textArea === null || articles === null) {
		throw new Error("Something went wrong");
	}

	let h3 = document.createElement("h3");
	let p = document.createElement("p");
	let article = document.createElement("article");

	h3.innerHTML = input.value;
	p.innerHTML = textArea.value;

	article.appendChild(h3);
	article.appendChild(p);
	articles.appendChild(article);

}

const keysMap = {
	10: function () {
		createArticle();
	}
}

document.addEventListener("DOMContentLoaded", x => {
	document.
		getElementById("createArticleButton")
		.addEventListener("click", createArticle);

	document
		.addEventListener("keypress", function (evt) {
			if (typeof keysMap[evt.keyCode] === "function") {
				keysMap[evt.keyCode]();
			}
		})
});