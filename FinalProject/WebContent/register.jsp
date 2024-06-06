
<%
String status="";

if(request.getParameter("status")!=null){
	if(request.getParameter("status").equals("exists")){
	status="email exist";
	}
}
%>


<div class="register" id="registerpage">
	<div class="form-container">
		<div class="close">
			<label for="close"><button onclick="formPopups.closeRegister()">X</button></label>
		</div>
		<form id="registerform" action="Controller" method="post">
			<table align="center" id="register">
			
				<tr>
					<th colspan="3"><label for="heading">Register</label></th>
				</tr>
				<tr><input type='hidden' value='register' name="action"></tr>
				<tr>
					<td><label for="name">Name</label></td>
					<td>
						<input type="text" name="firstname"
							placeholder="first name"  id="firstname">
						</td><td>
						<input type="text" name="lastname"
							placeholder="last name"  id="lastname">
					</td>
				</tr>
				<tr>
					<td></td>
					<td id="error"><label for="error" id="firstnameError">&nbsp;</label></td>
					<td id="error"><label for="error" id="lastnameError">&nbsp;</label></td>
				</tr>
				<tr>
					<td><label for="mobile">Mobile</label></td>
					<td><input type="tel" placeholder="mobile" 	name="mobile" id="mobile">
					</td>
					<td id="error">
						<label for="error" id="mobileError">&nbsp;</label>
					</td>
				</tr>
				<tr>
					<td><label for="mail">E-mail</label></td>
					<td colspan="2">
						<input type="email" placeholder="email address"  maxlength="100" name="mail" id="mail">
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2" id="error">
						<label for="error" id="mailError">&nbsp;</label>
					</td>
				</tr>
				<tr>
					<td><label for="password">Password</label></td>
					<td colspan="2">
						<input type="password" placeholder="password" name="new-password" id="new-password">
						<div id="passerror"><label for="error" id="new-passwordError">&nbsp;</label>
						</div>
					</td>
				</tr>
				<tr>
					<td><label for="confirm-password">Confirm&hyphen;password</label></td>
					<td colspan="2">
						<input type="password" placeholder="confirm-password" name="confirm-password" id="confirm-password">
						<div id="passerror"><label for="error" id="confirm-passwordError">&nbsp;</label></div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2" id="error"><label for="error" id="coursesError">&nbsp;</label></td>
				</tr>
				<tr>
					<td rowspan="5"><label for="address">Address  </label></td>
					<td>
						<select name="state" onclick="validate.validateOnselect(this)" onchange="validate.validateOnselect(this)" id="state">
							<option value="state" selected>-- state --
							<option value="Maharashtra">Maharashtra
							<option value="Karnataka">Karnataka
							<option value="Gujarat">Gujarat
						</select>
					</td>
					<td>
						<select name="district" onclick="validate.validateOnselect(this)" id="district" disabled>
							<option value="district" selected>-- district --
						</select>
						
					</td>
				</tr>
				<tr>
					<td id="error"><label for="error" id="stateError">&nbsp;</label></td>
					<td id="error"><label for="error" id="districtError">&nbsp;</label></td>
				</tr>
				<tr>
					<td>
						<select name="subdistrict" onclick="validate.validateOnselect(this)" id="subdistrict" disabled>
							<option value="subdistrict" selected>-- subdistrict --
						</select>
					</td>
					<td>
						<input type="text" placeholder="pincode" name="pin" id="pin">
					</td>
				</tr>
				<tr>
					<td id="error"><label for="error" id="subdistrictError">&nbsp;</label></td>
					<td id="error"><label for="error" id="pinError">&nbsp;</label></td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="village" placeholder="apartment/street/village"
							id="village">
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2" id="error"><label for="error" id="villageError"><i>&nbsp;</i></label></td>
				</tr>
				<tr>
					<th colspan="3"><label for="register"><input type="submit" name="submit" value="register" onclick="return validate.validateform()"></label></th>
				</tr>
				<tr>
					<td colspan="3" id="error"><label id="err">&nbsp;<%=status %></label></td>
				</tr>
			</table>
		</form>
	</div>

</div>