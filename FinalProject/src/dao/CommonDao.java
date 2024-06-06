package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.registry.infomodel.User;

import utility.DBConnection;
import bean.Category;
import bean.Favourite;
import bean.ProductBean;
import bean.UserBean;

public class CommonDao {
	public static int id=0;
	
	public static UserBean checkLogin(String email,String password) throws ClassNotFoundException, SQLException {
		Connection connection=null;
		try{
		ResultSet rs;
		connection=DBConnection.getConnection();
		Statement stmt=connection.createStatement();
		int customer_id=0;
		rs=stmt.executeQuery("select email,pass,customer_id from Customer where email='"+email+"'");
		if (rs.next()) {
			if(rs.getString(1).equals(email) && rs.getString(2).equals(password)){
				customer_id=rs.getInt(3);
				rs=stmt.executeQuery("select * from Customer where customer_id="+customer_id);
				
				UserBean userBean=new UserBean();
				if(rs.next()){
					userBean.setId(customer_id);
					userBean.setFirstname(rs.getString(2));
					userBean.setLastname(rs.getString(3));
					userBean.setMobile(rs.getLong(4));
					userBean.setEmail(rs.getString(5));
					userBean.setState(rs.getString(7));
					userBean.setDistrict(rs.getString(8));
					userBean.setSubdistrict(rs.getString(9));
					userBean.setCity(rs.getString(11));
					userBean.setPin(rs.getInt(10));
					return userBean;
				}
			}
		}
		}finally{
			connection.close();
		}
		return null;
	}
	
	
	
	
	public static Map<String,Object> checkUserLoginNew(String email,String password) throws ClassNotFoundException, SQLException {
		Connection connection=null;
		Map<String, Object> userData=new HashMap<String, Object>();
		try{
		ResultSet rs;
		connection=DBConnection.getConnection();
		Statement stmt=connection.createStatement();
		
		userData.put("user",null);
		userData.put("favourites", null);
		userData.put("status","error");
		int customer_id=0;
		String status="Something went wrong..!!!";
		rs=stmt.executeQuery("select email,pass,customer_id from Customer where email='"+email+"'");
		if (rs.next()) {
				if( rs.getString(2).equals(password)){
				
				
				customer_id=rs.getInt(3);
				rs=stmt.executeQuery("select * from Customer where customer_id="+customer_id);
				
				UserBean userBean=new UserBean();
				if(rs.next()){
					userBean.setId(customer_id);
					userBean.setFirstname(rs.getString(2));
					userBean.setLastname(rs.getString(3));
					userBean.setMobile(rs.getLong(4));
					userBean.setEmail(rs.getString(5));
					userBean.setState(rs.getString(7));
					userBean.setDistrict(rs.getString(8));
					userBean.setSubdistrict(rs.getString(9));
					userBean.setCity(rs.getString(11));
					userBean.setPin(rs.getInt(10));
					
				}
				List<Favourite> favourites=new ArrayList<Favourite>();
				rs=stmt.executeQuery("select * from Favourite where Favourite.customer_id="+customer_id);
				while (rs.next()) {
					Favourite favourite=new Favourite();
					favourite.setFav_id(rs.getInt(1));
					favourite.setCustomer_id(rs.getInt(2));
					favourite.setProduct_id(rs.getInt(3));
					favourite.setIsActive(rs.getString(4).charAt(0));
					favourites.add(favourite);
				}
				
				userData.put("user",userBean);
				userData.put("favourites",favourites);
				userData.put("status","username");
				
				}
				else{
					userData.put("status","password");
				}
			
		}
		else{
			userData.put("status","username");
		}
		}finally{
			connection.close();
		}
		return userData;
	}
	
	
	
	
	public static List<Object> checkUserLogin(String email,String password) throws ClassNotFoundException, SQLException {
		List<Object> userData=new ArrayList<Object>();
		Connection connection=null;
		try{
		ResultSet rs;
		connection=DBConnection.getConnection();
		Statement stmt=connection.createStatement();
		
		int customer_id=0;
		String status="Something went wrong..!!!";
		rs=stmt.executeQuery("select email,pass,customer_id from Customer where email='"+email+"'");
		if (rs.next()) {
			if(rs.getString(1).equals(email)){
				if( rs.getString(2).equals(password)){
				
				
				customer_id=rs.getInt(3);
				rs=stmt.executeQuery("select * from Customer where customer_id="+customer_id);
				
				UserBean userBean=new UserBean();
				if(rs.next()){
					userBean.setId(customer_id);
					userBean.setFirstname(rs.getString(2));
					userBean.setLastname(rs.getString(3));
					userBean.setMobile(rs.getLong(4));
					userBean.setEmail(rs.getString(5));
					userBean.setState(rs.getString(7));
					userBean.setDistrict(rs.getString(8));
					userBean.setSubdistrict(rs.getString(9));
					userBean.setCity(rs.getString(11));
					userBean.setPin(rs.getInt(10));
					
				}
				List<Favourite> favourites=new ArrayList<Favourite>();
				rs=stmt.executeQuery("select * from Favourite where Favourite.customer_id="+customer_id);
				while (rs.next()) {
					Favourite favourite=new Favourite();
					favourite.setFav_id(rs.getInt(1));
					favourite.setCustomer_id(rs.getInt(2));
					favourite.setProduct_id(rs.getInt(3));
					favourite.setIsActive(rs.getString(4).charAt(0));
					favourites.add(favourite);
				}
				
				userData.add(0,userBean);
				userData.add(1,favourites);
				status="success";
				
				}
				else{
					userData.add(0,null);
					userData.add(1,null);
					status="password";
				}
			}
			else{
				status="username";
			}
			userData.add(0,null);
			userData.add(1,null);
			userData.add(2,status );
		}
		else{
			userData.add(0,null);
			userData.add(1,null);
			userData.add(2,"error");
		}
		}finally{
			connection.close();
		}
		return userData;
	}
	
	
	
	public static Map<String,String> checkAdminLogin(String email,String password) throws ClassNotFoundException, SQLException {
		Connection connection=null;
		Map<String, String> admin=new HashMap<String, String>();
		try{
			ResultSet rs;
		
		connection=DBConnection.getConnection();
		Statement stmt=connection.createStatement();
		
		admin.put("adminId", null);
		admin.put("status","error");
		
		String adminName="Admin";
		int admin_id=0;
		String status="error";
		rs=stmt.executeQuery("select email,pass,admin_id from Admin where email='"+email+"'");
		if (rs.next()) {
			
			if(rs.getString(2).equals(password)){
				admin_id=rs.getInt(3);
				rs=stmt.executeQuery("select * from Admin where admin_id="+admin_id);
				if(rs.next()){
					adminName=rs.getString("admin_name");
					status="success";
				}
			}
			else{
				status="password";
			}
			
		}
		else{
			status="username";
		}
		admin.put("adminName",adminName);
		admin.put("adminId",admin_id+"");
		admin.put("status",status);
		}finally{
			connection.close();
		}
		return admin;
	}
	
	public static String checkEmail(String mail) throws ClassNotFoundException, SQLException {
		String status="success";
		Connection connection=null;
		System.out.println("success");
		try{
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select count(*) from Customer where email='"+mail+"'");
			System.out.println("after query");
			
			int count=0;
			if(rs.next()){
				count=rs.getInt(1);
				if(count>0){
					System.out.println("exists");
					status="exists";
				}
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			connection.close();
		}
		System.out.println("success");
		return status;
	}
	
	public static int save(UserBean u) throws ClassNotFoundException, SQLException {
		int userId=0;
		Connection connection=null;
		try{
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select count(*) from Customer where email='"+u.getEmail()+"'");
			
			int count=0;
			if(rs.next()){
				count=rs.getInt(1);
				if(count>0){
					return -1;
				}
			}
			int status=stmt.executeUpdate("insert into Customer(firstname,lastname,mobile,email,pass,state,district,subdistrict,pincode,city,isActive,created_by,created_date,modified_by,modified_date) values('"+u.getFirstname()+"','"+u.getLastname()+"',"+u.getMobile()+",'"+u.getEmail()+"','"+u.getPass()+"','"+u.getState()+"','"+u.getDistrict()+"','"+u.getSubdistrict()+"',"+u.getPin()+",'"+u.getCity()+"','N',0,CURRENT_DATE,null,null)");
			if(status==1){
				rs=stmt.executeQuery("select max(customer_id) from Customer");
				if(rs.next()){
					userId= rs.getInt(1);
				}
			}
		}catch(SQLException e){
			userId=0;
			System.out.println(e);
		}finally{
			connection.close();
		}
		return userId;
	}
	
	public static int update(UserBean u) throws ClassNotFoundException, SQLException {
		int status=0;
		Connection connection=null;
		try{
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
		
			status=stmt.executeUpdate("update Customer set firstname='"+u.getFirstname()+"',lastname='"+u.getLastname()+"',mobile="+u.getMobile()+",email='"+u.getEmail()+"',modified_date=CURRENT_DATE,modified_by=customer_id where customer_id="+u.getId());

		}catch(SQLException e){
			System.out.println(e);
		}finally{
			connection.close();
		}
		return status;
	}
	
	public static int save(ProductBean p) throws ClassNotFoundException, SQLException {
		int status=0;
		Connection connection=null;
		try{
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			int category_id=0;
			ResultSet rs=stmt.executeQuery("select category_id from Category where category_name='"+p.getCategory_name()+"'");
			if(rs.next()){
				category_id=rs.getInt(1);
			}
			
			if(category_id>0){
				status=stmt.executeUpdate("insert into Product(title,description,category_id,category_details ,price ,aprove_request,isActive,created_by,created_date) values('"+p.getTitle()+"','"+p.getDescription()+"',"+category_id+",'"+p.getDetails()+"',"+p.getPrice()+","+p.isResquestStatus()+",'N',"+p.getLoggedUser()+",CURRENT_DATE)");
			}
			
		}catch(SQLException e){
			status=0;
			System.out.println(e);
		}
		finally{
			connection.close();
		}
		return status;
	}
	
	
	public static String getBrandsFromDB(String type) throws ClassNotFoundException, SQLException {
		String result="";
		Connection connection=null;
		try{
			ResultSet rs;
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			
			rs=stmt.executeQuery("select Brand.brand_name from Brand join Category on Category.category_id=Brand.category_id where Category.category_name='"+type+"'");
			while(rs.next()) {
				result+=rs.getString(1)+",";
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		finally{
			connection.close();
		}
		return result;
	}
	
	public static String getLocationsFromDB(String location) throws ClassNotFoundException, SQLException {
		String result="";
		Connection connection=null;
		try{
			ResultSet rs;
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			
			rs=stmt.executeQuery("(select city as location from Customer where city like '%"+location+"%') union (select state as location from Customer where state like '%"+location+"%') union (select district as location from Customer where district like '%"+location+"%') union (select subdistrict as location from Customer where subdistrict like '%"+location+"%')");
			while(rs.next()) {
				result+=rs.getString(1)+",";
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			connection.close();
		}
		return result;
	}
	
	public static String addToFavourite(int product_id,int customer_id) throws ClassNotFoundException, SQLException {
		int status=0;
		String setStatus="unliked";
		Connection connection=null;
		try{
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			int favId=0;
			ResultSet rs=stmt.executeQuery("select * from Favourite where product_id="+product_id+" and customer_id="+customer_id);
			if(rs.next()){
				favId=rs.getInt(1);
			}
			
			if(favId==0){
				status=stmt.executeUpdate("insert into Favourite(customer_id,product_id,isActive) values("+customer_id+","+product_id+",'Y')");
				setStatus="liked";
			}
			else{
				status=stmt.executeUpdate("Update Favourite set isActive='N' where fav_id="+favId+" and isActive='Y'");
				setStatus="unliked";
				if(status==0){
					status=stmt.executeUpdate("Update Favourite set isActive='Y' where fav_id="+favId+" and isActive='N'");
					setStatus="liked";
				}
			}
			if(status==0){
				setStatus=null;
			}
			
		}catch(SQLException e){
			status=0;
			System.out.println(e);
		}finally{
			connection.close();
		}
		return setStatus;
	}
	
	public static List<ProductBean> getProductsByLocation(String location) throws ClassNotFoundException, SQLException {
		Connection connection=null;
		List<ProductBean> prducts=new ArrayList<ProductBean>();
		try{
			ResultSet rs;
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			
			rs=stmt.executeQuery("select Category.category_name,Product.* from Category join Product on Category.category_id=Product.category_id join Customer on Product.created_by=Customer.customer_id where Customer.city= '"+location+"' or Customer.state= '"+location+"' or Customer.district= '"+location+"' or Customer.subdistrict= '"+location+"'");
			while(rs.next()) {
				ProductBean pBean=new ProductBean();
				String category="";
				
				pBean.setCategory_name(rs.getString(1));
				pBean.setId(rs.getInt("product_id"));
				pBean.setLoggedUser(rs.getInt("created_by"));
				pBean.setPrice(rs.getDouble("price"));
				pBean.setTitle(rs.getString("title"));
				pBean.setDetails(rs.getString("category_details"));
				pBean.setDescription(rs.getString("description"));
				prducts.add(pBean);
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			connection.close();
		}
		return prducts;
	}
	
	
	public static List<ProductBean> getProductsByCategory(String category) throws ClassNotFoundException, SQLException {
		Connection connection=null;
		List<ProductBean> prducts=new ArrayList<ProductBean>();
		try{
			ResultSet rs;
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			rs=stmt.executeQuery("select category_id from Category where category_name='"+category+"'");
			int category_id=0;
			if(rs.next()){
				category_id=rs.getInt(1);
			}
			rs=stmt.executeQuery("select * from Product where category_id="+category_id);
			while(rs.next()) {
				ProductBean pBean=new ProductBean();
				pBean.setCategory_name(category);
				pBean.setId(rs.getInt("product_id"));
				pBean.setLoggedUser(rs.getInt("created_by"));
				pBean.setPrice(rs.getDouble("price"));
				pBean.setTitle(rs.getString("title"));
				pBean.setDetails(rs.getString("category_details"));
				pBean.setDescription(rs.getString("description"));
				prducts.add(pBean);
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			connection.close();
		}
		return prducts;
	}
	
	
	
	public static List<ProductBean> getFavProducts(int id) throws ClassNotFoundException, SQLException {
		Connection connection=null;
		List<ProductBean> prducts=new ArrayList<ProductBean>();
		try{
			ResultSet rs;
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			System.out.print("customer "+id);
			rs=stmt.executeQuery("select Category.category_name,Product.* from Category join Product on Category.category_id=Product.category_id join Favourite on Favourite.product_id=Product.product_id where Favourite.customer_id="+id+" and Favourite.isActive='Y'");
			
			while(rs.next()) {
				ProductBean pBean=new ProductBean();
				pBean.setCategory_name(rs.getString(1));
				pBean.setId(rs.getInt("product_id"));
				pBean.setLoggedUser(rs.getInt("created_by"));
				pBean.setPrice(rs.getDouble("price"));
				pBean.setTitle(rs.getString("title"));
				pBean.setDetails(rs.getString("category_details"));
				pBean.setDescription(rs.getString("description"));
				prducts.add(pBean);
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			connection.close();
		}
		return prducts;
	}
	
	public static List<UserBean> getAllUsers() throws ClassNotFoundException, SQLException {
		Connection connection=null;
		List<UserBean> users=new ArrayList<UserBean>();
		try{
			ResultSet rs;
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			System.out.println("dao");
			rs=stmt.executeQuery("select * from Customer");
			while(rs.next()) {
				UserBean userBean=new UserBean();
				userBean.setId(rs.getInt(1));
				userBean.setFirstname(rs.getString(2));
				userBean.setLastname(rs.getString(3));
				userBean.setMobile(rs.getLong(4));
				userBean.setEmail(rs.getString(5));
				userBean.setState(rs.getString(7));
				userBean.setDistrict(rs.getString(8));
				userBean.setSubdistrict(rs.getString(9));
				userBean.setPin(rs.getInt(10));
				userBean.setCity(rs.getString(11));
				userBean.setIsActive(rs.getString(12).charAt(0));
				userBean.setCreated_by(rs.getInt(13));
				userBean.setCreated_date(rs.getString(14));
				userBean.setModified_by(rs.getString(15));
				userBean.setModified_date(rs.getString(16));
				users.add(userBean);
			}
			System.out.println("dao after query");
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			connection.close();
		}
		return users;
	}
	
	public static List<Category> getAllCategories() throws ClassNotFoundException, SQLException {
		Connection connection=null;
		List<Category> categories=new ArrayList<Category>();
		try{
			ResultSet rs;
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			System.out.println("dao");
			rs=stmt.executeQuery("select * from Category");
			while(rs.next()) {
				Category category=new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				categories.add(category);
			}
			System.out.println("dao after query");
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			connection.close();
		}
		return categories;
	}
	
	
	
	public static List<ProductBean> getAllProducts() throws ClassNotFoundException, SQLException {
		Connection connection=null;
		List<ProductBean> prducts=new ArrayList<ProductBean>();
		try{
			ResultSet rs;
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			System.out.println("dao");
			rs=stmt.executeQuery("select Category.category_name ,Product.* from Product join Category on Product.category_id=Category.category_id");
			while(rs.next()) {
				ProductBean pBean=new ProductBean();
				pBean.setCategory_name(rs.getString(1));
				pBean.setId(rs.getInt("product_id"));
				pBean.setLoggedUser(rs.getInt("created_by"));
				pBean.setPrice(rs.getDouble("price"));
				pBean.setTitle(rs.getString("title"));
				pBean.setDetails(rs.getString("category_details"));
				pBean.setDescription(rs.getString("description"));
				if(rs.getString(8).charAt(0)=='Y'){
					pBean.setResquestStatus(true);
				}
				else{
					pBean.setResquestStatus(false);
				}
				pBean.setIsActive(rs.getString(9).charAt(0));
				pBean.setCreated_by(rs.getInt(10));
				pBean.setCreated_date(rs.getString(11));
				pBean.setModified_by(rs.getString(12));
				pBean.setModified_date(rs.getString(13));
				prducts.add(pBean);
			}
			System.out.println("dao after query");
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			connection.close();
		}
		return prducts;
	}
	
	public static String getModelsFromDB(String brand) throws ClassNotFoundException, SQLException {
		Connection connection=null;
		String result="";
		try{
			ResultSet rs;
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			rs=stmt.executeQuery("select Model.model_name from Model join Brand on Brand.brand_id=Model.brand_id where Brand.brand_name='"+brand+"'");
			while(rs.next()) {
				result+=rs.getString(1)+",";
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			connection.close();
		}
		System.out.println(result);
		return result;
	}
	
	
}
