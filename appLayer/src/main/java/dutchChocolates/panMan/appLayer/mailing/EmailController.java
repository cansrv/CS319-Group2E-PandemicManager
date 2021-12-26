package dutchChocolates.panMan.appLayer.mailing;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@RestController
public class EmailController {

    public String sendmail() throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ovgumcansezen@gmail.com", "hysasshysatdfona");
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("ovgumcansezen@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("haruncan.surav@gmail.com"));
        msg.setSubject("Covid Risk Be Careful");
        msg.setContent("Covid Risk Be Careful", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Covid Risk Be Careful", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        msg.setContent(multipart);
        Transport.send(msg);

        return "Successful";
    }

    @PostMapping(value = "/sendemail")
    @ResponseBody
    public String sendEmail() throws AddressException, MessagingException, IOException {
        sendmail();
        return "Email sent successfully";
    }
}
