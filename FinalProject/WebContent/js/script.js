let loginpage, registerpage,logoutpage;
let  state,dist,subdist, month, date, err, error,ID="";
let val = "", loginBtn,displaypage, logoutBtn, isLoggedIn = false,registeredName,passwordError=true,confirmPasswordError=true;
let District,subDistrict,State;

let username ="Shubham123",useremail="shubham@gmail.com", password="Shubham@123",user_name="Shubham Patil";

let addresses={
	"Maharashtra":{
		"Pune":["Baramati","Bhor","Haveli"],
		"Kolhapur":["Karveer","Kagal","Chandgad","Ajara"],
		"Satara":["Wai","Karad","Phaltan"]
	},
	"Karnataka":{
		"Belagavi":["Khanapur",	"Hukkeri","Belagavi"],
		"Bengaluru":["Anekal","Yelhanka"],
		"Mysore":["Mysore"]
	},
	"Gujarat":{
		"Kutch":["Bhuj","Gandhidham","Lakhapat"],
		"Saurashtra":["Jamnagar","Morbi","Rajkot"],
		"Central Gujarat":["Vadodara","Kheda","Dahod"]
	}
};
let user={
	fullname:"",
	mobile :"",
	mail:   "",
	address :  "",
	subdistrict : "",
	district : "",
	state : "",
	pin: ""
}

window.onload = function () {
	
	registeredName=document.getElementById("registered-name");
	loginpage = document.getElementById("loginpage");
	registerpage = document.getElementById("registerpage");
	logoutpage=document.getElementById("logoutpage");
	displaypage=document.getElementById("dataDisplaypage");
	err = document.getElementById("err");
	error=err;
	loginform = document.getElementById("loginform");
	registerform = document.getElementById("registerform");
	//loginBtn = document.getElementById("loginBtn");
	logoutBtn = document.getElementById("logoutBtn");
	//if(loginBtn && logoutBtn){
		/*loginBtn.addEventListener("click", function () {
			let userInputName = document.getElementById("username").value;
			let userInputPassword = document.getElementById("password").value;
			let loginError=document.getElementById("loginError");
			if(userInputName==""){
				loginError.innerHTML="Enter username";
			}
			else if(userInputPassword==""){
				loginError.innerHTML="Enter Password";
			}
			else if ((username == userInputName || userInputName == useremail) && password == userInputPassword) {
				loginError.innerHTML="&nbsp;";
				formPopups.login();
				alert("Login Successfully");
				formPopups.closeLogin();
			}
			else if (username != userInputName && userInputName == useremail && password != userInputPassword) {
				loginError.innerHTML="Invalid username and password...";
			}
			else if(username != userInputName || userInputName == useremail){
				loginError.innerHTML="username doesn't exist ...";
			}
			else{
				loginError.innerHTML="Incorrect password !!!";
			}
		});*/
	
		/*logoutBtn.addEventListener("click",function(){
			formPopups.logout();
			formPopups.closeLogout();
		});*/
	//}
}


window.addEventListener("click", function (event) {
	if (event.target.id == loginpage.id) {
		formPopups.closeLogin();
		formPopups.resetForm();
	}
	else if(event.target.id!="drop-location"){
		$("#drop-location").html("");
	}
	else if (event.target.id == registerpage.id) {
		formPopups.closeRegister();
		formPopups.resetForm();
	}
	else if(event.target.id == logoutpage.id || event.target.id=="cancel"){
		formPopups.closeLogout();
		formPopups.resetForm();
	}
});

let formPopups = new Forms();

function Forms() {

	this.closeLogin = closeLogin;
	this.closeRegister = closeRegister;
	this.openLogin = openLogin;
	this.openRegister = openRegister;
	this.openLogout=openLogout;
	this.closeLogout=closeLogout;
	this.resetForm = resetForm;
	this.submitForm=submitForm;
	this.closeDisplay=closeDisplay;
	this.login=login;
	this.logout=logout;
	this.openDropDown=openDropDown;

	function submitForm(){
		registerpage.style.display="none";
		displaypage.style.display="block";
	}
	 function closeDisplay(){
		displaypage.style.display="none";
		login();
	 }

	function closeLogin() {
		loginpage.style.display = "none";
		resetForm();
	}
	
	function openDropDown(){
		let dropDown= $("#drop-profile");
		dropDown.toggle();
	}

	function login(){
		isLoggedIn = true;
		let profile = document.getElementById("profile");
		profile.title = "Logged in as '@"+username+"'";
		let registerBtn = document.getElementById("register-btn");
		registerBtn.title = user_name;
		registerBtn.innerHTML = "Profile";
		let user=document.getElementById("user");
		user.innerText="@"+username;
	}
	function logout(){
		isLoggedIn = false;
		let profile = document.getElementById("profile");
		profile.title = "login/signup";
		let registerBtn = document.getElementById("register-btn");
		registerBtn.title = "register";
		registerBtn.innerHTML = "Register";
		let user=document.getElementById("user");
		user.innerText="";
		resetForm();
	}

	function openLogin() {
		if (isLoggedIn) {
			openDropDown();
		}
		else {
			loginpage.style.display = "block";
		}

	}

	function openRegister() {
		if (isLoggedIn) {
			document.getElementById("profile").style.display="block";
			//openLogout();
		}
		else{
			resetForm();
			loginpage.style.display = "none";
			registerpage.style.display = "block";
		}

	}

	function closeRegister() {
		resetForm();
		registerpage.style.display = "none";
		
	}

	function closeLogout(){
		logoutpage.style.display="none";
	}

	function openLogout(){
		logoutpage.style.display="block";
	}


	function resetForm() {
		registerform.reset();
		loginform.reset();
		err.innerHTML = "&nbsp;";
		let errors=document.querySelectorAll("label[for=error]");
		errors.forEach(e=>{
			e.innerHTML="&nbsp;";
		});
		document.getElementById("district").disabled=true;
		document.getElementById("subdistrict").disabled=true;
		val = "";
	}
}





//														Validations


let validate = new Validate();

/*window.addEventListener("submit", function (event) {
	if(!validate.validateform()){
		 event.preventDefault();
	}else{
		alert("Registration Successfull");
		//formPopups.resetForm();
		for(let label in user){
			this.document.getElementById("registered-"+label).innerText=user[label];
		}
	}
	//formPopups.submitForm();
});*/


window.addEventListener("input", function (event) {
	let id = event.target.id;
	if (event.target.closest(".register") || event.target.closest(".add-product")) {
		validate.validateOninput(id,event);
	}
});

function Validate() {

	this.validateform = validateform;
	this.validateOninput = validateOninput;
	this.validateOnselect = validateOnselect;
	this.authenticate=authenticate;
	this.getBrands=getBrands;
	this.getLocations=getLocations;
	this.selectedLoc=selectedLoc;
	this.addToFavourite=addToFavourite;
	this.selectedCategory=selectedCategory;
	this.showFavourites=showFavourites;
	this.validateEditform=validateEditform;
	this.getAllCategories=getAllCategories;
	this.getAllUsers=getAllUsers;
	this.getAllProducts=getAllProducts;
	this.validateProductForm=validateProductForm;
	function authenticate() {		
		let userName=document.getElementById("username").value;
		let password=document.getElementById("password").value;
		let loginType=$("input[name=loginType]:checked").val();
		/*console.log(userName+ " "+password);*/
        $.ajax
        ({
            type: "POST",
            url: "Controller",
            data: {"action":"login","username": userName , "password" :  password,"loginType":loginType},
            error:function(){
            	alert("  Error");
            },
            success: function (data) {
            	//alert("  authenticated using ajax..");
            	
            	console.log(data);
            	let info=JSON.parse(data);
            	/*formPopups.closeLogin();
            	window.location.href=info.url+".jsp?"+loginType+"="+info.user;*/
            	$("#loginError").css("color","red");
            	if(info.status=="success"){
            		$("#loginError").css("color","green");
            		$("#loginError").text("Login Successfully ....");
            		setTimeout(function(){
            			$("#loginError").text("Redirecting....");
            		},1000);
            		
            		setTimeout(function(){
            			if(loginType=="admin"){
            				window.open(info.url+".jsp");
            			}
            			else{
            				window.location.href=info.url+".jsp?"+loginType+"="+info.user;
            			}
            			
            			formPopups.closeLogin();
            		},3000);
            		
            		
            	}
            	else if(info.status=="username"){
            		$("#loginError").text("Invalid username..!!!");
            	}
            	else if(info.status=="password"){
            		$("#loginError").text("Wrong password..!!!");
            	}
            	else{
            		$("#loginError").text("Something went wrong..!!!");
            	}
            }
        });
    }
	
	function validateProductForm(productCategory){
		let isValid = false;
		
		let title = document.getElementById("title").value;
		let description=document.getElementById("description").value;
		let price=document.getElementById("price").value;
		let brand = document.getElementById("brand");
		let model= document.getElementById("model");
		let year = document.getElementById("year").value;
		
		let no_of_owners=$("input[name=no-of-owners]:checked").val();
		
		let km="NA";
		let fuel="NA";
		let transmission="NA";
		
		if(productCategory=="Motor"){
			km = document.getElementById("km").value;
		}
		else if(productCategory=="Car"){
			km = document.getElementById("km").value;
			fuel=$("input[name=fuel]:checked").val();
			transmission=$("input[name=transmission]:checked").val();
		}
		
		
		err.innerHTML="&nbsp;";


		if(brand.selectedIndex==0){
			err.innerHTML = "please select brand";
		}
		else if(model.selectedIndex==0){
			err.innerHTML = "please select model";
		}
		else if (year == "") {
			err.innerHTML = "please enter year";
		}
		else if(km==""){
			err.innerHTML = "please enter km";
		}
		else if (no_of_owners == undefined) {
			err.innerHTML = "please select no_of_owners";
		}
		else if (title == "") {
			err.innerHTML = "please enter title";
		}
		else if(description==""){
			err.innerHTML = "please enter description";
		}
		else if(price==""){
			err.innerHTML = "please enter price";
		}
		else if (year.match("[0-9]{5,}") || year>2023) {
			element.value = element.value.substring(0,4);
			err.innerHTML = "enter valid year";
		}
		else if (price.match("[0-9]{9,}")) {
			element.value = element.value.substring(0,8);
			err.innerHTML = "Price is Too Much";
		}
		else if (fuel=="") {
			err.innerHTML = "please select fuel";
		}
		else if(transmission==""){
				err.innerHTML = "please select transmission";
		}
		else {
			
			err.innerHTML = "&nbsp;";
			isValid=true;
		}
		return isValid;
	}
	}
	
	
	function showFavourites(id){
		let user_id=id;
		$.ajax({
			type:"POST",
			url:"Controller",
			data: {"action":"getCustomerFavourites","user_id":user_id},
			success:function(data){
				//alert(data+"  Success");
				//alert(data+" success");
				window.location.href="favourites.jsp?favourites";
			},
			error:function(){
				alert("  Error");
			}
		});
	}
	
	function getBrands(type){
		if(type=="Car" || type=="Motor"){
			$(".all").css("display","block");
			$(".all").css("display","none");
		}else{
			$(".motor").css("display","none");
			$(".mobile").css("display","block");
		}
		
		$.ajax
        ({
            type: "POST",
            //the url where you want to sent the userName and password to
            url: "Controller",
            //json object to sent to the authentication url
            data: {"action":"getBrands","type":type},
            error:function(){
            	alert("  Error");
            },
            success: function (data) {
                //do any process for successful authentication here
            	
            	window.location.href="addproduct.jsp?category="+type;
            }
        });
	}
	
	function validateEditform() {
		let isValid = false;
		let firstname = document.getElementById("firstname").value;
		let lastname = document.getElementById("lastname").value;
		let mobile = document.getElementById("mobile").value;
		let mail=document.getElementById("mail").value;
		err.innerHTML="&nbsp;";


		if (firstname == "") {
			err.innerHTML = "please enter firstname";
		}
		else if(lastname==""){
			err.innerHTML = "please enter lastname";
		}
		else if (mobile == "") {
			err.innerHTML = "please enter mobile";
		}
		else if(mail==""){
			err.innerHTML = "please enter email";
		}
		else if(!mail.match(/^[a-z][a-z0-9.]+@[a-z][a-z0-9]+\.[a-z]*[a-z]$/)){
			err.innerHTML = "please check email";
		}
		else if (user.mobile.length < 10) {
			return;
		}
		else {
			error.innerHTML = "&nbsp;";
			err.innerHTML = "&nbsp;";
			alert("Registration Successfull");
			setTimeout(function(){
				formPopups.resetForm();
			},1000);
			isValid = true;
		}
		return isValid;
	}
	

	function validateform() {
		let isValid = false;
		firstname = document.getElementById("firstname").value;
		lastname = document.getElementById("lastname").value;
		user.mobile = document.getElementById("mobile").value;
		user.mail=document.getElementById("mail").value;
		pass=document.getElementById("new-password").value;
		confirmpass=document.getElementById("confirm-password").value;
		user.address = document.getElementById("village").value;
		subDistrict = document.getElementById("subdistrict");
		District = document.getElementById("district");
		State = document.getElementById("state");
		user.pin=document.getElementById("pin").value;
		err.innerHTML="&nbsp;";


		if (firstname == "") {
			err.innerHTML = "please enter firstname";
		}
		else if(lastname==""){
			err.innerHTML = "please enter lastname";
		}
		else if (user.mobile == "") {
			err.innerHTML = "please enter mobile";
		}
		else if(user.mail==""){
			err.innerHTML = "please enter email";
		}
		else if(!user.mail.match(/^[a-z][a-z0-9.]+@[a-z][a-z0-9]+\.[a-z]*[a-z]$/)){
			err.innerHTML = "please check email";
		}
		else if(pass==""){
			err.innerHTML = "please enter password";
		}
		else if(confirmpass==""){
			err.innerHTML = "please enter confirm password";
		}
		else if(passwordError || confirmPasswordError){
			err.innerHTML = "check your password";
		}
		else if(State.selectedIndex==0){
			err.innerHTML = "please select state";
		}
		else if(District.selectedIndex==0){
			err.innerHTML = "please select district";
		}
		else if (subDistrict.selectedIndex == 0) {
			err.innerHTML = "please select subdistrict";
		}
		else if(user.pin==""){
			err.innerHTML = "please enter pincode";
		}
		else if (user.address == "" || user.address.length < 3) {
			err.innerHTML = "please enter village";
		}
		else if (user.mobile.length < 10) {
			return;
		}
		else {
			error.innerHTML = "&nbsp;";
			err.innerHTML = "&nbsp;";
			user.fullname=firstname+" "+lastname;
			username=firstname;
			password=pass;
			user_name=user.fullname;
			user.district=District.value;
			user.subdistrict=subDistrict.value;
			user.state=State.value;
			useremail=user.mail;
			
			$.ajax({
				url:"Controller",
				type:"POST",
				data:{"action":"isEmailExists","email":usermail},
				success:function(data){
					if(data=="success"){
						alert("Registration Successfull");
						isValid = true;
						setTimeout(function(){
							formPopups.resetForm();
						},1000);
						registerpage.style.display = "none";
						
					}
					else{
						alert("Email Already Exists..");
					}
				},
				error:function(){
					alert("Some Error..");
				}
			});
			
			
			//formPopups.resetForm();
			
			
		}
		return isValid;
	}

	function getLocations(){
		let location=document.getElementById("search-location").value;
		$.ajax({
			type:"POST",
			url:"Controller",
			data: {"action":"getLocations","location":location},
			success:function(data){
				//alert(data+"  Success");
				let locs="";
				let loactions=[];
				data=data.trim();
				loactions=data.split(",");
				loactions.forEach(loc => {
					locs+="<div onclick='validate.selectedLoc(this)'>"+loc+"</div>";
            	});
				$("#drop-location").html(locs);
			},
			error:function(){
				alert("  Error");
			}
		});
	}
	
	function selectedLoc(elt){
		let location=elt.innerText;
		$.ajax({
			type:"POST",
			url:"Controller",
			data: {"action":"getProductByLocation","location":location},
			success:function(data){
				//alert(data+"  Success");
				//alert(data+" success");
				window.location.href="index.jsp?location="+location;
			},
			error:function(){
				alert("  Error");
			}
		});
	}
	
	function selectedCategory(elt){
		let category=elt.value;
		$.ajax({
			type:"POST",
			url:"Controller",
			data: {"action":"getProductByCategory","category":category},
			success:function(data){
				//alert(data+"  Success");
				//alert(data+" success");
				window.location.href="index.jsp?category="+category;
			},
			error:function(){
				alert("  Error");
			}
		});
	}
	
	function addToFavourite(product_id,isLogged){
		if(isLogged==null){
			formPopups.openLogin();
		}
		else{
			$.ajax({
				type:"POST",
				url:"Controller",
				data: {"action":"addToFav","product_id":product_id},
				success:function(data){
					//alert(data+"  Success");
					if(data=="liked"){
						$(".favourite"+product_id).attr('src','images/liked.png');
					}else if(data=="unliked"){
						$(".favourite"+product_id).attr('src','images/unliked.png');
					}
				},
				error:function(){
					alert("  Error");
				}
			});
		}
		
	}


	function validateOnselect(elt) {
		let category=elt.name;
		let brand=elt.value;
		let action="";
		if(category=="brand"){
			action="getModels";
			$.ajax
	        ({
	            type: "POST",
	            //the url where you want to sent the userName and password to
	            url: "Controller",
	            //json object to sent to the authentication url
	            data: {"action":action,"brand":brand},
	            error:function(){
	            	alert("  Error");
	            },
	            success: function (data) {
	                //do any process for successful authentication here
	            	let option="<option value='' selected>" ;
	            	if(data==""){
	            		$(".models").css("display","none");
	            		return;
	            	}
	            	let models=[];
	            	models=data.split(",");
	            	models.forEach(m => {
	            		option+="<option value='"+m+"' > "+m;
	            	});
	            	$("#model").html(option);
	            	$(".models").css("display","block");
	            }
	        });
		}
		else{
			if (elt.closest(".register")) {
				console.log("inside closest");
				let error = document.getElementById(elt.name + "Error"),district,subdistrict;
				district=document.getElementById("district");
				subdistrict=document.getElementById("subdistrict");
				if (elt.selectedIndex == 0) {
					if(elt.id=="state"){
						subdistrict.innerHTML='<option value="subdistrict" selected>-- subdistrict --';	
						district.innerHTML=	'<option value="district" selected>-- district --';
					}
					if(elt.id=="district"){
						subdistrict.innerHTML=	'<option value="subdistrict" selected>-- subdistrict --';
					}
					error.innerHTML = "select "+elt.name;
				}
				else {
					if(elt.id=="state"){
						subdistrict.innerHTML='<option value="subdistrict" selected>-- subdistrict --';	
						let options='<option value="district" selected>-- district --';
						state=elt.value;
						for(let Dist in addresses[state]){
							options+='<option value="'+Dist+'">'+Dist;
						}
						district.innerHTML=options;
						district.disabled=false;
					}
					else if(elt.id=="district"){
						let options='<option value="subdistrict" selected>-- subdistrict --';
						dist=elt.value;
						for(let Subdist of addresses[state][dist]){
							options+='<option value="'+Subdist+'">'+Subdist;
						}
						subdistrict.innerHTML=options;
						subdistrict.disabled=false;
					}
					else if(elt.id=="subdistrict"){
						let pincode=document.getElementById("pin");
						pincode.value="";
					}
					error.innerHTML = "&nbsp;";
					err.innerHTML = "&nbsp;";
				}
				
				
			}
		}
		
		
	}
	
	
	function getAllUsers(){
		$.ajax({
			type:"POST",
			url:"Controller",
			data: {"action":"getAllUsers"},
			success:function(data){
				//alert(data+"  Success");
				//alert(data+" success");
				window.location.href="show-users.jsp?Users";
			},
			error:function(){
				alert("  Error");
			}
		});
	}
	
	function getAllProducts(){
		$.ajax({
			type:"POST",
			url:"Controller",
			data: {"action":"getAllProducts"},
			success:function(data){
				//alert(data+"  Success");
				//alert(data+" success");
				window.location.href="show-products.jsp?Products";
			},
			error:function(){
				alert("  Error");
			}
		});
	}
	
	function getAllCategories(){
		$.ajax({
			type:"POST",
			url:"Controller",
			data: {"action":"getAllCategories"},
			success:function(data){
				//alert(data+"  Success");
				//alert(data+" success");
				window.location.href="show-categories.jsp?Category";
			},
			error:function(){
				alert("  Error");
			}
		});
	}



	function validateOninput(id,event) {
		if(id!=ID){
			val="";
		}
		let element = document.getElementById(id);
		let error = document.getElementById(element.name + "Error");
		element.addEventListener("blur", function (event) {
			if(id == "firstname" || id == "lastname"){
				if(element.value.length<2){
					element.focus();
					error.innerHTML="too short";
				}
				else{
					val = "";
					error.innerHTML="&nbsp;"
				}
			}
			else if(id=="mobile"){
				if(element.value.length<10){
					element.focus();
					error.innerHTML="enter valid "+id;
				}
				else{
					val = "";
					error.innerHTML="&nbsp;"
				}
			}
			else if(id=="pin"){
				if(element.value.length<6){
					element.focus();
					error.innerHTML="should contain 6 digits"
				}
				else{
					val = "";
					error.innerHTML="&nbsp;"
				}
			}
			else if(id=="village"){
				if(element.value.length<3){
					element.focus();
					error.innerHTML="should contain atleast 3 characters";
				}
			}
		});

		if (element.value == "") {
			element.focus();
			error.innerHTML="field required";
		}
		if (id == "firstname" || id == "lastname") {
			if (element.value.match("[^a-zA-Z]")) {
				element.value = element.value.substring(0, element.value.length - 1);
				error.innerHTML = "alphabets only";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}
			else if(element.value.match("[a-zA-z]{16,}")){
				element.value = element.value.substring(0, element.value.length - 1);
				error.innerHTML = "15 characters only";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}
			else {
				error.innerHTML = "&nbsp;";
				err.innerHTML = "&nbsp;";
			}

			if (element.value.match("[^a-zA-Z]")) {
				element.value = val;
			}
		}
		else if (id == "mobile") {
			if (element.value.match("[^0-9]")) {
				element.value = element.value.substring(0, element.value.length - 1);
				error.innerHTML = "numbers only";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}
			else if(element.value.match("^[^6-9]")){
				element.value = element.value.substring(0, element.value.length - 1);
				error.innerHTML = "should starts with [6-9]";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}
			else if(element.value.length>10){
				element.value = element.value.substring(0,10);
				error.innerHTML = "10 digits only";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}
			else {
				error.innerHTML="&nbsp;";
				err.innerHTML = "&nbsp;";
			}

			if (element.value.match("[^0-9]")) {
				element.value = val;
			}
		}
		else if(id=="mail"){
			if(event.data===" "){
				element.value = element.value.trim();
				element.value+="#";
				error.innerHTML="invalid character";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}
			if(element.value.match(/[^a-z0-9.@]|.*@.*@|^[^a-z]|\.{2,}|\.@|@\.|@.+\..*[0-9]/)){
				element.value = element.value.substring(0, element.value.length - 1);
				error.innerHTML="invalid character";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}else if(element.value.match(/.{29,}/)){
				element.value = element.value.substring(0, 30);
				error.innerHTML="30 characters only";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}
			else if(element.value.match(/@$|\.$/)){
				error.innerHTML="should not end with @ or .";
			}
			else{
				error.innerHTML="&nbsp;"
				err.innerHTML = "&nbsp;";
			}
			
			if(element.value.match(/[^a-z0-9.@]|.*@.*@|^[^a-z]|\.{2,}|\.@|@\./)){
				element.value=val;
			}
		}
		else if(id=="new-password"){
			if(event.data===" "){
				element.value = element.value.trim();
				error.innerHTML="whitespace not allowed";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}
			
			if(!(element.value.match(".*[^a-zA-Z0-9].*") && element.value.match(".*[A-Z].*") && element.value.match(".*[0-9].*"))){
				error.innerHTML="should contain atleast uppercase letter,a number and special character";
				if(element.value.length>15){
					element.value = element.value.substring(0, 15);
				}
				passwordError=true;
			}
			else if(!element.value.match(".{8,15}")){
				error.innerHTML="should contain (8-15) characters";
				passwordError=true;
			}
			else{
				passwordError=false;
				password=element.value;
				error.innerHTML="&nbsp;"
				err.innerHTML = "&nbsp;";
			}

			if(element.value.length>15){
				element.value=element.value.substring(0, 15);
			}
		}
		else if(id=="confirm-password"){
			if(element.value.length>15){
				element.value = element.value.substring(0, 15);
				error.innerHTML="should contain (8-15) characters";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
				if(password!=element.value){
					confirmPasswordError=true;
				}
			}
			else if(element.value!=password){
				error.innerHTML="password doesn't match";
				confirmPasswordError=true;
			}
			else{
				confirmPasswordError=false;
				error.innerHTML="&nbsp;"
				err.innerHTML = "&nbsp;";
			}
		}
		else if (id == "village") {
			if (element.value.length < 3) {
				error.innerHTML="enter (3-50) characters";
			}
			else if (element.value.length > 50) {
				element.value = element.value.substring(0, 50);
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}
			else {
				error.innerHTML="&nbsp;"
				err.innerHTML = "&nbsp;";
			}
		}
		else if(id=="pin"){
			if (element.value.match("[^0-9]")) {
				element.value = element.value.substring(0, element.value.length - 1);
				error.innerHTML="numbers only";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}
			if (element.value.match("[0-9]{7,}")) {
				element.value = element.value.substring(0,6);
				error.innerHTML="should be 6 digit";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}
			else if(element.value.match("^[0]")){
				element.value = element.value.substring(0, element.value.length - 1);
				error.innerHTML="can't start with 0";
				setTimeout(function(){
					error.innerHTML="&nbsp;";
				},1000);
			}
			else {
				error.innerHTML="&nbsp;"
				err.innerHTML = "&nbsp;";
			}
			if (element.value.match("[^0-9]")) {
				element.value=val;
			}

		}
		else if(id=="year"){
			if (element.value.match("[^0-9]")) {
				element.value = element.value.substring(0, element.value.length - 1);
			}
			if (element.value.match("[0-9]{5,}")) {
				element.value = element.value.substring(0,4);
			}
			else {
				err.innerHTML = "&nbsp;";
			}
			if (element.value.match("[^0-9]")) {
				element.value=val;
			}

		}
		else if(id=="price"){
			if (element.value.match("[^0-9]")) {
				element.value = element.value.substring(0, element.value.length - 1);
			}
			else if (element.value.match("[0-9]{9,}")) {
				element.value = element.value.substring(0,8);
			}
			else {
				err.innerHTML = "&nbsp;";
			}
			if (element.value.match("[^0-9]")) {
				element.value=val;
			}

		}
		else if(id=="km"){
			if (element.value.match("[^0-9]")) {
				element.value = element.value.substring(0, element.value.length - 1);
			}
			else if (element.value.match("[0-9]{7,}")) {
				element.value = element.value.substring(0,6);
			}
			else {
				err.innerHTML = "&nbsp;";
			}
			if (element.value.match("[^0-9]")) {
				element.value=val;
			}

		}
			val = element.value;
			ID=id;
		
	}
