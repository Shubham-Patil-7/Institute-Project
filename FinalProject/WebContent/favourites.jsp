<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="bean.ProductBean"%>
				<%@page import="java.util.Iterator"%>
				<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Favourites</title>
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
			<div id="pet-clothing" class="products">
				
				<div class="header">
					<div class="title">
						<span>Favourites</span>
					</div>
					<div class="shopBtn">
						<!-- <button value="shop"><sup>SHOP NOW</sup> <img src="images/forward.png" alt="forward" /></button> -->
					</div>
					<div id="clear-both"></div>
				</div>
				<%
					int totalProducts = 0, productsToShow = 0;
					out.print("<div class='Product'>");
					if (session.getAttribute("favouriteProductBeans") != null) {
						System.out.println("got fav productsbeans");
						ArrayList products = (ArrayList) session.getAttribute("favouriteProductBeans");
						System.out.println("got fav productsbean in list");
						totalProducts = products.size();
						productsToShow = Math.min(16, totalProducts);
						Iterator itr = products.iterator();
						System.out.println("after itrator ");
						String isLoggedIn = null;
						if (session.getAttribute("customer_id") != null) {
							isLoggedIn = "\"yes\"";
						}
						System.out.println("before iteration "+products);
						while (itr.hasNext()) {
							System.out.println("iteration");
							ProductBean bean = (ProductBean) itr.next();
							String background = "background:url(images/"+ bean.getCategory_name()+ ".png) #eeebe6; background-size:260px 250px;background-repeat:no-repeat;";
							session.setAttribute("p" + bean.getId(), bean);
							out.print("<div class='one'>");
							out.print("<a href='product.jsp?id=" + bean.getId() + "'>");
							out.print("<div class='pro-img' style='" + background+ "'>");
							out.print("<div class='feature'><span>New</span></div>");
							out.print("</div>");
							out.print("</a>");
							out.print("<div class='pro-info'>");
							out.print("<a href='#'><label>" + bean.getTitle()+ "</label></a><br>");
							out.print(bean.getDescription() + "<br>");
							out.print("<span class='price'>Rs. " + bean.getPrice()+ "</span>");
							out.print("</div>");
							out.print("<div class='buttons'>");
							out.print("<button value='add-cart' title='add to cart'>ADD TO CART</button>");
							out.print("<a href='#'><button id='fav' value='favorite' title='add to favorites' onclick='validate.addToFavourite(\""+ bean.getId()+ "\","+ isLoggedIn+ ")'><img id='favourite"+ bean.getId()+ "'' class='favourite"+ bean.getId()+ "'    src='images/liked.png' alt='favorite' width='16' height='16' /></button></a>");
							out.print("</div>");
							out.print("</div>");
						}

						out.print("<div id='clear-both'></div>");

					}
					out.print("</div>");
				%>

				<div id="clear-both"></div>
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