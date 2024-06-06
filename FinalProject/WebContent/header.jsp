
<%
	
%>

<%!public String isLoggedIn(HttpServletRequest req, String s) {
		HttpSession session = req.getSession();
		if (session.getAttribute("username") == null) {
			return "formPopups.openLogin()";
		}
		if (s.equals("profile")) {
			return "\"formPopups.openDropDown()\"";
		}else if(s.equals("favourite")){
			return "\"validate.showFavourites("+session.getAttribute("customer_id")+")\"s";
		}
		else {
			return "\"\" href=\"sell.jsp\"";
		}
	}

	public String user(HttpServletRequest req) {
		HttpSession session = req.getSession();

		if (session.getAttribute("username") != null) {
			return session.getAttribute("username").toString();
		}
		return "";
	}%>



<header>
	<div class="logo">
		<a href="index.jsp"><img title="index.jsp" src="images/logo.png"
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
					<a onclick=<%=isLoggedIn(request, "profile")%> id="profile"
						title="login/signup" href="#"> <img id="prof" src="images/user.png"
						alt="user" />
					</a>
					<div class="dropdown" id="drop-profile">
						<div><%=user(request) %></div>
						<div>
							<a href="edit-profile.jsp"><div>Edit profile</div></a>
						</div>
						<div>
							<div onclick="formPopups.openLogout()">Log Out</div>
						</div>
					</div>
				</div>
				<div>
					<a onclick=<%=isLoggedIn(request, "favourite")%> title="favorites" href="#"> 
						<img src="images/unliked.png" alt="favorite" />
					</a>
				</div>
				<div>
					<a onclick=<%=isLoggedIn(request, "sell")%> title="sell" href="#">
						<img src="images/sell.png" alt="sell" />
					</a>
				</div>
			</div>
		</div>
		<div id="clear-both"></div>

	</div>
	<div id="clear-both"></div>
</nav>