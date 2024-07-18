package com.henrygphp.swd392hospitalsystem.Services;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendEmail(String to, String subject, String text);
}
