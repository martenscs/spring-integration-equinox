package net.martenscs.spring.inte.filter;

import java.io.File;

import org.springframework.integration.core.MessageSelector;
import org.springframework.integration.Message;

public class FileFilterMessageSelector implements MessageSelector {

	public boolean accept(Message<?> message) {
		if (message.getPayload() instanceof File
				&& ((File) message.getPayload()).getName().startsWith("msg")) {
			return false;
		}
		return true;
	}

}
