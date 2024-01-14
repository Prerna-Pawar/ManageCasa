package com.example.managecasa;

public class model3 {
    String title,date,notice;
    model3()
    {

    }

    public model3(String title, String date, String notice) {
        this.title = title;
        this.date = date;
        this.notice = notice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
