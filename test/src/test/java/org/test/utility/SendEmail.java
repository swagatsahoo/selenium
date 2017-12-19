package org.test.utility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmail extends GenericConfigClass{
	
	public static String email() throws EmailException {
		
			System.out.println("Send Email Process started");
		
		  // Create the Report attachment
		  EmailAttachment reportAttachment = new EmailAttachment();
		  reportAttachment.setPath(OutputReport);
		  reportAttachment.setDisposition(EmailAttachment.ATTACHMENT);
		  reportAttachment.setDescription("TestReport" + df.format(date) +".html");
		  reportAttachment.setName("TestReport" + df.format(date) +".html");
		  
// Create the screenshotAattachment
		  //EmailAttachment screenshotAttachment = new EmailAttachment();
		 // screenshotAttachment.setPath(TakeScreenshot.destination);
		  //screenshotAttachment.setDisposition(EmailAttachment.ATTACHMENT);
		  //screenshotAttachment.setDescription("Screenshot" + df.format(date) +".png");
		  //screenshotAttachment.setName("Error Screenshot" + df.format(date) +".png");
		  
		  
		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName(configPropertyReader.hostName());
		  email.setSslSmtpPort(configPropertyReader.hostSMTPport());
		  email.setAuthenticator(new DefaultAuthenticator(configPropertyReader.emailHostUsername() , configPropertyReader.emailHostPassword()));
		  email.setSSLOnConnect(true);
		  email.setFrom(configPropertyReader.emailFrom(), "Test Report Server");
		  email.setSubject("Test Report triggered on : " + df.format(date));
		  email.setMsg("Dear User, \n\n Please find the attached html report that was executed on Date: "+df.format(date) +" \n\n\n\n |Test Report Admin|"
		  									+ "\n\n ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
		  									+ "\n |Disclaimer|: Do not reply to this email address directly. Your mails might not be entertained \n"
		  										 + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		  email.addTo(configPropertyReader.emailTo(), "Swagat Sahoo");

		  // add the attachment
		  email.attach(reportAttachment);
		  //email.attach(screenshotAttachment);
		  
		  //Send Email
		  return email.send();
		  
		  
		
	}

}
