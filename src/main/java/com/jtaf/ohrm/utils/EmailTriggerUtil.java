package com.jtaf.ohrm.utils;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailTriggerUtil {

	public void sendEmail(String mailServer, String from, String[] to, String subject, String messageBody) {

	}

	@SuppressWarnings("unused")
	private class SMTPAuthenticator extends Authenticator {

	}
}
