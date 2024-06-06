<div class="login" id="loginpage">
	<div class="form-container">
		<div class="close">
			<label for="close"><button onclick="formPopups.closeLogin()">X</button></label>
		</div>
		<form id="loginform" >
			<table align="center" id="login">
				<tr>
					<th colspan="2"><label for="heading">Login</label></th>
				</tr>
				<tr><input type='hidden' value='login' name="action"></tr>
				<tr>
					<td class="loginType">
						<label for="user"><input type="radio" id="user" name="loginType" value="user" checked>User</label>
						<label for="admin"><input type="radio" id="admin" name="loginType" value="admin">Admin</label>
					</td>
				</tr>
				<tr>
					<td><label for="username">Username</label></td>
					<td><input type="text" name="username" placeholder="email or username" id="username"></td>
				</tr>
				<tr>
					<td><label for="password">Password</label></td>
					<td><input type="password" placeholder="password" name="password" id="password"></td>
				</tr>
				<tr>
					<th colspan="2"><label for="login"><input type="button" value="login" id="loginBtn" onclick="validate.authenticate()"></label>
					</th>
				</tr>
				<tr>
					<td colspan="2" id="logerr"><label for="error" id="loginError">&nbsp;</label></td>
				</tr>
				<tr>
					<th colspan="2"><i>Don't have an Account ?</i> <label for="login">
						<br><input type="button" value="Register Here" onclick="formPopups.openRegister()"></label></th>
				</tr>
			</table>
		</form>
	</div>

</div>