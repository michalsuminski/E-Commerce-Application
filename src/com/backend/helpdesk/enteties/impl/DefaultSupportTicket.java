package src.com.backend.helpdesk.enteties.impl;

import src.com.backend.helpdesk.enteties.Priority;
import src.com.backend.helpdesk.enteties.RequestType;
import src.com.backend.helpdesk.enteties.SupportTicket;

public class DefaultSupportTicket implements SupportTicket {
	
	private static int priorityCounter = 1;
	
	private int id;
	private Priority priority;
	private RequestType requestType;
	
	{
		id = ++priorityCounter;  // automatic increment after new SupportTicket is created;
	}
	
	

	public DefaultSupportTicket(RequestType requestType) {
		super();
		this.requestType = requestType;
		this.priority = requestType.getPriority();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public Priority getPriority() {
		return this.priority;
	}

	@Override
	public int getSequentialNumber() {
		return this.id;
	}

	@Override
	public RequestType getRequestType() {
		return this.requestType;
	}

	@Override
	public String toString() {
		return "DefaultSupportTicket [id=" + id + ", priority=" + priority + ", requestType=" + requestType + "]";
	}
}

