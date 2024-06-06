<%-- <%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%> --%>
<%
	String[] brands={},models={};
	if(session.getAttribute("brands")!=null){
		brands=session.getAttribute("brands").toString().split("[,]",0);
	}
	if(session.getAttribute("models")!=null){
		models=session.getAttribute("models").toString().split("[,]",0);
	}
	String mobileDisplay="",motorDisplay="";
	if(session.getAttribute("formtype")!=null){
		if(session.getAttribute("formtype").equals("Mobile")){
			mobileDisplay=" style='display:none'";
		}
		else if(session.getAttribute("formtype").equals("Motor")){
			motorDisplay=" style='display:none'";
		}
		else{
			mobileDisplay=" style='display:block'";
			motorDisplay=" style='display:block'";
		}
	}
%>


<div class="add-product" id="addProductPage">
	<div class="add-product-form-container">
		<form id="add-Product" action="Controller" method="post">
			<table id="addproduct" align="center">
			
				<tr>
					<th><label for="heading">ADD PRODUCT</label></th>
				</tr>
				<tr><input type='hidden' value='addProduct' name="action"></tr>
				<tr><input type='hidden' value='<%=request.getParameter("category") %>' name="type" id="category"></tr>
				<tr class="all">
					<td><label for="brand">Brand</label></td>
				</tr>
				<tr>
					
					<td>
						<select name="brand"  onchange="validate.validateOnselect(this)" id="brand">
						<option value="" selected> 
						<%
							for(int i=0;i<brands.length;i++){
								out.print("<option value='"+brands[i]+"'> "+brands[i]);
							}
						%>
						</select>
					</td>
				</tr>
				
				<tr class="models">
					<td><label for="model">Model</label></td>
				</tr>
				<tr class="models">
					
					<td>
						<select name="model" onclick="validate.validateOnselect(this)" onchange="validate.validateOnselect(this)" id="model">
						
						</select>
					</td>
				</tr>
				<tr>
					<td><label for="year">Year</label></td>
				</tr>
				<tr>
					<td><input type="text"	name="year" id="year"></td>
				</tr>
				<tr <%= motorDisplay%> <%= mobileDisplay%>>
					<td><label for="fuel">Fuel</label></td>
				</tr>
				<tr  <%= motorDisplay%> <%= mobileDisplay%>>
					<td>
						<label for="cngHybrids"><input type="radio" id="cngHybrids" name="fuelType" value="cngHybrids"><div>CNG & Hybrids</div></label>
						<label for="Diesel" ><input type="radio" id="Diesel" name="fuelType" value="Diesel"><div>Diesel</div></label>
						<label for="Electric" ><input type="radio" id="Electric" name="fuelType" value="Electric"><div>Electric</div></label>
						<label for="LPG" ><input type="radio" id="LPG" name="fuelType" value="LPG"><div>LPG</div></label>
						<label for="Petrol" ><input type="radio" id="Petrol" name="fuelType" value="Petrol"><div>Petrol</div></label>
					</td>
				</tr>
				<tr <%= motorDisplay%> <%= mobileDisplay%>>
					<td><label for="transmission">Transmission</label></td>
				</tr>
				<tr <%= motorDisplay%> <%= mobileDisplay%>>
					<td class="transmission">
						<label for="auto"><input type="radio" id="auto" name="transmission" value="Automatic"><div >Automatic</div></label>
						<label for="manual"><input type="radio" id="manual" name="transmission" value="Manual"><div  >Manual</div></label>
					</td>
				</tr>
				<tr  <%= mobileDisplay%>>
					<td><label for="km">KM Driven</label></td>
				</tr>
				<tr <%= mobileDisplay%>>
					<td>
						<input type="text" name="km" id="km">
					</td>
				</tr>
				<tr>
					<td><label for="no-of-owners">No. of Owners</label></td>
				</tr>
				<tr>
					<td>
						<label><input type="radio" id="one" name="no-of-owners" value="1"><div>1<sup>st</sup></div></label>
						<label><input type="radio" id="two" name="no-of-owners" value="2"><div>2<sup>nd</sup></div></label>
						<label><input type="radio" id="three" name="no-of-owners" value="3"><div>3<sup>rd</sup></div></label>
						<label><input type="radio" id="four" name="no-of-owners" value="4"><div>4<sup>th</sup></div></label>
						<label><input type="radio" id="four-plus" name="no-of-owners" value="5"><div>4<sup>+</sup></div></label>
					</td>
				</tr>
				<tr>
					<td><label for="title">Add Title</label></td>
				</tr>
				<tr>
					<td><input type="text" name="title"  id="title">
					</td>
				</tr>
				<tr>
					<td><label for="description">Description</label></td>
				</tr>
				<tr>
					<td><input type="text" name="description"  id="description">
					</td>
				</tr>
				<tr>
					<td><label for="price">Set Price</label></td>
				</tr>
				<tr>
					<td><input type="text" name="price" id="price">
					</td>
				</tr>
				<tr>
					<td>
						<label>Images</label>
					</td>
				</tr>
				<tr>
					<td>
						<label for="image"><input type="file" name="image" id="image" accept="image/*"><img alt="upload" id="upload-image" src="images/upload-image.png" width="150" height="150"></label>
					</td>
				</tr>
				<tr>
					<th><label for="addProduct"><input type="submit" name="submit" value="POST" onclick="return validate.validateProductForm()"></label></th>
				</tr>
				<tr>
					<td id="error"><label id="err">&nbsp;</label></td>
				</tr>
			</table>
		</form>
	</div>
	</div>
