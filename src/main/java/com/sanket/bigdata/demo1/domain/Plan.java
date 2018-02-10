package com.sanket.bigdata.demo1.domain;

public class Plan {
	
/*	"_org": "example.com",
	"objectId": "12xvxc345ssdsds",
	"objectType": "plan",
	"planType": "inNetwork",
	"creationDate": "12-12-3000"*/
	
	private String _org;
	private String objectId;
	private String objectType;
	private String planType;
	private String creationDate;
	
	public Plan() {
	}

	public Plan(String _org, String objectId, String objectType, String planType, String creationDate) {
		this._org = _org;
		this.objectId = objectId;
		this.objectType = objectType;
		this.planType = planType;
		this.creationDate = creationDate;
	}



	public String get_org() {
		return _org;
	}

	public void set_org(String _org) {
		this._org = _org;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public String getFirstName() {
		return _org;
	}

	public void setFirstName(String firstName) {
		this._org = firstName;
	}

	public String getLastName() {
		return objectId;
	}

	public void setLastName(String lastName) {
		this.objectId = lastName;
	}

	public String getEmailAddress() {
		return objectType;
	}

	public void setEmailAddress(String emailAddress) {
		this.objectType = emailAddress;
	}

	@Override
	public String toString() {
		return "Plan [_org=" + _org + ", objectId=" + objectId + ", objectType=" + objectType + ", planType=" + planType
				+ ", creationDate=" + creationDate + "]";
	}

}
