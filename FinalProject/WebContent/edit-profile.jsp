<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/script.js"></script>
</head>
<body>


	<div class="main-container">
		<div class="header">
			<jsp:include page="header.jsp"></jsp:include>
		</div>




		<div class="main">

			<div class="edit-profile add-product">

				<form id="registerform" action="Controller" method="post">
					<table align="center" id="register" class="register">

						<tr>
							<th><label for="heading">Edit Profile</label></th>
						</tr>
						<tr>
							<input type='hidden' value='update-profile' name="action">
						</tr>
						<tr>
							<td><label for="firstname">Firstname</label></td>
						</tr>
						<tr>
							<td><input type="text" name="firstname"
								placeholder="first name" id="firstname" value=<%=session.getAttribute("username")%>></td>
						</tr>
						<tr>
							<td id="error"><label for="error" id="firstnameError">&nbsp;</label></td>
						</tr>
						<tr>
							<td><label for="lastname">Lastname</label></td>
						</tr>
						<tr>
							<td><input type="text" name="lastname"
								placeholder="last name" id="lastname" value=<%=session.getAttribute("lastname")%>></td>
						</tr>


						<td id="error"><label for="error" id="lastnameError">&nbsp;</label></td>
						</tr>


						<tr>
							<td><label for="mobile">Mobile</label></td>
						</tr>
						<tr>
							<td><input type="tel" placeholder="mobile" name="mobile"
								id="mobile" value=<%=session.getAttribute("mobile")%>></td>
						</tr>
						<tr>
							<td id="error"><label for="error" id="mobileError">&nbsp;</label>
							</td>
						</tr>
						<tr>
							<td><label for="mail">E-mail</label></td>
						</tr>
						<tr>
							<td><input type="email" placeholder="email address"
								maxlength="100" name="mail" id="mail" value=<%=session.getAttribute("email")%>></td>
						</tr>
						<tr>
							<td id="error"><label for="error" id="mailError">&nbsp;</label></td>
						</tr>
						<tr>
							<th><label for="save"><input type="submit"
									name="submit" value="SAVE"
									onclick="return validate.validateEditform()"></label></th>
						</tr>
						<tr>
							<td id="error"><label id="err">&nbsp;</label></td>
						</tr>
					</table>
				</form>

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