const template = x => `visited ${x} times`;
const affiliatesLinks = {
  "Google": 2,
  "YouTube": 4,
  "Gmail": 7,
  "Wikipedia": 4,
  "SoftUni": 1,
  "stackoverflow": 6,

}

document.addEventListener("click", (e) => {
  //better practice to filter by class name, not node name

  if (e.target && e.target.classList &&
    e.target.classList.contains("linkCta")) {

    e.target.parentNode.querySelector(".linkOut").innerHTML =
      template(affiliatesLinks[e.target.textContent.trim()]++);
  }
})