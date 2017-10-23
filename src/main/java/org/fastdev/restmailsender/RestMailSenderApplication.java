package org.fastdev.restmailsender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@SpringBootApplication
public class RestMailSenderApplication {

    private final Logger log = LoggerFactory.getLogger(RestMailSenderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestMailSenderApplication.class, args);
    }

    @RestController
    @RequestMapping("/v1/send-mail")
    public class SendMail {

        @Autowired
        private JavaMailSender sender;

        @Value("${rest.mail.from}")
        String mailFrom;


        @PostMapping("/with-attachment")
        public String mailWithAttachment(@RequestBody MailTo mailTo) {
            try {
                // SERA
                log.info("Send mail with parameters MailTo= {}", mailTo);
                sendEmail(mailTo);
                return "{\"message\": \"OK\"}";
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return "{\"message\": \"Error\"}";
            }
        }

        private void sendEmail(MailTo mailTo) throws Exception {
//            MimeMessage message = sender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message);
//            helper.setFrom(mailFrom);
//            helper.setTo(mailTo.getTo());//"lasalazar@gmail.com");
//            helper.setSubject(mailTo.getSubject());//"Hi");
//            helper.setText(mailTo.getMessage());//"How are you?");
//
//            sender.send(message);

            //
            MimeMessage mail = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(mailTo.getTo());
            helper.setSubject(mailTo.getSubject());
            helper.setText(mailTo.getMessage(), true);
            helper.setFrom(mailFrom);
            ClassPathResource file = new ClassPathResource("sample.png");
            helper.addAttachment("sample.png", file);

            sender.send(mail);


//
//            if (emailVo.getImage() != null) {
//                byte[] imageByte = Base64.getDecoder().decode(emailVo.getImage());
//                helper.addAttachment(emailVo.getImageName(), new ByteArrayResource(imageByte));
//            }
            //
        }
    }
}