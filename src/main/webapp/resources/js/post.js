const deletePost = (postId) => {
    const url = "/post?postId=" + postId;
    
    $.ajax({
        url: url,
        type: 'DELETE'
    });
}

const editPost = (id) => {

	document.getElementById("updateId").value = id;
	document.getElementById("updateTitle").value = document.getElementById("title-"+id).innerHTML;
	document.getElementById("updateBody").value = document.getElementById("body-"+id).innerHTML;
			    
    // Open the modal
    let modal = new bootstrap.Modal(document.getElementById('staticUpdatePost'));
    modal.show();
}

const editPostApiCall = () => {
	let postId = document.getElementById("updateId").value;
	let title = document.getElementById("updateTitle").value;
	let body = document.getElementById("updateBody").value;
	let url = "/post?postId="+postId+"&title="+title+"&body="+body;
	
    $.ajax({
		url: url,
		type: 'PUT',
		data: {
			postId,
			title,
			body
		}	
	})
}

window.addEventListener('load', function () {
    let tokenElement = document.getElementById("token");
    if (tokenElement) {
        sessionStorage.setItem("token", tokenElement.textContent);
    }
    
	 
});
    