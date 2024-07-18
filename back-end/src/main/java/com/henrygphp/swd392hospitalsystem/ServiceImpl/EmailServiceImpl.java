package com.henrygphp.swd392hospitalsystem.ServiceImpl;

import com.henrygphp.swd392hospitalsystem.Config.EmailConfig;
import com.henrygphp.swd392hospitalsystem.Services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;

    private TemplateEngine templateEngine;

    private EmailConfig emailConfig;

    @Override
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
