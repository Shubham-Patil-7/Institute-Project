
<%@page import="java.util.ArrayList"%>
<%@page import="bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@page import="dao.CommonDao"%>
<%@page import="bean.CommonActionBean"%>
<%@page import="controller.Controller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OLX | HOME</title>
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/script.js"></script>
</head>
<body>

<%
	if(request.getParameter("status")!=null){
		if(request.getParameter("status").equals("exists")){
			//out.print("email exist");
		}
	}
	if(session.getAttribute("allProducts")==null){
		ArrayList products=(ArrayList) CommonDao.getAllProducts();
		session.setAttribute("allProducts", products);
	}
	if(request.getParameter("action")!=null && request.getParameter("action").equals("logout") && session!=null){
		session.invalidate();
		
		session=request.getSession();
	}

%>


	<div class="main-container">
		<div class="header">
			<jsp:include page="header.jsp"></jsp:include>
		</div>




		<div class="main">

			<div class="banner">

				<div id="" class="">
					<div class="dog-pic">
						<div class="circle"></div>
						<img src="images/Car.png" alt="Car" />
					</div>
					
				</div>

			</div>
			<div id="pet-clothing" class="products">
				<jsp:include page="products.jsp"></jsp:include>
			</div>

		</div>




		<div class="footer">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>

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