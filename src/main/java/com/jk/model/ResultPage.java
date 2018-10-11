package com.jk.model;

import java.io.Serializable;

public class ResultPage implements Serializable{

	private static final long serialVersionUID = 3059618602202643805L;

	private Integer total;
	
	private Object rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}
	
}
