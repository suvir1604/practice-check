package com.cognizant.truyum.model;

import java.util.Date;

import com.cognizant.truyum.util.DateUtil;

public class MenuItem {
	private long Id;
	private String name;
	private float price;
	private boolean active;
	private Date dateofLaunch;
	private String category;
	private boolean freeDelivery;

	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuItem(long Id, String name, float price, boolean active, Date dateofLaunch, String category,
			boolean freeDelivery) {
		super();
		this.Id = Id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateofLaunch = dateofLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

	public long getId() {
		return Id;
	}

	public void setId(long Id) {
		this.Id = Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateofLaunch() {
		return dateofLaunch;
	}

	public void setDateofLaunch(Date dateofLaunch) {
		this.dateofLaunch = dateofLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id ^ (Id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (Id != other.Id)
			return false;
		return true;
	}

	public String toString() {
		String details = String.format("%-20s Rs.%7.2f %-5s %-10s %-15s %-5s Edit", name, price, active ? "Yes" : "No",
				DateUtil.Converttostring(dateofLaunch), category, freeDelivery ? "Yes" : "No");

		return details;

	}
}
