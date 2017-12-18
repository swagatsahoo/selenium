package org.test;

import org.apache.commons.mail.EmailException;

public class CallEmail extends SendEmail{
	
	public void emailsent() throws EmailException {
		SendEmail.email();
	}

}
