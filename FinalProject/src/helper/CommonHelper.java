package helper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import handler.AjaxHandler;
import impl.Implementation;
import bean.Category;
import bean.LoginBean;
import bean.ProductBean;
import bean.UserBean;

public class CommonHelper {
	public int addUserBean(UserBean user) throws ClassNotFoundException, SQLException {
		System.out.println("commonhelper -register");
		if(user.getFirstname().isEmpty()){
			System.out.println("commonhelper -register firstname empty");
			return 0;
		}
		Implementation impltn=new Implementation();
		return impltn.addUser(user);
	}
	
	public int updateUser(UserBean user) throws ClassNotFoundException, SQLException {
		System.out.println("commonhelper -update");
		if(user.getFirstname().isEmpty()){
			System.out.println("commonhelper -register firstname empty");
			return 0;
		}
		Implementation impltn=new Implementation();
		return impltn.updateUser(user);
	}
	
	public int addProductBean(ProductBean product) throws ClassNotFoundException, SQLException {
		System.out.println("commonhelper -register");
		if(product.getTitle().isEmpty()){
			System.out.println("commonhelper -register firstname empty");
			return 0;
		}
		Implementation impltn=new Implementation();
		return impltn.addProduct(product);
	}
	
	public UserBean checkLoginBean(LoginBean login) throws ClassNotFoundException, SQLException {
		if(login.getEmail().isEmpty()){
			return null;
		}
		AjaxHandler handler=new AjaxHandler();
		return handler.authenticateLogin(login.getEmail(), login.getPasswordString());
	}
	
	
	public List<Object> checUserkLoginBean(LoginBean login) throws ClassNotFoundException, SQLException {
		if(login.getEmail().isEmpty()){
			return null;
		}
		AjaxHandler handler=new AjaxHandler();
		return handler.authenticateUserLogin(login.getEmail(), login.getPasswordString());
	}
	
	public Map<String, Object> checUserkLoginBeanNew(LoginBean login) throws ClassNotFoundException, SQLException {
		if(login.getEmail().isEmpty()){
			return null;
		}
		AjaxHandler handler=new AjaxHandler();
		return handler.authenticateUserLoginNew(login.getEmail(), login.getPasswordString());
	}
	
	
	public Map<String,String> checkAdminLogin(LoginBean login) throws ClassNotFoundException, SQLException {
		if(login.getEmail().isEmpty()){
			return null;
		}
		AjaxHandler handler=new AjaxHandler();
		return handler.authenticateAdminLogin(login.getEmail(), login.getPasswordString());
	}
	
	public String getProductBrand(String type) throws ClassNotFoundException, SQLException {
		AjaxHandler handler=new AjaxHandler();
		if(type==null){
			return "";
		}
		else{
			return handler.getAllBrands(type);
		}
	}
	
	public String getProductModel(String brand) throws ClassNotFoundException, SQLException {
		AjaxHandler handler=new AjaxHandler();
		if(brand==null){
			return "";
		}
		else{
			return handler.getAllModels(brand);
		}
	}
	
	public String getLocations(String location) throws ClassNotFoundException, SQLException{
		AjaxHandler handler=new AjaxHandler();
		if(location==null){
			return "";
		}
		else{
			return handler.getAllLocations(location);
		}
	}
	

	public List<ProductBean> getProductByLocations(String location) throws ClassNotFoundException, SQLException{
		AjaxHandler handler=new AjaxHandler();
		if(location==null){
			return null;
		}
		else{
			return handler.getProductByLocations(location);
		}
	}
	
	public List<ProductBean> getProductByCategories(String category) throws ClassNotFoundException, SQLException{
		AjaxHandler handler=new AjaxHandler();
		if(category==null){
			return null;
		}
		else{
			return handler.getProductByCategory(category);
		}
	}
	
	public List<ProductBean> getFavouriteProducts(int id) throws ClassNotFoundException, SQLException{
		AjaxHandler handler=new AjaxHandler();
		if(id<=0){
			return null;
		}
		else{
			return handler.getFavouriteProducts(id);
		}
	}
	
	public List<ProductBean> getAllProducts() throws ClassNotFoundException, SQLException{
		Implementation implementation=new Implementation();
		return implementation.getAllProduct();
		
	}
	
	public List<UserBean> getAllUsers() throws ClassNotFoundException, SQLException{
		Implementation implementation=new Implementation();
		return implementation.getAllUser();
		
	}
	
	public List<Category> getAllCategories() throws ClassNotFoundException, SQLException{
		Implementation implementation=new Implementation();
		return implementation.getAllCategory();
		
	}
	
	public String addToFavourites(int pId,int cId) throws ClassNotFoundException, SQLException{
		AjaxHandler handler=new AjaxHandler();
		if(pId<=0){
			return null;
		}
		else{
			return handler.addToFavourite(pId, cId);
		}
	}
	
}
