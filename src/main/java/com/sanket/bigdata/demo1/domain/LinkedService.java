package com.sanket.bigdata.demo1.domain;

public class LinkedService {
	
	/*"_org": "example.com",
	"objectId": "1234520xvc30sfs",
	"objectType": "service",
	"name": "well baby"*/
	
	private String _org;
	private String objectId;
	private String objectType;
	private String name;
	
	public LinkedService() {
	}
	
	public LinkedService(String _org, String objectId, String objectType, String name) {
		this._org = _org;
		this.objectId = objectId;
		this.objectType = objectType;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
