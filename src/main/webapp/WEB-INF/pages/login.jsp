<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Spring MVC Project</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	</head>
	<body>
		<form action="login" class=" col-4 mx-auto border p-3 rounded-3 m-3" method="POST">
			<h5 style="color: red;">${error}</h5>
			<div class="col-auto">
			    <label for="autoSizingInputGroup">Username:</label>
			    <div class="input-group">
			      <div class="input-group-text">@</div>
			      <input type="text" class="form-control" name="email" id="autoSizingInputGroup" placeholder="Username">
			    </div>
			</div>
			  <br>
			<div class="mb-3">
			  <label>Password:</label>
			  <input type="password" name="pass" class="form-control" id="formGroupExampleInput2" placeholder="Password">
			</div>
			<input class="btn btn-outline-primary w-100	" type="Submit">
		</form>
	</body>
</html>
