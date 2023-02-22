package com.ty.team_jsp__mcd_project_dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String descrption;
	private double price;
	private double offer;
	private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getOffer() {
		return offer;
	}
	public void setOffer(double offer) {
		this.offer = offer;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int  quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", descrption=" + descrption + ", price=" + price + ", offer="
				+ offer + ", quantity=" + quantity + "]";
	}
	

}
