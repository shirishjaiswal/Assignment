package org.sendmail;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@Data
@AllArgsConstructor
public class HandleMail {
    private String sender;
    private String recipient;
    private String subject;
    private String message;
    private String twoStepVerificationCode;
    protected void sendMail() {

        //host : gmail in smtp :
       Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.ssl.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");

        //session
        Authenticator authenticator =
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, twoStepVerificationCode);
            }
        };

        Session mainSession = Session.getInstance(properties, authenticator);

        //create message object
        MimeMessage mimeMessage = new MimeMessage(mainSession);

        try {
            //sender
            mimeMessage.setFrom(sender);
            //receiver
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            //subject
            mimeMessage.setSubject(subject);
            //message
            mimeMessage.setText(message);
            //sending message
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
