package io.eventuate.tram.examples.todolist.command;

import java.util.Date;

import io.eventuate.tram.examples.todolist.common.Utils;

public class CreateTodoRequest {
	/*
	 * private String title; private boolean completed; private int order;
	 */

	private String policyRequestor;
	private String policyType;
	private Date policyEffectiveDate;
	private Date policyExpirationDate;
	private String policyDetails;

	public CreateTodoRequest() {
	}

	/* public CreateTodoRequest(String title, boolean completed, int order) { */
	public CreateTodoRequest(String policyRequestor, String policyType, Date policyEffectiveDate,
			Date policyExpirationDate, String policyDetails) {
		/*
		 * this.title = title; this.completed = completed; this.order = order;
		 */
		this.policyRequestor = policyRequestor;
		this.policyType = policyType;
		this.policyEffectiveDate = Utils.getDateWithoutTimeUsingFormat(policyEffectiveDate);
		this.policyExpirationDate = Utils.getDateWithoutTimeUsingFormat(policyExpirationDate);
		this.policyDetails = policyDetails;
		
	}

	public String getPolicyRequestor() {
		return policyRequestor;
	}

	public void setPolicyRequestor(String policyRequestor) {
		this.policyRequestor = policyRequestor;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Date getPolicyEffectiveDate() {
		return policyEffectiveDate;
	}

	public void setPolicyEffectiveDate(Date policyEffectiveDate) {
		this.policyEffectiveDate = policyEffectiveDate;
	}

	public Date getPolicyExpirationDate() {
		return policyExpirationDate;
	}

	public void setPolicyExpirationDate(Date policyExpirationDate) {
		this.policyExpirationDate = policyExpirationDate;
	}

	public String getPolicyDetails() {
		return policyDetails;
	}

	public void setPolicyDetails(String policyDetails) {
		this.policyDetails = policyDetails;
	}

	/*
	 * public String getTitle() { return title; }
	 * 
	 * public void setTitle(String title) { this.title = title; }
	 * 
	 * public boolean isCompleted() { return completed; }
	 * 
	 * public void setCompleted(boolean completed) { this.completed = completed; }
	 * 
	 * public int getOrder() { return order; }
	 * 
	 * public void setOrder(int order) { this.order = order; }
	 */
}
