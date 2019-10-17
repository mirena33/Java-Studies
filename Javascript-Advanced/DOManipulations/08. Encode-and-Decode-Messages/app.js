function encodeAndDecodeMessages() {
	let buttons = document.getElementsByTagName("button");
	let textareas = document.getElementsByTagName("textarea");
	buttons[0].addEventListener('click',function(){
		let textToEncode = textareas[0].value;
		textareas[0].value = "";
		textareas[1].value = encodeText(textToEncode);
	});
	buttons[1].addEventListener('click',function(ev){
		
		let textToDecode = textareas[1].value;
		textareas[1].value = decodeText(textToDecode);
	});
	
    function encodeText(word){
		return word.split('').map(c => String.fromCharCode(c.charCodeAt(0)+1)).join('');
	}
	function decodeText(word){
		return word.split('').map(c => String.fromCharCode(c.charCodeAt(0)-1)).join('');
	}
}