package net.martenscs.spring.inte.enricher;

import net.martenscs.spring.inte.domain.*;
import net.martenscs.spring.inte.domain.Shiporder.Item;

import org.springframework.integration.Message;

public class ShipOrderEnricher {

	public double computeTotal(Message<Shiporder> order) {
		double sum = 0;
		for (Item item : order.getPayload().getItem()) {
			sum = sum
					+ (item.getPrice().doubleValue() * item.getQuantity()
							.intValue());
		}
		return sum;
	}

}
