package io.eventuate.tram.examples.todolist.command;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "todo")
@Access(AccessType.FIELD)
public class Todo {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="POLICYNUMBER", initialValue=100000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POLICYNUMBER")
	private Long policyNumber;
	
	
	/*
	 * private String title;
	 * 
	 * private boolean completed;
	 * 
	 * private int executionOrder;
	 */

	private String policyRequestor;

	private String policyType;

	private Date policyEffectiveDate;

	private Date policyExpirationDate;

	private String policyDetails;

	public Todo() {
	}

	// public Todo(String title, boolean completed, int executionOrder) {
	public Todo(String policyRequestor, String policyType, Date policyEffectiveDate, Date policyExpirationDate,
			String policyDetails) {
		/*
		 * this.title = title; this.completed = completed; this.executionOrder =
		 * executionOrder;
		 */

		this.policyRequestor = policyRequestor;
		this.policyType = policyType;
		this.policyEffectiveDate = policyEffectiveDate;
		this.policyExpirationDate = policyExpirationDate;
		this.policyDetails = policyDetails;
	}

	public Long getPolicyNumber() {
		return policyNumber;
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
	 * public int getExecutionOrder() { return executionOrder; }
	 * 
	 * public void setExecutionOrder(int executionOrder) { this.executionOrder =
	 * executionOrder; }
	 */
}
