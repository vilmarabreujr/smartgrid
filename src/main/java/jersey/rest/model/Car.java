package jersey.rest.model;

import java.io.Serializable;

public class Car implements Serializable {

	private static final long serialVersionUID = 1990240974518910848L;
	
	private int renavam;
	private String brand;
	private String model;
	private int year;
	private float price;
	
	public int getRenavam() {
		return renavam;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getYear() {
		return year;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setRenavam(int renavam) {
		this.renavam = renavam;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}	
	
}
