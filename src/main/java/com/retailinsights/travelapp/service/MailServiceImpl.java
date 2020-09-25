package com.retailinsights.travelapp.service;
import java.io.File;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl {
	
	  @Autowired 
	  private JavaMailSender mailSender;
	
	public void sendMail(String toAddress, String fromAddress, String subject, String content) {
		
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setFrom(fromAddress);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(content);
			mimeMessageHelper.setSentDate(new Date());
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			System.err.println("Error Sending Mail "+e.getMessage());
		}
	}

	public void sendHTMLMail(String toAddress, String fromAddress, String subject, String content) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setFrom(fromAddress);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(content,true);
			mimeMessageHelper.setSentDate(new Date());
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			System.err.println("Error Sending Mail "+e.getMessage());
		}
	}

	public void sendMailWithAttachment(String toAddress, String fromAddress, String subject, String content,
			File attachment) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setFrom(fromAddress);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(content,true);
			mimeMessageHelper.setSentDate(new Date());
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			System.err.println("Error Sending Mail "+e.getMessage());
		}
		
	}

	
}
