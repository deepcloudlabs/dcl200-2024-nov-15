package com.example.crm.event;

public class CustomerReleasedEvent extends CrmEvent {

	public CustomerReleasedEvent(String email) {
		super(email, CrmEventType.CUSTOMER_RELEASED);
	}

}
