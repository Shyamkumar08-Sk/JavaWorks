package com.wipro.crms.entity;

public class Suspect {
	
	 private String suspectId;
	 private String name;
	 private String remarks;
	 
	 public Suspect(String suspectId, String name, String remarks) {
		this.suspectId = suspectId;
		this.name = name;
		this.remarks = remarks;
	 }

	 public String getSuspectId() {
		 return suspectId;
	 }

	 public void setSuspectId(String suspectId) {
		 this.suspectId = suspectId;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getRemarks() {
		 return remarks;
	 }

	 public void setRemarks(String remarks) {
		 this.remarks = remarks;
	 }
	 
	
}
