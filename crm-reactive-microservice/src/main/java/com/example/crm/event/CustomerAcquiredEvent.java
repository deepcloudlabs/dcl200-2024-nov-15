package com.example.crm.event;

public class CustomerAcquiredEvent extends CrmEvent {

	public CustomerAcquiredEvent(String email) {
		super(email, CrmEventType.CUSTOMER_ACQUIRED);
	}

}
