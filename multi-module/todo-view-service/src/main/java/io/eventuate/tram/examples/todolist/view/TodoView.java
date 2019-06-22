package io.eventuate.tram.examples.todolist.view;

import java.util.Date;

import io.eventuate.tram.examples.todolist.common.Utils;

public class TodoView {

  public static final String INDEX = "todos";
  public static final String TYPE = "todo";

  private String policyNumber;

  /*private String title;

  private boolean completed;

  private int executionOrder;*/

  private String policyRequestor;

	private String policyType;

	private Date policyEffectiveDate;

	private Date policyExpirationDate;

	private String policyDetails;
  
  public TodoView() {
  }

  /*public TodoView(String id, String title, boolean completed, int executionOrder) {*/
  public TodoView(String policyNumber, String policyRequestor, String policyType, Date policyEffectiveDate, Date policyExpirationDate,
			String policyDetails) {
    this.policyNumber = policyNumber;
    /*this.title = title;
    this.completed = completed;
    this.executionOrder = executionOrder;*/
    
    this.policyRequestor = policyRequestor;
	this.policyType = policyType;
	this.policyEffectiveDate = Utils.getDateWithoutTimeUsingFormat(policyEffectiveDate);
	this.policyExpirationDate = Utils.getDateWithoutTimeUsingFormat(policyExpirationDate);
	this.policyDetails = policyDetails;
  }

  public String getPolicyNumber() {
    return policyNumber;
  }

  public void setPolicyNumber(String policyNumber) {
    this.policyNumber = policyNumber;
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

/*  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public int getExecutionOrder() {
    return executionOrder;
  }

  public void setExecutionOrder(int executionOrder) {
    this.executionOrder = executionOrder;
  }*/
}
