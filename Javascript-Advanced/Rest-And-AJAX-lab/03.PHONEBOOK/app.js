function attachEvents() {
    const phonebookContainer = document.getElementById("phonebook");
    const personInput = document.getElementById("person");
    const phoneInput = document.getElementById("phone");

    function loadPhonebook() {
        fetch(`https://phonebook-nakov.firebaseio.com/phonebook.json`)
            .then(res => res.json())
            .then(data => {
                Object.entries(data).forEach(([elId, phonebookData]) => {
                    const { phone, person } = phonebookData;
                    const li = document.createElement("li");
                    li.textContent = `${person}: ${phone}`;

                    const deleteBtn = document.createElement("button");
                    deleteBtn.setAttribute("data-target", elId);
                    deleteBtn.addEventListener("click", deletePhonebook);
                    deleteBtn.textContent = "Delete";

                    li.appendChild(deleteBtn);
                    phonebookContainer.appendChild(li);
                })
            })
            .catch(err => {

            })

    }

    function deletePhonebook() {
        const phonebookId = this.getAttribute('data-target');
        const headers = {
            method: "DELETE"
        }

        fetch(`https://phonebook-nakov.firebaseio.com/phonebook/${phonebookId}.json`, headers)
            .then(() => {
                phonebookContainer.innerHTML = '';
                loadPhonebook();
            }).catch(err => {

            })

    }

    function createPhonebook() {
        const person = personInput.value;
        const phone = phoneInput.value;

        const headers = {
            method: 'POST',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify({ person, phone })
        }

        fetch(`https://phonebook-nakov.firebaseio.com/phonebook.json`, headers)
            // .then(res => res.json())
            .then(() => {
                phonebookContainer.innerHTML = '';
                personInput.value = '';
                phoneInput.value = '';

                loadPhonebook();
            }).catch(err => console.log(err));

    }


    return {
        loadPhonebook,
        createPhonebook
    }
}

let result = attachEvents();