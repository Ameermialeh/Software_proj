package org.mypackage;

import java.time.*;
import java.util.ArrayList;
import java.util.List;


public class Appointment
{
    int id;
    LocalDate date;
    LocalTime time;
    User user;
    Admin admin;
    boolean checkedIn;

    protected List <Service> services;



    public Appointment(int id, User user, LocalDate date, LocalTime time, Admin admin){
        setId(id);
        setUser(user);
        setTime(time);
        setDate(date);
        setAdmin(admin);
        checkedIn=false;
        services=new ArrayList<>();
    }
    
    public List <Service> getServices() {
        return services;
    }
    
    public Appointment(){
        checkedIn=false;
        services=new ArrayList<>();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }


    

    
}