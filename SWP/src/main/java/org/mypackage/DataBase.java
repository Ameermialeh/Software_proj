package org.mypackage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

	 protected List<User> users;
	 protected List<Admin> admins;
	 protected List<Service> services;
	 protected List<Appointment> appointments;

    public DataBase(){
        users =new ArrayList<>();
        admins =new ArrayList<>();
        services=new ArrayList<>();
        appointments=new ArrayList<>();
        
        admins.add(new Admin("Mosab","m123","mosabdwe@hotmail.com","0598307602"));
   
        users.add(new User("Ameer","a123","ameerinad91@gmail.com","0599123456"));
        users.add(new User("Zayd","z123","zayd@gmail.com","0599333333"));


        appointments.add(new Appointment(1,users.get(0),LocalDate.of(2023,5,14),
                LocalTime.of(8,0), admins.get(0)));
        appointments.add(new Appointment(2,users.get(0),LocalDate.of(2023,8,14),
                LocalTime.of(8,0), admins.get(0)));
        appointments.add(new Appointment(3,users.get(1),LocalDate.of(2023,5,15),
                LocalTime.of(8,0), admins.get(0)));

        services.add(new Service(1,"hollywood smile",500));
        services.add(new Service(2,"tooth extraction",420));
        services.add(new Service(3,"dental implanting",1200));
        services.add(new Service(4,"regular checking",100));

        appointments.get(0).setCheckedIn(true);
        appointments.get(0).getServices().add(services.get(0));
        appointments.get(0).getServices().add(services.get(2));

    }
    
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Admin> getAdmins() {
        return admins;
    }
    public List<User> getUsers() {
        return users;
    }
}