package email;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

import static baseClass.Setup.prop;

@Configurable
public class AppConfig {
    @Bean
    public JavaMailSenderImpl JavaMailSenderImpl() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);
        //Set gmail email id
        mailSender.setUsername(prop.getProperty("emailSender"));
        //Set gmail email password
        mailSender.setPassword(prop.getProperty("emailPassword"));
        Properties mailProp = mailSender.getJavaMailProperties();
        mailProp.put("mail.transport.protocol", "smtps");
        mailProp.put("mail.smtp.auth", "true");
        mailProp.put("mail.smtp.starttls.enable", "true");
        mailProp.put("mail.debug", "true");
        return mailSender;
    }
}