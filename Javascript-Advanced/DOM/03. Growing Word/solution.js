const colourMap = ["#5B88BD", "#A40014", "#8FF897"];
let state = 0;

function growingWord() {
  const word = document.getElementById("growingWord"); // could be with .querySelector("#growingWord
  //or document.all.growingWord;

  if (word === null) {
    throw new Error("Something went wrong");
  }

  let fontSize = window.getComputedStyle(word).fontSize.replace("px", "");

  if (state >= colourMap.length) {
    state = 0;
  }

  word.style.color = colourMap[state];
  state++;

  word.style.fontSize = (fontSize === "0" ? "2" : fontSize * 2) + "px";

}