package hcmute.edu.vn.adminservice.service.impl;

import hcmute.edu.vn.adminservice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class ContactService_Impl implements ContactService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void send(String fromAddress, String toAddress, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        try {
            mimeMessageHelper.setFrom(fromAddress);
            mimeMessageHelper.setTo(toAddress);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content);
            mimeMessageHelper.setSentDate(new Date());
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
