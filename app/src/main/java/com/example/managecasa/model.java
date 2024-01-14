package com.example.managecasa;

public class model {
    String name,contactno,flatno,Email,Status,username;
    model()
    {

    }

    public model(String name, String contactno, String flatno, String email, String status,String username) {
        this.name = name;
        this.contactno = contactno;
        this.flatno = flatno;
        Email = email;
        this.username=username;
        this.Status= status;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getFlatno() {
        return flatno;
    }

    public void setFlatno(String flatno) {
        this.flatno = flatno;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
