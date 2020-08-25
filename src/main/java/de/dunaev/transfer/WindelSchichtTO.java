package de.dunaev.transfer;

import java.time.LocalDate;

public class WindelSchichtTO {

	private Integer id;
	private Integer parentId;
	private LocalDate date; 
	
	
	public WindelSchichtTO() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getParentId() {
		return parentId;
	}


	public void setParentName(Integer parentId) {
		this.parentId = parentId;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
