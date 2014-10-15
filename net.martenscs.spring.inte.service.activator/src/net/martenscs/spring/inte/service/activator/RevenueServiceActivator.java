package net.martenscs.spring.inte.service.activator;

import org.springframework.integration.Message;

import net.martenscs.spring.inte.domain.Shiporder.Item;
import net.martenscs.spring.inte.domain.Shiporder;

public class RevenueServiceActivator {

	private double revenue = 0.0;

	public Message<Shiporder> adjustRevenue(Message<Shiporder> order) {
		System.out.println("Processing order");
		for (Item item : order.getPayload().getItem()) {
			revenue = revenue
					+ (item.getPrice().doubleValue() * item.getQuantity()
							.intValue());
			System.out.println("Revenue now up to:  " + revenue);
		}
		System.out.println("Done processing order");
		return order;
	}

}
