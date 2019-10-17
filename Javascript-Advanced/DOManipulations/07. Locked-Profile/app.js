function lockedProfile() {
    let profilesButtons = document.getElementsByTagName("button");
     for(const btn of profilesButtons){
        btn.addEventListener('click',toggle);
     }
     function toggle(ev){
         let current = ev.target;
         if(current.parentElement.getElementsByTagName("input")[1].checked){
             switch(current.innerHTML){
                 case "Show more":
                     current.parentElement.getElementsByTagName('div')[0].style.display = 'block';
                     current.innerHTML = "Hide it";
                     break;
                 case "Hide it":
                     current.parentElement.getElementsByTagName('div')[0].style.display = 'none';
                     current.innerHTML = "Show more";
                     break;
             }	
         }
         
     }
 }
 