package com.demo.service;

import com.demo.model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;
    //    JavaMailSender interface of JavaMail API is used here to send simple text email.
    @Override
    public String sendSimpleMail(EmailDetails details) {
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            // Thiết lập các phần cần thiết để gửi mail
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipent());//lấy mail người nhận
            mailMessage.setText(details.getMsgBody());//lấy nội dung mail
            mailMessage.setSubject(details.getSubject());//lấy tiêu đề

            //Gửi mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        } catch (MailException e) {
            return "Error while Sending Mail";
        }
    }

//        MimeMessageHelper works as a helper class for MimeMessage to add the attachment and other details required to send the mail.
    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        //tạo mimeMessage
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            // Setting multipart as true for attachments to be send
            mimeMessageHelper =new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipent());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(details.getSubject());

//            //Neu muon them body la the html thi lam nhu sau
//            String htmlMsg = "<h3>Im testing send a HTML email</h3>"
//                    +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
//            mimeMessage.setContent(htmlMsg, "text/html");
            //Thêm file đính kèm
            FileSystemResource file=new FileSystemResource(new File(details.getAttachment()));
            mimeMessageHelper.addAttachment(file.getFilename(),file);
            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        } catch (MessagingException e) {
            return "Error while Sending Mail";
        }
    }
}
