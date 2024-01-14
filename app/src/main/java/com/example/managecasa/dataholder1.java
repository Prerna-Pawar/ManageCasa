package com.example.managecasa;

public class dataholder1 {
    String name,email,phone,subject,complaint;

    public dataholder1(String name, String email, String phone, String subject, String complaint) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
        this.complaint = complaint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
