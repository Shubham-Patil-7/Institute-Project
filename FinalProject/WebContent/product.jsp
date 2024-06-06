<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Product</title>
	<link rel="stylesheet" href="css/style.css" />
	<script src="js/jquery-3.6.4.min.js"></script>
	<script src="js/script.js"></script>

</head>
<body>

<div class="main-container">
	<jsp:include page="header.jsp"></jsp:include>
	<div class="main">
	<jsp:include page="product-details.jsp"></jsp:include>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>


	<!-- 					Login Page 					-->

	<div id="loginpage" class="login-page">
		<jsp:include page="login.jsp"></jsp:include>
	</div>


	<!--						Register								 -->


	<div id="registerpage" class="register-page">
		<jsp:include page="register.jsp"></jsp:include>
	</div>



	<!-- 					Logout Popup 					-->

	<div id="logoutpage" class="form-page">
		<jsp:include page="logout.jsp"></jsp:include>
	</div>


</body>
</html>