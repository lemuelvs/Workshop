package com.example.demo.main;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mobile {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobileName() {
		return MobileName;
	}
	public void setMobileName(String mobileName) {
		MobileName = mobileName;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mobile(int id, String mobileName, String color, int price) {
		super();
		this.id = id;
		MobileName = mobileName;
		Color = color;
		Price = price;
	}
	private String MobileName;
	private String Color;
	private int Price;

}
