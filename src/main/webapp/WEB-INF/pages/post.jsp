<%@page import="java.util.List"%>
<%@page import="com.abhinav.bean.PostBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>Hello</title>
</head>
<body class="d-flex flex-column mx-auto">
	<div
		class="d-inline-flex flex-column justify-content-center border p-5 my-3 mx-auto">
		<h2>Welcome to Spring MVC</h2>

		<img src=${data.getImage() } width="100" alt="profile"
			class="border rounded-circle mx-auto" />
		<h3>Hello, ${data.getFirstName()} ${data.getLastName()}!</h3>
		<h3>Email: ${data.getEmail()}</h3>
		<h3>Gender: ${data.getGender()}</h3>
		<h3>Unique ID: ${data.getId()}</h3>
		<h3 id="token" hidden>${data.getToken()}</h3>
	</div>

	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary mx-auto my-2"
		data-bs-toggle="modal" data-bs-target="#staticCreatePost">
		Create Post</button>

	<!-- Create Modal -->
	<div class="modal fade" id="staticCreatePost" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Create Post</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="/create-post" method="POST">
						<label>Title</label> <br> <input class="w-100" name="title"
							type="text" required /> <br> <br> <label>Body</label>
						<textarea class="w-100 my-2" name="body" rows="4" required></textarea>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Create</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Update Modal -->
	<div class="modal fade" id="staticUpdatePost" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Edit Post</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="/post" id="updatePostForm" method="POST">
						<input id="updateId" class="w-100" name="postId" type="text"
							hidden=true /> <label>Title</label> <br> <input
							id="updateTitle" class="w-100" name="title" type="text" required />
						<br> <br> <label>Body</label>
						<textarea id="updateBody" class="w-100 my-2" name="body" rows="4"
							required></textarea>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button onClick="editPostApiCall()" class="btn btn-primary">Update</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<div class="d-flex flex-wrap">
		<%
		    Object postsObject = request.getAttribute("posts");
		
		    if (postsObject != null && postsObject instanceof List<?>) {
		        List<?> rawList = (List<?>) postsObject;
		
		        for (Object item : rawList) {
		            if (item instanceof PostBean) {
		                PostBean post = (PostBean) item;
		%>
		<div class="card m-2 mx-auto" style="width: 30%">
			<div class="card-body">
				<h5 class="card-title" id='title-<%= post.getPostId() %>'><%= post.getTitle() %></h5>
				<p class="card-text" id='body-<%= post.getPostId() %>'><%= post.getBody() %></p>
				<form action="/post" method="GET">
					<button type="submit"
						onClick="deletePost('<%= post.getPostId() %>')"
						class="deletePost btn btn-primary">Delete</button>
					<button type="button" onclick="editPost('<%= post.getPostId() %>')"
						class="btn btn-primary mx-auto my-2">Edit Post</button>
				</form>
			</div>
		</div>
		<%
		            }
		        }
		    } else {
		%>
		<p>No posts available.</p>
		<%
		    }
		%>


	</div>


	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/post.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>