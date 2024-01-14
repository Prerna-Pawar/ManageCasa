package com.example.managecasa;

public class HelperClass {
    String name, email, username, password,flatno,contactno,status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getFlatno() {
        return flatno;
    }

    public void setFlatno(String flatno) {
        this.flatno = flatno;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HelperClass(String name, String email, String username, String password, String flatno, String contactno, String status) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.flatno=flatno;
        this.contactno=contactno;
        this.status=status;
    }

    public HelperClass() {
    }
}
