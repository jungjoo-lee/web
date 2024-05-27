let idCheckBtn = document.querySelector("#idCheckBtn");
idCheckBtn.onclick = (e) => {
	e.preventDefault();
	
	idCheck();
}

function idCheck() {
	let param = {
		"userid" : userid.value,
	};
	
	fetch('/WEB12_ShoesShop/member/idcheck.do', {
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
			} else {
				alert(jsonResult.message);
			}
	});
}

let zipCodeBtn = document.getElementById("zipCodeBtn");

zipCodeBtn.addEventListener("click", (e) => {
  	e.preventDefault();
  	findAddr();
});

function findAddr(){
	new daum.Postcode({
        oncomplete: function(data) {
            var roadAddr = data.roadAddress;
            var jibunAddr = data.jibunAddress;

            document.getElementById('zip_code').value = data.zonecode;
            if(roadAddr !== ''){
                document.getElementById("address1").value = roadAddr;
            } 
            else if(jibunAddr !== ''){
                document.getElementById("address2").value = jibunAddr;
            }
        }
    }).open();
}

let send_auth =  document.getElementById("send_auth");

send_auth.addEventListener("click", (e) => {
  	e.preventDefault();
  	
  	send_email();
});

function send_email() {
	if (email.value != null && email.value != '') {
		fetch("/WEB12_ShoesShop/member/send_auth.do", {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json;charset=utf-8'
			},
			body: JSON.stringify({
				email: email.value,
			})
		})
		.then(response => response.json())
		.then(jsonResult => {
			if (jsonResult.status == true) {
				alert(jsonResult.message);
			} else {
				alert(jsonResult.message);
			}
		});
	} else {
		alert('이메일을 입력해주세요.');
	}
}

let joinBtn = document.querySelector("#joinBtn");
    	
joinBtn.onclick = (e) => {
	e.preventDefault();
	
	join();
}

function join() {
	if (confirm("가입 하시겠습니까?") == true) {
		let param = {
			"userid" : userid.value,
			"pwd" : pwd.value,
			"name" : userName.value,
			"phone" : phone.value,
			"email" : email.value,
			"zip_num" : zip_code.value,
			"address1" : address1.value,
			"address2" : address2.value,
		};
		
		fetch('/WEB12_ShoesShop/member/join.do', {
			method : 'POST',
			headers: {
			    'Content-Type': 'application/json;charset=utf-8'
			},
			body: JSON.stringify(param)			
		})
		.then(response => response.json())
		.then(jsonResult => {
			alert(jsonResult.message);
			
			if (jsonResult.status == true) {
				location.href = jsonResult.url;
			}
		});
	} else {
		return;
	}	
}