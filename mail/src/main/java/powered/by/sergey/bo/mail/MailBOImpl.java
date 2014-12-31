package powered.by.sergey.bo.mail;

/*
 * #%L
 * ProjectX2013_03_23_web
 * %%
 * Copyright (C) 2013 - 2014 Powered by Sergey
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailBOImpl implements MailBO
{
	private Session session;
	 
	public MailBOImpl(Session session) {
		this.session = session;
/*		
		Properties sysProps = System.getProperties();// Get system properties
		final String host = sysProps.getProperty("SENDGRID_SMTP_HOST");
		final String username = sysProps.getProperty("SENDGRID_USERNAME");
		final String password = sysProps.getProperty("SENDGRID_PASSWORD");
		
		if (host != null && host.length() != 0) { // use Send Greed for production
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
		} else {
		    // for Google App Engine
			String environment = System.getProperty("com.google.appengine.runtime.environment");
			if (environment == "Production" || environment == "Development") {
				Properties props = new Properties();
				props.put("mail.smtp.host", "localhost");// Setup mail server
				session = Session.getDefaultInstance(props);// Get the default Session object.
			} else {
				try {
					session = (Session) new InitialContext().lookup("java:comp/env/mail/Session");
				} catch (NamingException e) { // use localhost for development
				}
			}
		}
		*/
	}

/*	public void sendTextEmail(String to, String subject, String textMessage) {
		if (testMode) {
			testSubject = subject;
			testText = textMessage;
			return;
		}
		try {
			MimeMessage message = new MimeMessage(session);// Create a default MimeMessage object.
			message.setFrom(new InternetAddress(from));// Set From: header field of the header.
			message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));// Set To: header field of the header.
			message.setSubject(subject);// Set Subject: header field
			message.setText(textMessage);// Now set the actual message
			Transport.send(message);// Send message
		} catch (MessagingException mex) {
			throw new RuntimeException(mex);
		}
	}
*/	
	public void sendHtmlEmail(String from, String to, String subject, String htmlMessage) {
		try {
			MimeMessage message = new MimeMessage(session);// Create a default MimeMessage object.
			message.setFrom(new InternetAddress(from));// Set From: header field of the header.
			message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));// Set To: header field of the header.
			message.setSubject(subject);// Set Subject: header field
			message.setContent(htmlMessage, "text/html" );// Send the actual HTML message, as big as you like
			Transport.send(message);// Send message
		} catch (Exception e) {
			//throw new RuntimeException(mex);
			e.printStackTrace();
		}
	}
	
/*	public void sendAttachmentInEmail(String to, String subject, String textMessage, String filename) {
		if (testMode) {
			testSubject = subject;
			testText = textMessage;
			return;
		}
		try {
			MimeMessage message = new MimeMessage(session);// Create a default MimeMessage object.
			message.setFrom(new InternetAddress(from));// Set From: header field of the header.
			message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));// Set To: header field of the header.
			message.setSubject(subject);// Set Subject: header field
			BodyPart messageBodyPart = new MimeBodyPart();// Create the message part
			messageBodyPart.setText("This is message body");// Fill the message
			Multipart multipart = new MimeMultipart();// Create a multipar message
			multipart.addBodyPart(messageBodyPart);// Set text message part
			messageBodyPart = new MimeBodyPart();// Part two is attachment
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart );// Send the complete message parts
			Transport.send(message);// Send message
		} catch (MessagingException mex) {
			throw new RuntimeException(mex);
		}

	}
*/}
