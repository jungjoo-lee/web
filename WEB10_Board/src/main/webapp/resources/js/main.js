let boardbody = document.querySelector("#boardbody");


let boardRegisterBtn = document.querySelector("#boardRegisterBtn");

boardRegisterBtn.onclick = () => {
    location.href = "/WEB10_Board/registerForm.do";
};
		
function getBoardList() {
	fetch('/WEB10_Board/board.do', {
		method : 'GET',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		}})
		.then(response => response.json())
		.then(jsonResult => {
			if (jsonResult.status == true) {
				let boardList = jsonResult.boardList;
				
				let content = '';
				let i = 0;
				
				boardList.forEach(() => {
					content += '<div class="row">';
					content += '<div class="col">' + boardList[i].num + '</div>';
					content += '<div class="col"><a href="/WEB10_Board/boardView.do?num=' + boardList[i].num + '">' + boardList[i].title + '</a></div>';
					content += '<div class="col">' + boardList[i].userid + '</div>';
					content += '<div class="col">' + boardList[i].writeDate + '</div>';
					content += '<div class="col">' + boardList[i++].readCount + '</div>';
					content += '</div>';
				});
				document.querySelector("#boardbody").innerHTML = content;
			} else {
				alert(jsonResult.message);
			}
	});
}

document.addEventListener("DOMContentLoaded", function() {
    getBoardList();
});