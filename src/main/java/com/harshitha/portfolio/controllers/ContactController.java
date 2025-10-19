package com.harshitha.portfolio.controllers;

import com.harshitha.portfolio.dto.ContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:5173") // your frontend origin
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping
    public String submitContact(@RequestBody ContactDTO contact) {
        // ✅ 1. Save contact details to a JSON file
        try (FileWriter file = new FileWriter("src/main/resources/data/contacts.json", true)) {
            file.write(contactToJson(contact) + ",\n");
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

        // ✅ 2. Send email to YOU (notification)
        try {
            SimpleMailMessage adminMessage = new SimpleMailMessage();
            adminMessage.setTo("harshithalingamaneni30.08@gmail.com"); // your inbox
            adminMessage.setSubject("📩 New Contact Form Submission");
            adminMessage.setText(
                    "Name: " + contact.getName() +
                            "\nMobile: " + contact.getMobile() +
                            "\nEmail: " + contact.getEmail() +
                            "\nMessage: " + contact.getMessage()
            );
            mailSender.send(adminMessage);

            // ✅ 3. Send confirmation to the user
            SimpleMailMessage userMessage = new SimpleMailMessage();
            userMessage.setTo(contact.getEmail());
            userMessage.setSubject("Thanks for contacting Harshitha! ❤️");
            userMessage.setText("Hey " + contact.getName() + ",\n\n" +
                    "Thanks for reaching out! I got your message:\n\n\"" + contact.getMessage() + "\"\n\n" +
                    "I’ll get back to you soon ✨\n\n" +
                    "Best,\nHarshitha 🌸");
            mailSender.send(userMessage);

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

        return "success";
    }

    private String contactToJson(ContactDTO contact) {
        return String.format(
                "{\"name\":\"%s\",\"mobile\":\"%s\",\"email\":\"%s\",\"message\":\"%s\"}",
                contact.getName(), contact.getMobile(), contact.getEmail(), contact.getMessage()
        );
    }
}
