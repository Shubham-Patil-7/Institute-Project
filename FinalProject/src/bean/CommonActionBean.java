package bean;

import handler.AjaxHandler;
import helper.CommonHelper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CommonActionBean
 */
public class CommonActionBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
     static HttpSession session=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonActionBean() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("commonactionbean -register");
		String forName=request.getParameter("action");
		if(forName.equals("register")){
			
				session=request.getSession(false);
			InputActionBean ipActionBean=new InputActionBean();
			UserBean user=ipActionBean.addUser(request,response);
			CommonHelper cmHelper=new CommonHelper();
			int userId=0;
			try {
				userId = cmHelper.addUserBean(user);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(userId>0){
				response.setStatus(200);
				session.setAttribute("customer_id", userId);
				session.setAttribute("current-session", "user");
				System.out.println(userId+" addUser  "+session.getAttribute("customer_id").toString());
				session.setAttribute("username",user.getFirstname());
				session.setAttribute("lastname",user.getLastname());
				session.setAttribute("email",user.getEmail());
				session.setAttribute("mobile",user.getMobile());
				response.sendRedirect("index.jsp?user=" + session.getAttribute("username")+"&status=success");
			}
			else if(userId==0){
				response.setStatus(1);
				System.out.println("error");
				response.sendRedirect("index.jsp?status=error");
			}
			else{
				response.setStatus(1);
				System.out.println("email already exist..");
				response.sendRedirect("index.jsp?status=exists");
			}
			
		}
		else if(forName.equals("isEmailExists")){
			AjaxHandler handler=new AjaxHandler();
			try {
				response.getWriter().write(handler.checkEmail(request.getParameter("email")));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(forName.equals("addProduct")){
			System.out.println("addProduct  "+session.getAttribute("customer_id").toString());
			InputActionBean ipActionBean=new InputActionBean();
			ProductBean product=ipActionBean.addProduct(request,session);
			CommonHelper cmHelper=new CommonHelper();
			String isAdded="Error";
			int userId=0;
			try {
				userId = cmHelper.addProductBean(product);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(userId>0){
				response.setStatus(200);
				isAdded="success";
			}
			else{
				response.setStatus(1);
				System.out.println("error");
			}
			
			response.sendRedirect("index.jsp?status="+isAdded);
		}
		else if(forName.equals("login")){
			if(request.getParameter("loginType")!=null && request.getParameter("loginType").equals("user")){
				if(session==null){
					session=request.getSession();
				}
				
				Map<String, Object> userData=new HashMap<String, Object>();
				OutputActionBean oabObj=new OutputActionBean();
				LoginBean login=oabObj.userLogin(request);
				CommonHelper helper=new CommonHelper();
				UserBean user=null;
				List<Favourite> favourites=new ArrayList<Favourite>();
				int customer_id=0;
				String status="error";
				session=request.getSession();
				try {
					userData=helper.checUserkLoginBeanNew(login);
					if(userData.get("user")!=null){
						user=(UserBean)userData.get("user");
						customer_id=user.getId();
						session.setAttribute("user", user);
						session.setAttribute("customer_id",customer_id);
						session.setAttribute("username", user.getFirstname());
						session.setAttribute("lastname",user.getLastname());
						session.setAttribute("email",user.getEmail());
						session.setAttribute("mobile",user.getMobile());
						if(userData.get("favourites")!=null){
							favourites=(ArrayList)userData.get("favourites");
							session.setAttribute("favourites",favourites);
							status="success";
							session.setAttribute("current-session", "user");
						}
					}
					else{
						status=(String)userData.get("status");
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.getWriter().write("{\"user\":\""+user+"\",\"url\":\"index\",\"status\":\""+status+"\"}");
				
				
			}else if(request.getParameter("loginType")!=null && request.getParameter("loginType").equals("admin")){
				
				session=request.getSession(false);
				String status="error",admin="Admin";
				OutputActionBean oabObj=new OutputActionBean();
				LoginBean login=oabObj.userLogin(request);
				Map<String,String> adminMap=new HashMap<String, String>();
				CommonHelper helper=new CommonHelper();
				int admin_id=0;
				try {
					adminMap=helper.checkAdminLogin(login);
					admin_id=Integer.parseInt(adminMap.get("adminId"));
					status=adminMap.get("status");
					if(status.equals("success")){
						admin=adminMap.get("adminName");
						session.setAttribute("current-session", "admin");
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session=request.getSession();
				session.setAttribute("admin_id",admin_id);
				session.setAttribute("username", admin);
				response.getWriter().write("{\"user\":\""+admin+"\",\"url\":\"admin-dashboard\",\"status\":\""+status+"\"}");
			}
		}
		else if(forName.equals("getBrands")){
			String brands="";
			session.setAttribute("formtype",request.getParameter("type"));
			CommonHelper helper=new CommonHelper();
			try {
				brands=helper.getProductBrand(request.getParameter("type"));
				if(!brands.equals("")){
					response.setStatus(200);
					response.getWriter().write(brands);
				}
				else{
					response.setStatus(404);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session=request.getSession();
			session.setAttribute("brands", brands);
		}
		else if(forName.equals("getModels")){
			String models="";
			CommonHelper helper=new CommonHelper();
			try {
				models=helper.getProductModel(request.getParameter("brand"));
				if(!models.equals("")){
					response.setStatus(200);
					response.getWriter().write(models);
				}
				else{
					response.setStatus(404);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session=request.getSession();
			session.setAttribute("models", models);
		}
		else if(forName.equals("getLocations")){
			String locations="";
			CommonHelper helper=new CommonHelper();
			try {
				locations=helper.getLocations(request.getParameter("location"));
				if(!locations.equals("")){
					System.out.println(locations);
					response.setStatus(200);
					response.getWriter().write(locations);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session=request.getSession();
			session.setAttribute("brands", locations);
		}
		else if(forName.equals("getProductByLocation")){
			String locations="";
			if(request.getParameter("location")!=null && session!=null){
				session.setAttribute("productBeansByCategories",null);
			}
			CommonHelper helper=new CommonHelper();
			List<ProductBean> pBeans=null;
			try {
				pBeans=helper.getProductByLocations(request.getParameter("location"));
				if(pBeans!=null){
					response.setStatus(200);
					session.setAttribute("productBeansByLocation", pBeans);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("productBeansByLocation", pBeans);
		}
		else if(forName.equals("getCustomerFavourites")){
			int customer=Integer.parseInt(request.getParameter("user_id"));
			CommonHelper helper=new CommonHelper();
			List<ProductBean> pBeans=null;
			try {
				pBeans=helper.getFavouriteProducts(customer);
				if(pBeans!=null){
					response.setStatus(200);
					session.setAttribute("favouriteProductBeans", pBeans);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("favouriteProductBeans", pBeans);
		}
		else if(forName.equals("addToFav")){
			CommonHelper helper=new CommonHelper();
			int pId=Integer.parseInt(request.getParameter("product_id")),cId=Integer.parseInt(session.getAttribute("customer_id").toString());
			String status="";
			try {
				status=helper.addToFavourites(pId,cId);
				if(status!=null){
					response.setStatus(200);
					session.setAttribute("favStatus", status);
					response.getWriter().write(status);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(forName.equals("home")){
			HttpSession session=request.getSession();
			CommonHelper helper=new CommonHelper();
			List<ProductBean> pBeans=null;
			try {
				System.out.println("action bean");
				pBeans=helper.getAllProducts();
				if(pBeans!=null){
					ProductBean bean=pBeans.get(0);
					response.setStatus(200);
					session.setAttribute("allProducts", pBeans);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("allProducts", pBeans);
			response.sendRedirect("index.jsp");
		}
		else if(forName.equals("getProductByCategory")){
			String categories="";
			if(request.getParameter("category")!=null && session!=null){
				session.setAttribute("productBeansByLocation",null);
			}
			CommonHelper helper=new CommonHelper();
			List<ProductBean> pBeans=null;
			try {
				pBeans=helper.getProductByCategories(request.getParameter("category"));
				System.out.println(request.getParameter("category"));
				if(pBeans!=null){
					response.setStatus(200);
					System.out.print("got motor products");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(session==null){
				HttpSession session=request.getSession();
				session.setAttribute("productBeansByCategories", pBeans);
			}
			else{
				session.setAttribute("productBeansByCategories", pBeans);
			}
		}
		else if(forName.equals("update-profile")){
			session=request.getSession();
			InputActionBean ipActionBean=new InputActionBean();
			UserBean user=ipActionBean.updateUser(request,response);
			CommonHelper cmHelper=new CommonHelper();
			
			int userId=Integer.parseInt(session.getAttribute("customer_id").toString());
			user.setId(userId);
			int status=0;
			try {
				status = cmHelper.updateUser(user);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(status>0){
				response.setStatus(200);
				session.setAttribute("customer_id", userId);
				response.getWriter().write("success");
			}
			else{
				response.setStatus(1);
				response.getWriter().write("error");
				System.out.println("error");
			}
			System.out.println(userId+" addUser  "+session.getAttribute("customer_id").toString());
			session.setAttribute("username",user.getFirstname());
			System.out.println(user.getFirstname());
			response.sendRedirect("edit-profile.jsp?user=" + session.getAttribute("username"));
		}
		else if(forName.equals("getAllProducts")){
			session=request.getSession(false);
			CommonHelper helper=new CommonHelper();
			List<ProductBean> pBeans=null;
			try {
				System.out.println("action bean");
				pBeans=helper.getAllProducts();
				if(pBeans!=null){
					ProductBean bean=pBeans.get(0);
					response.setStatus(200);
					session.setAttribute("allProducts", pBeans);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("allProducts", pBeans);
			response.sendRedirect("show-products.jsp");
		}
		else if(forName.equals("getAllUsers")){
			HttpSession session=request.getSession();
			CommonHelper helper=new CommonHelper();
			List<UserBean> uBeans=null;
			try {
				System.out.println("action bean");
				uBeans=helper.getAllUsers();
				if(uBeans!=null){
					UserBean bean=uBeans.get(0);
					response.setStatus(200);
					session.setAttribute("allUsers", uBeans);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("allUsers", uBeans);
			response.sendRedirect("show-users.jsp");
		}
		else if(forName.equals("getAllCategories")){
			HttpSession session=request.getSession();
			CommonHelper helper=new CommonHelper();
			List<Category> cBeans=null;
			try {
				System.out.println("action bean");
				cBeans=helper.getAllCategories();
				if(cBeans!=null){
					Category bean=cBeans.get(0);
					response.setStatus(200);
					session.setAttribute("allCategories", cBeans);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("allCategories", cBeans);
			response.sendRedirect("show-categories.jsp");
		}
		else{
			if(request.getAttribute("action").equals("home")){
				HttpSession session=request.getSession();
				CommonHelper helper=new CommonHelper();
				List<ProductBean> pBeans=null;
				try {
					System.out.println("action bean");
					pBeans=helper.getAllProducts();
					if(pBeans!=null){
						ProductBean bean=pBeans.get(0);
						response.setStatus(200);
						session.setAttribute("allProducts", pBeans);
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("allProducts", pBeans);
				response.sendRedirect("index.jsp");
			}
			System.out.println("commonaction not-login");
		}
			
	}

}

class InputActionBean{
	public UserBean addUser(HttpServletRequest req,HttpServletResponse res) {
		
		System.out.println("inputactionbean -register");
		UserBean userBean=new UserBean();
		userBean.setFirstname(req.getParameter("firstname"));
		userBean.setLastname(req.getParameter("lastname"));
		userBean.setMobile(Long.parseLong(req.getParameter("mobile")));
		userBean.setEmail(req.getParameter("mail"));
		userBean.setPass(req.getParameter("new-password"));
		userBean.setState(req.getParameter("state"));
		userBean.setDistrict(req.getParameter("district"));
		userBean.setSubdistrict(req.getParameter("subdistrict"));
		userBean.setCity(req.getParameter("village"));
		userBean.setPin(Integer.parseInt(req.getParameter("pin")));
		System.out.println(req.getParameter("village"));
		return userBean;
	}
	
	public UserBean updateUser(HttpServletRequest req,HttpServletResponse res) {
		
		System.out.println("inputactionbean -update");
		UserBean userBean=new UserBean();
		userBean.setFirstname(req.getParameter("firstname"));
		userBean.setLastname(req.getParameter("lastname"));
		userBean.setMobile(Long.parseLong(req.getParameter("mobile")));
		userBean.setEmail(req.getParameter("mail"));
		return userBean;
	}
	
	public ProductBean addProduct(HttpServletRequest req,HttpSession session) {
		String category=req.getParameter("type");
		String categoryDetails="";
		System.out.println(req.getParameter("fuelType"));
		if(category.equals("Car")){
			categoryDetails+="{\"brand\":"+req.getParameter("brand")+",\"model\":"+req.getParameter("model")+",";
			categoryDetails+="\"year\":"+req.getParameter("year")+",\"fuelType\":"+req.getParameter("fuelType")+",\"transmission\":"+req.getParameter("transmission")+",";
			categoryDetails+="\"km\":"+req.getParameter("km")+",\"no_of_owners\":"+req.getParameter("no-of-owners")+"}";
		}
		else if(category.equals("Motor")){
			categoryDetails+="{\"brand\":"+req.getParameter("brand")+",\"model\":"+req.getParameter("model")+",";
			categoryDetails+="\"year\":"+req.getParameter("year")+",\"km\":"+req.getParameter("km")+"}";
		}
		else{
			categoryDetails+="{\"brand\":"+req.getParameter("brand")+",\"model\":"+req.getParameter("model")+",";
			categoryDetails+="\"year\":"+req.getParameter("year")+"}";
		}
		ProductBean productBean=new ProductBean();
		int userId=Integer.parseInt(session.getAttribute("customer_id").toString());
		productBean.setLoggedUser(userId);
		productBean.setDetails(categoryDetails);
		productBean.setTitle(req.getParameter("title"));
		productBean.setDescription(req.getParameter("description"));
		productBean.setCategory_name(category);
		productBean.setResquestStatus(false);
		productBean.setPrice(Double.parseDouble(req.getParameter("price")));
		return productBean;
	}
}

class OutputActionBean{
	public LoginBean userLogin(HttpServletRequest req) {
		LoginBean loginBean=new LoginBean();
		loginBean.setEmail(req.getParameter("username"));
		loginBean.setPasswordString(req.getParameter("password"));
		return loginBean;
	}
	
	
}
