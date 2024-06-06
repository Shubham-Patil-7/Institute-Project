package impl;
import java.sql.SQLException;
import java.util.List;

import dao.CommonDao;
import bean.*;

public class Implementation {
	public int addUser(UserBean user) throws ClassNotFoundException, SQLException{
		System.out.println("implementaion -register");
		int userId=CommonDao.save(user);
		if(userId>=1){
			System.out.println("implementaion -register save query success");
		}
		else{
			System.out.println("implementaion -register save query eror");
		}
		
		return userId;
	}
	
	public int updateUser(UserBean user) throws ClassNotFoundException, SQLException{
		System.out.println("implementaion -update");
		int status=CommonDao.update(user);
		if(status>=1){
			System.out.println("implementaion -register save query success");
		}
		else{
			System.out.println("implementaion -register save query eror");
		}
		
		return status;
	}
	
	
	public int addProduct(ProductBean product) throws ClassNotFoundException, SQLException{
		System.out.println("implementaion -register");
		int userId=CommonDao.save(product);
		if(userId>=1){
			System.out.println("implementaion -register save query success");
		}
		else{
			System.out.println("implementaion -register save query eror");
		}
		
		return userId;
	}
	
	public List<ProductBean> getAllProduct() throws ClassNotFoundException, SQLException{
		System.out.println("implementaion -register");
		
		return CommonDao.getAllProducts();
	}
	
	public List<UserBean> getAllUser() throws ClassNotFoundException, SQLException{
		System.out.println("implementaion -register");
		
		return CommonDao.getAllUsers();
	}
	
	public List<Category> getAllCategory() throws ClassNotFoundException, SQLException{
		System.out.println("implementaion -register");
		
		return CommonDao.getAllCategories();
	}
	
	
}
