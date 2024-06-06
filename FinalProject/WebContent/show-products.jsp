<%@page import="bean.ProductBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Products</title>
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/script.js"></script>
</head>
<body><div class="header">
			
<%
	
%>

<%!public String isLoggedIn(HttpServletRequest req, String s) {
		HttpSession session = req.getSession();
		if (session.getAttribute("username") == null) {
			return "formPopups.openLogin()";
		}
		if (s.equals("profile")) {
			return "\"formPopups.openAdminDropDown()\"";
		}else if(s.equals("favourite")){
			return "\"validate.showAllFavourites()\"s";
		}
		else {
			return "\"\" href=\"admin-dashboard.jsp\"";
		}
	}

	public String user(HttpServletRequest req) {
		HttpSession session = req.getSession();

		if (session.getAttribute("username") != null) {
			return session.getAttribute("username").toString();
		}
		return "";
	}%>
	
	<div class="main-container">
	<div class="header">
	<header>
	<div class="logo">
		<a href="admin-dashboard.jsp"><img title="Admin Portal" src="images/logo.png"
			width="200" height="60" alt="logo"></a>
	</div>
	<div class="srch-con">
		<div class="search-container">
			<div class="search">
				<div>
					<input id="search" title="start typing product name"
						placeholder="Search For More Than 10,000 Products" type="text">
				</div>
				<div id="serch-btn">
					<button>
						<img src="images/search.png" title="search" alt="search" />
					</button>
				</div>
			</div>
		</div>
		<div class="contact">
			<div class="location-search">
				<div class="search">
					<div>
						<div>
							<input id="search-location" title="start typing product name"
								placeholder="search location" type="text"
								oninput="validate.getLocations()">
						</div>

						<div id="serch-btn">
							<button>
								<img src="images/search.png" title="search" alt="search" />
							</button>
						</div>
					</div>
					<div>
						<div id="loc">
							<div class="dropdown-search" id="drop-location"></div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<div id="clear-both"></div>

	</div>
	<div id="clear-both"></div>
</header>
<hr>
<nav>
	<div>

		<div class="category">
			<div class="pets">
				<select title="pet categories" name="category" onchange="validate.selectedCategory(this)">
					<option value="Shop By Category" selected>Shop By Category</option>
					<option value="Car"  onchange="validate.selectedCategory(this)">Cars</option>
					<option value="Motor" onchange="validate.selectedCategory(this)">Motorcyles</option>
					<option value="Mobile" onchange="validate.selectedCategory(this)">Mobiles</option>
				</select>
			</div>
			<div id="clear-both"></div>
		</div>
		<div class="nav-bar">
			<div class="nav-bar-content">
				
			</div>

		</div>
		<div class="profiles">
			<div class="signed-user">
				<div id="label">
					<label> <pre id="user"><%=user(request)%></pre>
					</label>
				</div>
			</div>
			<div id="profile-icon">
				<div>
					<a onclick=<%=isLoggedIn(request, "profile")%> id="profile"> <img src="images/user.png" alt="user" />
					</a>
					<div class="dropdown" id="drop-profile">
						<div><%=user(request) %></div>
						<div>
							<a href="edit-profile.jsp"><div>Edit Profile</div></a>
						</div>
						<div>
							<a href="dashboard.jsp"><div>Dashboard</div></a>
						</div>
						<div>
							<div onclick="formPopups.openLogout()">Sign Out</div>
						</div>
					</div>
				</div>
				<div>
					<a onclick=<%=isLoggedIn(request, "favourite")%> title="favorites" > 
						<img src="images/unliked.png" alt="favorite" />
					</a>
				</div>
				<div>
					<a onclick=<%=isLoggedIn(request, "dashboard")%> title="dashboard" >
						<img src="images/sell.png" alt="dashboard" />
					</a>
				</div>
			</div>
		</div>
		<div id="clear-both"></div>

	</div>
	<div id="clear-both"></div>
</nav>

</div>



<div class="main">

			<div class="banner">
				<div class="admin-tables">
						<table align="center" border="solid 1px" cellspacing="0" cellpadding="0">

							<tr>
								<th>Product ID</th>
								<th>Text</th>
								<th>Description</th>
								<th>Category</th>
								<th>Category Details</th>
								<th>Price</th>
								<th>Aprove Request</th>
								<th>isActive</th>
								<th>Created By</th>
								<th>Created Date</th>
								<th>Modified By</th>
								<th>Modified Date</th>
							</tr>
							<%
								
								if (session.getAttribute("allProducts") != null) {
									ArrayList products = (ArrayList) session.getAttribute("allProducts");
									
									Iterator itr=products.iterator();

									while (itr.hasNext()) {
										ProductBean productBean = (ProductBean) itr.next();
										out.print("<tr>");
										out.print("<td>" + productBean.getId() + "</td>");
										out.print("<td>" + productBean.getTitle() + "</td>");
										out.print("<td>" + productBean.getDescription() + "</td>");
										out.print("<td>" + productBean.getCategory_name()+ "</td>");
										out.print("<td>" + productBean.getDetails().replace("\"", "") + "</td>");
										out.print("<td>" + productBean.getPrice() + "</td>");
										out.print("<td>" + productBean.isResquestStatus() + "</td>");
										out.print("<td>" + productBean.getIsActive() + "</td>");
										out.print("<td>" + productBean.getCreated_by() + "</td>");
										out.print("<td>" + productBean.getCreated_date() + "</td>");
										out.print("<td>" + productBean.getModified_by() + "</td>");
										out.print("<td>" + productBean.getModified_date() + "</td>");
										out.print("</tr>");
									}
								}
							%>
						</table>


					</div>
				
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