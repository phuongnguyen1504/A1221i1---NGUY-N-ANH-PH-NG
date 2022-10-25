package com.demo.service;

import com.demo.model.EmailDetails;

public interface EmailService {
    //phương thức dùng để gửi mail nội dung k đính kèm file;
    String sendSimpleMail(EmailDetails emailDetails);

    //phương thức dùng để gửi đính kèm file;
    String sendMailWithAttachment(EmailDetails emailDetails);
}
