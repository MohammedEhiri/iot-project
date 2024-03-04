package com.iotProject.iot.Services;

import com.iotProject.iot.Repositories.CapteurDataRepo;
import com.iotProject.iot.models.CapteurData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class TemperatureService {

    @Autowired
    private CapteurDataRepo capteurDataRepository;

    public double getCurrentTemperature() {
        List<CapteurData> capteurDataList = capteurDataRepository.findAllByOrderByDateTime();
        if (!capteurDataList.isEmpty()) {
            return capteurDataList.get(capteurDataList.size() - 1).getTemperature();
        } else {
            return -1;
        }
    }
    public double getLastHumidity() {
        List<CapteurData> capteurDataList = capteurDataRepository.findAllByOrderByDateTime();
        if (!capteurDataList.isEmpty()) {
            return capteurDataList.get(capteurDataList.size() - 1).getHumidity();
        } else {

            return -1;
        }
    }



    public void sendEmail(String to, String subject, String body) {
        final String username = "simo.ihiirii@gmail.com";
        final String password = "Blocageblocage";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

