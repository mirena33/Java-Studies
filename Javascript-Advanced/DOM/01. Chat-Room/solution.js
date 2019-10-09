function solve() {
   const sendBtn = document.getElementById('send');
   const messageContainer = document.getElementById('chat_input');

   sendBtn.addEventListener("click", sendMessage);

   function sendMessage() {
      let textInput = messageContainer.value;
      let message = document.createElement('div');
      message.classList.add('message', 'my-message'); //adding classes to our <div>

      message.textContent = textInput; //assigning the input to our <div>
      document.getElementById('chat_messages').appendChild(message); // apending the ready <div> to our chatbox

      messageContainer.value = ''; //clearing the input textbox after sending the message
   }
}


