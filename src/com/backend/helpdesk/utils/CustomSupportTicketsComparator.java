package src.com.backend.helpdesk.utils;

import java.util.Comparator;

import src.com.backend.helpdesk.enteties.SupportTicket;

public class CustomSupportTicketsComparator implements Comparator<SupportTicket> {

	@Override
	public int compare(SupportTicket o1, SupportTicket o2) {
		if (o1 == null || o2 == null || o1.getPriority() == null ||  
				o2.getPriority() == null) {
			return 0;
		}
		// if priority is the same -> identifier is key
		if(o1.getPriority().equals(o2.getPriority())) {
			return o2.getSequentialNumber() - o1.getSequentialNumber();  // ten z mniejszym id jest starszy i powinien pierwszy wyjść
		}else {
			return o2.getPriority().compareTo(o1.getPriority()); // czyli compareTo umie automatycznie porównywać enumy
		}
	}


}