package com.harshitha.portfolio.dto;

public class ContactDTO {
    private String name;
    private String mobile;
    private String email;
    private String message;

    // ✅ Getters
    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    // ✅ Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
