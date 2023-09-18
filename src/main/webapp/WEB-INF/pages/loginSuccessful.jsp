<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Hello</title>
</head>
<body class="d-flex mx-auto">
	<div class="d-inline-flex flex-column justify-content-center border p-5 my-3 mx-auto">
		<h2>Welcome to Spring MVC</h2>
		
		<img src=${data.getImage()} width="100" class="border rounded-circle mx-auto" />
		<h3>Hello, ${data.getFirstName()} ${data.getLastName()}!</h3>
		<h3>Email: ${data.getEmail()}</h3>
		<h3>Gender: ${data.getGender()}</h3>
		<h3>Unique ID: ${data.getId()}</h3>
		<h3 id="token" hidden>${data.getToken()}</h3>
	</div>
	
	
	<script>
        // This script will run when the page is loaded
        window.addEventListener('load', function () {
            // Save the data to local storage
            var tokenElement = document.getElementById("token");
            if (tokenElement) {
                sessionStorage.setItem("token", tokenElement.textContent);
            }
        });
    </script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>