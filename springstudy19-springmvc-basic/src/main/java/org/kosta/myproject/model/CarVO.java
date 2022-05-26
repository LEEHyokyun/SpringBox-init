package org.kosta.myproject.model;

public class CarVO {
	private String model;
	private int price;

	public CarVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarVO(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CarVO [model=" + model + ", price=" + price + "]";
	}

}