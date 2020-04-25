package com.anuj.reactivems.position;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Position {

	public Position(){

	}

	public Position(String positionId, String positionDate, String customerId, String positionType){
		this.positionId = positionId;
		this.positionDate = positionDate;
		this.customerId = customerId;
		this.positionType = positionType;
	}

	@Id
	@Column(name = "positionId")
	private String positionId;

	@Column(name = "positionDate")
	private String positionDate;
	
	@Column(name = "customerId")
	private String customerId;
	
	@Column(name = "positionType")
	private String positionType;

	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	public String getPositionDate() {
		return positionDate;
	}
	public void setPositionDate(String positionDate) {
		this.positionDate = positionDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPositionType() {
		return positionType;
	}
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}


}
