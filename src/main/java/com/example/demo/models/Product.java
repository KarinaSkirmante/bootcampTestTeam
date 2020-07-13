package com.example.demo.models;

public class Product {
	//1.variables
	private String title;
	private float price;
	private int id;
	
	
	private static int idCounter =1;
	
	//2.constructors
	//no-argument constructor
	public Product()
	{
		
	}
	public Product(String title, float price) {
		this.title = title;
		this.price = price;
		this.id = idCounter;
		idCounter++;
	}
	
	//3. getters and setters
	
	
	public String getTitle() {
		return title;
	}
	public int getId() {
		return id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	//4.toString
	public String toString()
	{
		return id +"." +title + " " + price + " eur";
		
	}
	
}
