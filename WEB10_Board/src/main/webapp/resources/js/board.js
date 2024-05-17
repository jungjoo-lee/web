let insertBoard = document.querySelector("#insertBoard");

registerBtn.addEventListener("submit", (e) => {
	e.preventDefault();
	
	fetch("/WEB10_Board/register.do", {
		method: 'POST',
		cache: 'no-cache',
		body: new FormData(uploadForm)})
		.then(response => response.json())
		.then(jsonResult => {
			alert(jsonResult.message);
		});
});