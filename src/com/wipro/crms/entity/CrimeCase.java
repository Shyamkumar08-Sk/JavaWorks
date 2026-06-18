package com.wipro.crms.entity;

public class CrimeCase {
	
	private String caseId;
	private String crimeType;
	private String description;
	private String status;
	
	public CrimeCase(String caseId, String crimeType, String description, String status) {
		this.caseId = caseId;
		this.crimeType = crimeType;
		this.description = description;
		this.status = status;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
