let addCartBtn = document.querySelector("#addCartBtn");

addCartBtn.onclick = (e) => {
	e.preventDefault();
	
	addCart();
}

function addCart() {
	let param = {
			"pseq" : pseq.value,
			"quantity" : quantity.value,
   		};
   		
   		fetch('/WEB12_ShoesShop/cart/addCart.do', {
			method : 'POST',
			headers: {
				'Content-Type': 'application/json;charset=utf-8'
			},
				body: JSON.stringify(param)
			})
			.then(response => response.json())
			.then(jsonResult => {
				if (jsonResult.status == true) {					
					if (confirm(jsonResult.message + "\n장바구니 페이지로 가시겠습니까?")) {
						location.href = jsonResult.url;
					} else {
						return;
					}
				} else {
   					alert(jsonResult.message);
				}
		});
}