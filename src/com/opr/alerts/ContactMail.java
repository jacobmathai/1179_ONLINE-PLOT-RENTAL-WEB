/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.alerts;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.opr.utils.AppConstants;

/**
 * 
 * @author staff
 */
public class ContactMail implements Runnable {
	private String name = "";
	private String message = "";
	private String email = "";

	public ContactMail(String name, String email, String message) {
		this.name = name;
		this.message = message;
		this.email = email;
	}

	public void sendMail(String name, String email, String message) {
		Properties properties = System.getProperties();
		properties.put("mail.smtps.host", "smtp.gmail.com");
		properties.put("mail.smtps.auth", "true");
		properties.put("mail.smtps.quitwait", "false");
		Session session = Session.getInstance(properties);
		try {
			Transport tr = session.getTransport("smtps");
			tr.connect("smtp.gmail.com", AppConstants.CONNECT_MAIL, AppConstants.CONNECT_PASSWORD);
			session.setDebug(true);
			System.out.println("Account Connected");
			MimeMessage msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(AppConstants.CONNECT_MAIL));
			msg.addRecipients(Message.RecipientType.TO, AppConstants.CONTACT_MAIL);
			// msg.addRecipients(Message.RecipientType.CC,
			// "javavfs15@gmail.com");
			msg.setSubject("FeedBack & Suggestions");
			// msg.setText("hai hello how are you msg");
			// for body message
			BodyPart bp = new MimeBodyPart();
			bp.setText("Name :" + name + "\n" + "Email :" + email + "\nMessage :"+message);
			// for attachment
			// BodyPart bodyPart = new MimeBodyPart();
			// DataSource dataSource = new FileDataSource("G:\\Sunset.jpg");
			// bodyPart.setFileName("sunset.jpg");
			// bodyPart.setDataHandler(new DataHandler(dataSource));

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(bp);
			// multipart.addBodyPart(bodyPart);
			msg.setContent(multipart);
			msg.saveChanges();
			System.out.println("Message sending");
			tr.sendMessage(msg, msg.getAllRecipients());
			tr.close();
			System.out.println("Message send !!");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sendMail(name, email, message);
	}
}
