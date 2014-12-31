package powered.by.sergey.bo.mail;

public interface MailBO {
	void sendHtmlEmail(String from, String to, String subject, String htmlMessage);
}
