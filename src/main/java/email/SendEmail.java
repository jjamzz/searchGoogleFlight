package email;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.testng.Reporter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.LocalDate;

import static baseClass.Setup.prop;
import static baseClass.Setup.tmpdir;

public class SendEmail {
    public static void main(String[] args) throws MessagingException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        JavaMailSenderImpl mailSender = ctx.getBean(JavaMailSenderImpl.class);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //Pass true flag for multipart message
        MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage, true);
        mailMsg.setFrom(prop.getProperty("emailSender"));
        mailMsg.setTo(System.getProperty("emailRecipient"));
//        mailMsg.addBcc("jjamzz@hotmail.com");
        mailMsg.setSubject("Flight Search Result: " + System.getProperty("origin") + " - " + System.getProperty("destination"));
        mailMsg.setText("Results for " + System.getProperty("departureDate") + " - " + System.getProperty("returnDate"));
        LocalDate localDate = LocalDate.now();
        FileSystemResource file = new FileSystemResource(new File(tmpdir + "/" + System.getProperty("origin")) + "-"
                + (System.getProperty("destination")) + "_" + localDate + ".jpg");

        mailMsg.addAttachment("Results.jpg", file);
        mailSender.send(mimeMessage);
        Reporter.log("---Done---", true);
    }
}
