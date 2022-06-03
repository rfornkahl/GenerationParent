package com.genparent.Generation.Parent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

@Controller
public class EmailContactController {

    @Autowired
    private JavaMailSender mailSender;


    @GetMapping ("index")
    public String contactForm(){

        return "contact_form";
    }

    @PostMapping("index")
    public String submitContact(HttpServletRequest request,
        @RequestParam("attachment") MultipartFile multipartFile
    ) throws MessagingException, UnsupportedEncodingException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        MimeMessage response = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(response, true);



        String mailSubject = name + " has sent a message";
        String mailContent = "<p><b>Sender Name:</b> " + name + "</p>";
        mailContent += "<p><b>Sender Email:</b> " + email + "</p>";
        mailContent += "<p><b>Subject:</b> " + subject + "</p>";
        mailContent += "<p><b>Message:</b> " + message + "</p>";


        helper.setFrom("genparentcontact@gmail.com", "Generation Parent User Contact Response");
        helper.setTo("genparentcontact@gmail.com");

        helper.setSubject(mailSubject);
        helper.setText(mailContent, true);



        if(!multipartFile.isEmpty()){
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

            InputStreamSource source = new InputStreamSource() {

                @Override
                public InputStream getInputStream() throws IOException {
                    return multipartFile.getInputStream();
                }
            };

            helper.addAttachment(fileName, source);
        }

        mailSender.send(response);

        return "response";
    }
}
