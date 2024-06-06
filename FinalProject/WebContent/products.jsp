<%@page import="bean.ProductBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<div class="header">
	<div class="title">
		<span>Products</span>
	</div>
	<div class="shopBtn">
		<!-- <button value="shop"><sup>SHOP NOW</sup> <img src="images/forward.png" alt="forward" /></button> -->
	</div>
	<div id="clear-both"></div>
</div>
<%



	
	
	if (session.getAttribute("allProducts") != null) {
		int totalProducts = 0, productsToShow = 0;
		ArrayList products = (ArrayList) session
				.getAttribute("allProducts");
		totalProducts = products.size();
		productsToShow = Math.min(8, totalProducts);
		Iterator itr = products.iterator();
	
		out.print("<div class='Product'>");
		String isLoggedIn = null;
		if (session.getAttribute("customer_id") != null) {
			isLoggedIn = "\"yes\"";
		}
		int no_of_products = 0;
		while (itr.hasNext() && no_of_products < productsToShow) {
			ProductBean bean = (ProductBean) itr.next();
			session.setAttribute("p" + bean.getId(), bean);

			String background = "background:url(images/"
					+ bean.getCategory_name()
					+ ".png) #eeebe6; background-size:260px 250px;background-repeat:no-repeat;";

			out.print("<div class='one'>");
			out.print("<a href='product.jsp?id=" + bean.getId() + "'>");
			out.print("<div class='pro-img' style='" + background
					+ "'>");
			out.print("<div class='feature'><span>New</span></div>");
			out.print("</div>");
			out.print("</a>");
			out.print("<div class='pro-info'>");
			out.print("<a href='#'><label>" + bean.getTitle()
					+ "</label></a><br>");
			out.print(bean.getDescription() + "<br>");
			out.print("<span class='price'>Rs. " + bean.getPrice()
					+ "</span>");
			out.print("</div>");
			out.print("<div class='buttons'>");
			out.print("<button value='owner' title='Owner Information'>OWNER INFO.</button>");
			out.print("<button id='fav' value='favorite' title='add to favorites' onclick='validate.addToFavourite(\""
					+ bean.getId()
					+ "\","
					+ isLoggedIn
					+ ")'><img id='favourite"
					+ bean.getId()
					+ "'' class='favourite"+ bean.getId()+ "'    src='images/unliked.png' alt='favorite' width='16' height='16' /></button>");
			out.print("</div>");
			out.print("</div>");
			no_of_products++;
		}

		out.print("<div id='clear-both'></div>");
		out.print("</div>");
	}
	
	
	if (session.getAttribute("productBeansByLocation") != null) {
		
		%>
		
		
		<div class="header">
			<div class="title">
				<span>Products By Locations</span>
			</div>
			<div class="shopBtn">
				<!-- <button value="shop"><sup>SHOP NOW</sup> <img src="images/forward.png" alt="forward" /></button> -->
			</div>
			<div id="clear-both"></div>
		</div>
		
		
		
		<%
		out.print("<div class='Product'>");
		int totalProducts = 0, productsToShow = 0;
		ArrayList products = (ArrayList) session
				.getAttribute("productBeansByLocation");
		totalProducts = products.size();
		productsToShow = Math.min(16, totalProducts);
		Iterator itr = products.iterator();

		String isLoggedIn = null;
		if (session.getAttribute("customer_id") != null) {
			isLoggedIn = "\"yes\"";
		}
		while (itr.hasNext()) {
			ProductBean bean = (ProductBean) itr.next();
			String background = "background:url(images/"
					+ bean.getCategory_name()
					+ ".png) #eeebe6; background-size:260px 250px;background-repeat:no-repeat;";
			session.setAttribute("p" + bean.getId(), bean);
			out.print("<div class='one'>");
			out.print("<a href='product.jsp?id=" + bean.getId() + "'>");
			out.print("<div class='pro-img' style='" + background
					+ "'>");
			out.print("<div class='feature'><span>New</span></div>");
			out.print("</div>");
			out.print("</a>");
			out.print("<div class='pro-info'>");
			out.print("<a href='#'><label>" + bean.getTitle()
					+ "</label></a><br>");
			out.print(bean.getDescription() + "<br>");
			out.print("<span class='price'>Rs. " + bean.getPrice()
					+ "</span>");
			out.print("</div>");
			out.print("<div class='buttons'>");
			out.print("<button value='owner' title='Owner Information'>OWNER INFO.</button>");
			out.print("<button id='fav' value='favorite' title='add to favorites' onclick='validate.addToFavourite(\""+ bean.getId()+ "\","+ isLoggedIn+ ")'><img id='favourite"+ bean.getId()+ "' class='favourite"+ bean.getId()+ "'   src='images/unliked.png' alt='favorite' width='16' height='16' /></button>");
			out.print("</div>");
			out.print("</div>");
		}

		out.print("<div id='clear-both'></div>");
		out.print("</div>");

	} else if (session.getAttribute("productBeansByCategories") != null) {

		int totalProducts = 0, productsToShow = 0;
		ArrayList products = (ArrayList) session
				.getAttribute("productBeansByCategories");
		totalProducts = products.size();
		productsToShow = Math.min(16, totalProducts);
		Iterator itr = products.iterator();

		%>
		
		
		<div class="header">
			<div class="title">
				<span>Products By Category</span>
			</div>
			<div class="shopBtn">
				<!-- <button value="shop"><sup>SHOP NOW</sup> <img src="images/forward.png" alt="forward" /></button> -->
			</div>
			<div id="clear-both"></div>
		</div>
		
		
		
		<%
		
		out.print("<div class='Product'>");

		String isLoggedIn = null;
		if (session.getAttribute("customer_id") != null) {
			isLoggedIn = "\"yes\"";
		}
		while (itr.hasNext()) {
			ProductBean bean = (ProductBean) itr.next();
			session.setAttribute("p" + bean.getId(), bean);

			String background = "background:url(images/"
					+ bean.getCategory_name()
					+ ".png) #eeebe6; background-size:260px 250px;background-repeat:no-repeat;";

			out.print("<div class='one'>");
			out.print("<a href='product.jsp?id=" + bean.getId() + "'>");
			out.print("<div class='pro-img' style='" + background
					+ "'>");
			out.print("<div class='feature'><span>New</span></div>");
			out.print("</div>");
			out.print("</a>");
			out.print("<div class='pro-info'>");
			out.print("<a href='#'><label>" + bean.getTitle()
					+ "</label></a><br>");
			out.print(bean.getDescription() + "<br>");
			out.print("<span class='price'>Rs. " + bean.getPrice()
					+ "</span>");
			out.print("</div>");
			out.print("<div class='buttons'>");
			out.print("<button value='owner' title='Owner Information'>OWNER INFO.</button>");
			out.print("<button id='fav' value='favorite' title='add to favorites' onclick='validate.addToFavourite(\""
					+ bean.getId()
					+ "\","
					+ isLoggedIn
					+ ")'><img id='favourite"
					+ bean.getId()
					+ "'' class='favourite"+ bean.getId()+ "'    src='images/unliked.png' alt='favorite' width='16' height='16' /></button>");
			out.print("</div>");
			out.print("</div>");
		}

		out.print("<div id='clear-both'></div>");
		out.print("</div>");
	}
%>

<div id="clear-both"></div>