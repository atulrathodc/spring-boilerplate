package com.my.common.model;

import java.util.Date;

public class Txn {

	private long id;
	private Date date;
	private double total;

	
	@Override
	public String toString(){
		return id+", "+total;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	
}
