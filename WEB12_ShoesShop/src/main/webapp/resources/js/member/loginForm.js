let loginBtn = document.querySelector("#loginBtn");
loginBtn.onclick = (e) => {
	e.preventDefault();
	
	login();
}

function login() {
	let param = {
			"userid" : userid.value,
			"pwd" : pwd.value,
   		};
   		
   		fetch('/WEB12_ShoesShop/member/login.do', {
			method : 'POST',
			headers: {
				'Content-Type': 'application/json;charset=utf-8'
			},
				body: JSON.stringify(param)
			})
			.then(response => response.json())
			.then(jsonResult => {
				if (jsonResult.status == true) {
					alert(jsonResult.message);
					location.href = jsonResult.url;
				} else {
   					alert(jsonResult.message);
				}
		});
}