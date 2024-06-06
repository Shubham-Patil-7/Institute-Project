
<%@page import="bean.ProductBean"%>
<%
	ProductBean bean=(ProductBean) session.getAttribute("p"+request.getParameter("id"));
%>

<div class="banner">
	<div id="" class="">
		<div class="dog-pic">
			<div class="circle"></div>
			<img src="images/<%=bean.getCategory_name() %>.png" alt="product" width="600" height="400" />
		</div>
		<div class="qoute-text">
			<div class="txt">
				<table border="solid 1px red" cellspacing="0">
					<tr>
						<th colspan="2">Product Details</th>
					</tr>
					<tr>
						<td>Title</td>
						<td><%=bean.getTitle() %></td>
					</tr>
					<tr>
						<td>Description</td>
						<td><%=bean.getDescription() %></td>
					</tr>
					<tr>
						<td>Other Details</td>
						<td><%=bean.getDetails().replace("{","").replace("}","").replace("\"","") %></td>
					</tr>
					<tr>
						<td>Price</td>
						<td><%=bean.getPrice()%></td>
					</tr>
				</table>
			</div>
		</div>
		<div id="clear-both"></div>
	</div>

</div>