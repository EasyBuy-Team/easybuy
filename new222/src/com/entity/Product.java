package com.entity;

public class Product {
	private String name;
	private String area;
	private float price;
	
	public Product(String name,String area,float price){
		this.name=name;
		this.area=area;
		this.price=price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
