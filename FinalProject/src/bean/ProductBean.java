package bean;

public class ProductBean {
	private int loggedUser, id;

	private String title, description, details;
	private double price;
	private String category_name;
	private boolean resquestStatus;
	private String imgUrl,modified_by,modified_date,created_date;
	private int created_by;
	private char isActive;

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String user_id) {
		this.category_name = user_id;
	}

	public boolean isResquestStatus() {
		return resquestStatus;
	}

	public void setResquestStatus(boolean resquestStatus) {
		this.resquestStatus = resquestStatus;
	}

	public int getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(int loggedUser) {
		this.loggedUser = loggedUser;
	}

}
