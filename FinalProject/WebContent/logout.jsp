<div class="form" id="logoutpage">
	<div class="form-container">
		<div class="close">
			<label for="close"><button onclick="formPopups.closeLogout()">X</button></label>
		</div>
		<form id="logoutform">
			<table align="center" id="logout" cellspacing="30">
				<tr>
					<th colspan="2"><label for="heading">Are you sure want to Logout ?</label></th>
				</tr>
				<tr>
					<th>
						<label for="cancel"><input type="button" value="cancel" id="cancel"></label>
						<a href="index.jsp?action=logout"><label for="logout"><input type="button" value="logout" id="logoutBtn"></label></a>
					</th>
				</tr>
			</table>
		</form>
	</div>

</div>