package com.example.managecasa;

public class dataholder {
    String date,time,agenda,no;

    public dataholder(String no,String date, String time, String agenda) {
        this.no=no;
        this.date = date;
        this.time = time;
        this.agenda = agenda;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }
}
