package com.barban.utilities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JTableJsonResponse {

	@JsonProperty("Result")
	private String result;

	@JsonProperty("Records")
	private Object records;
	
	@JsonProperty("Record")
	private Object record;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Object getRecords() {
		return records;
	}

	public void setRecords(Object records) {
		this.records = records;
	}

	public Object getRecord() {
		return record;
	}

	public void setRecord(Object record) {
		this.record = record;
	}
	
	

}
