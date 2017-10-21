package org.fastdev.restmailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

@SpringBootApplication
public class RestMailSenderApplication {



	public static void main(String[] args) {
		SpringApplication.run(RestMailSenderApplication.class, args);
	}

	@RestController
	@RequestMapping("/v1/send-mail")
	public class SendMail{

		@Autowired
		private JavaMailSender sender;

		@PostMapping("/with-attachment")
		public String mailWithAttachment(MailTo mailTo){
			try {
				sendEmail(mailTo);
			} catch (Exception e) {
				return "KO";
			}
			return "OK";
		}

		private void sendEmail(MailTo mailTo) throws Exception{
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			helper.setTo(mailTo.getTo());//"lasalazar@gmail.com");
			helper.setSubject(mailTo.getSubject());//"Hi");
			helper.setText(mailTo.getMessage());//"How are you?");

			sender.send(message);
		}
	}
}