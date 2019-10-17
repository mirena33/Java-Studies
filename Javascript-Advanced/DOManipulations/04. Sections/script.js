function create(words) {
   let content = document.getElementById("content");
   let divTemplate = document.createElement("div");
   let par = document.createElement("p");

   par.style.display = 'none';
   divTemplate.appendChild(par);

   for (const word of words) {
      let div = divTemplate.cloneNode(true);
      div.getElementsByTagName("p")[0].innerHTML = word;
      div.addEventListener('click', function (ev) {
         console.log("clicked");
         ev.target.getElementsByTagName("p")[0].style.display = 'block';
      });

      content.appendChild(div);
   }
}