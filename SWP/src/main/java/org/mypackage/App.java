package org.mypackage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	private static final String ADMIN = "admin";
	private static final String USER = "user";
	
	protected boolean loginStatus;
	protected User loggedUser;
	protected Admin loggedAdmin;
	protected DataBase db;
	protected Scanner scanner;

	public App() {
		db =new DataBase();
		loginStatus=false;
		scanner=new Scanner(System.in);
	}
	// Appointment

	public boolean isLoginStatus() {
		return loginStatus;
	}



	public DataBase getDb() {
		return db;
	}


	public boolean checkAppointmentExist(Appointment a){


		for(Appointment appointment : db.appointments)
			if(appointment.getDate().equals(a.getDate()) && appointment.getTime().equals(a.getTime())) {
				return true;
			}

	return false;
}


public boolean deleteAppointment(int id) {

	for(Appointment a : db.appointments)
		if( a.getId()== id ) {
			db.appointments.remove(a);
			return true;
		}
	return false;

}
// Login
public String attemptLogin(String username, String password) {

	if(usernameExists(username).equals(USER)) {
		if (passwordCorrect(username, password, USER))
			return "login successfully";
		else
			return "wrong password";
	}
	else if(usernameExists(username).equals(ADMIN)) {
		if (passwordCorrect(username, password, ADMIN))
			return "logged in as admin";
		else
			return "wrong password";
	}
	return "wrong username";

}

public User searchUsers(String username) {
	for(User u : db.getUsers()){
		if( u.username.equals(username)) {
			return u;
		}
	}
	return null;
}


private boolean passwordCorrect(String username, String password,String role) {

	if(role.equals(USER))
		for(User u : db.getUsers()){
			if( u.username.equals(username) && u.password.equals(password)) {
				return true;
			}
		}

	if(role.equals(ADMIN))
		for(Admin u : db.getAdmins()){
			if( u.username.equals(username) && u.password.equals(password)) {
				return true;
			}
		}


	return false;
}

private String usernameExists(String username) {


	for(User u : db.getUsers()){
		if( u.username.equals(username)) {
			return USER;
		}
	}
	for(Admin a : db.getAdmins()){
				if( a.username.equals(username)) {
					return ADMIN;
				}
			}
	return "not exist";
}

public String attemptRegister(String username, String password, String email, String phone) {

	if( usernameExists(username).equals("not exist")){
		if(!emailExists(email)){
			if(!phoneExists(phone)){

				db.getUsers().add(new User(username,password,email,phone));

				return "Registration successful";

			}else
				return "used phone number";

		}else
			return "used email";

	}else
		return "used username";

}

private boolean phoneExists(String phone) {
	var phoneExists=false;
	for(User u : db.getUsers()){
		if( u.phone.equals(phone)) {
			phoneExists = true;
			break;
		}
	}
	for(Admin u : db.getAdmins()){
				if( u.phone.equals(phone)) {
					phoneExists = true;
					break;
				}
			}

	return phoneExists;
}

private boolean emailExists(String email) {
	var emailExists=false;
	for(User u : db.getUsers()){
		if( u.email.equals(email)) {
			emailExists = true;
			break;
		}
	}
	for(Admin u : db.getAdmins()){
				if( u.email.equals(email)) {
					emailExists = true;
					break;
				}
			}

	return emailExists;
}

public List<Appointment> getAllAppointmentsForAdmin(Admin loggedAdmin) {
	List<Appointment> appointments=new ArrayList<>();

	for (Appointment a:db.appointments)
		if(a.getAdmin().equals(loggedAdmin))
			appointments.add(a);

	return appointments;

}

public boolean addServicesToAppointment(int selectedAppointment, int serviceID) {
	for (Appointment a : db.appointments)
		if (a.getId() == selectedAppointment) {
			for (Service s : db.services)
				if (s.getId() == serviceID) {
					a.services.add(s);
					a.setCheckedIn(true);
					return true;
				}


		}
	return false;
}

public double checkout(Appointment appointment) {
	double totalPrice=0;
	if(appointment.isCheckedIn())
		for(Service s: appointment.services)
			totalPrice += (int)s.getPrice();
	else
		totalPrice= -1;

	return totalPrice;
}

public boolean checkValidDate(String date) {
    String[] split = date.trim().split("-");
    var day =  Integer.parseInt(split[2]);
    var month = Integer.parseInt(split[1]);
    var year = Integer.parseInt(split[0]);

    if(day < 1 || day > 31 || month < 1 || month > 12)
        return false;
    else return year >= 2022;
}

public LocalTime createTime(String time) {
    String[] splitTime = time.trim().split(" ");
    var hour =Integer.parseInt(splitTime[0]);
    var minute=0;
    return LocalTime.of(hour,minute);
}

public LocalDate createDate(String date) {
    String[] splitDate = date.trim().split("-");
    var day =  Integer.parseInt(splitDate[2]);
    var month = Integer.parseInt(splitDate[1]);
    var year = Integer.parseInt(splitDate[0]);
    return LocalDate.of(year,month,day);
}

public boolean checkValidTime(String time) {
    String[] split = time.split(" ");
    var hour = Integer.parseInt(split[0]);

    if(split[1].equals("am"))
        return hour >= 7 && hour <= 11;
    else if(split[1].equals("pm"))
        return hour == 12 || (hour >= 1 && hour <= 5);
    else
        return false;

}
	
}