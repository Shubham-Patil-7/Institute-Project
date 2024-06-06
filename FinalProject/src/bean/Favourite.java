package bean;

public class Favourite {
	private int fav_id,product_id,customer_id;
	private char isActive;
	public int getFav_id() {
		return fav_id;
	}
	public void setFav_id(int fav_id) {
		this.fav_id = fav_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public char getIsActive() {
		return isActive;
	}
	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}
}
