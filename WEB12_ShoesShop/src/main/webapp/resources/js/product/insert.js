let insertProduct = document.querySelector("#insertProduct");

insertProduct.addEventListener("submit", (e) => {
	e.preventDefault();

	fetch("/WEB12_ShoesShop/product/insertProduct.do", {
		method: 'POST',
		cache: 'no-cache',
		body: new FormData(insertProduct)
	})
		.then(response => response.json())
		.then(jsonResult => {
			alert(jsonResult.message);

			if (jsonResult.status == true) {
				location.href = jsonResult.url;
			}
		});
});