package handler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;

import bean.ProductBean;
import bean.UserBean;
import dao.CommonDao;

public class AjaxHandler {
	public UserBean authenticateLogin(String mail,String pass) throws ClassNotFoundException, SQLException {
		return CommonDao.checkLogin(mail, pass);
	}
	
	public List<Object> authenticateUserLogin(String mail,String pass) throws ClassNotFoundException, SQLException {
		return CommonDao.checkUserLogin(mail, pass);
	}
	
	public Map<String,Object> authenticateUserLoginNew(String mail,String pass) throws ClassNotFoundException, SQLException {
		return CommonDao.checkUserLoginNew(mail, pass);
	}
	
	public Map<String,String> authenticateAdminLogin(String mail,String pass) throws ClassNotFoundException, SQLException {
		return CommonDao.checkAdminLogin(mail, pass);
	}
	
	public String getAllBrands(String type) throws ClassNotFoundException, SQLException {
		String brands=CommonDao.getBrandsFromDB(type);
		return brands;
	}
	public String getAllModels(String brand) throws ClassNotFoundException, SQLException {
		String models=CommonDao.getModelsFromDB(brand);
		return models;
	}
	
	public String getAllLocations(String location) throws ClassNotFoundException, SQLException {
		String loations=CommonDao.getLocationsFromDB(location);
		return loations;
	}
	
	public List<ProductBean> getProductByLocations(String location) throws ClassNotFoundException, SQLException {
		List<ProductBean> productBeans=CommonDao.getProductsByLocation(location);
		return productBeans;
	}
	
	public List<ProductBean> getProductByCategory(String category) throws ClassNotFoundException, SQLException {
		List<ProductBean> productBeans=CommonDao.getProductsByCategory(category);
		return productBeans;
	}
	
	public List<ProductBean> getFavouriteProducts(int id) throws ClassNotFoundException, SQLException {
		List<ProductBean> productBeans=CommonDao.getFavProducts(id);
		return productBeans;
	}
	
	public String checkEmail(String mail) throws ClassNotFoundException, SQLException {
		return CommonDao.checkEmail(mail);
	}
	
	public String addToFavourite(int product_id,int customer_id) throws SQLException {
		String result=null;
		try {
			result = CommonDao.addToFavourite(product_id, customer_id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
