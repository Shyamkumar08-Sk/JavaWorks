package com.wipro.crms.entity;

public class InvestigationUpdate {
	
	private String updateId;
	private String caseId;
	private String date;
	private String description;
	
	public InvestigationUpdate(String updateId, String caseId, String date, String description) {
		this.updateId = updateId;
		this.caseId = caseId;
		this.date = date;
		this.description = description;
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
