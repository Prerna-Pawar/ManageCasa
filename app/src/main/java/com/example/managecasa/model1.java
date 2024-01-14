package com.example.managecasa;

public class model1
{
    String agenda,Date,Time,no;
    model1()
    {

    }


    public model1(String no, String agenda, String date, String time) {
        this.no = no;
        this.agenda = agenda;
        this.Date = date;
        this.Time = time;

    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
