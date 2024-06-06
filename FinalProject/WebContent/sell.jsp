<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sell</title>
	<link rel="stylesheet" href="css/style.css" />
	<script src="js/jquery-3.6.4.min.js"></script>
	<script src="js/script.js"></script>
</head>
<body>

<div class="main-container">
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="categories">
				<div id="pro-categories" class="">
					<div  onclick="validate.getBrands('Car')">
						<a>
							<div class="categories-images">
								<img src="images/Car.png" alt="car" />
							</div>
							<div class="categories-text"><span>Cars</span></div>
						</a>
					</div>

					<div onclick="validate.getBrands('Motor')">
						<a>
							<div class="categories-images">
								<img src="images/Motor.png" alt="motor" />
							</div>
							<div class="categories-text"><span>Motors</span></div>
						</a>
					</div>

					<div onclick="validate.getBrands('Mobile')">
						<a>
							<div class="categories-images">
								<img src="images/Mobile.png" alt="mobile" />
							</div>
							<div class="categories-text"><span>Mobiles</span></div>
						</a>

					</div>

					<div style="clear:both"></div>
				</div>
				<div style="clear:both"></div>
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