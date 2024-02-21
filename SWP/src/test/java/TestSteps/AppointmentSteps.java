package TestSteps;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.mypackage.App;
import org.mypackage.Appointment;
import org.mypackage.User;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppointmentSteps
{
    
    String TIME,DATE,MSG,USER;

    boolean msg1,msg2;
    int appointmentID;
    App app;


    public AppointmentSteps(App app) {

        this.app=app;


    }
    
    @Given("{string} add {string} and {string}")
    public void addand(String user ,String Time, String Date) {
    	USER = user;
        TIME = Time;
        DATE = Date;

    }
    @When("the time and date are valid")
    public void the_time_and_date_are_valid() {
        msg1=app.checkValidDate(DATE);
    	msg2=app.checkValidTime(TIME);

    	
    	if(msg1&& msg2) {
    		MSG = "Successful Add";
    	}else {
    		MSG="Unsuccessful Add";
    	}
    }


    @When("the Date are not Valid")
    public void theDateAreNotValid() {
        // Write code here that turns the phrase above into concrete actions
        boolean msg = app.checkValidDate(DATE);
        if(msg)
            MSG="valid date";
        else
            MSG="invalid date";

    }
    @Then("Tell the user {string}")
    public void tellTheUser(String expectedMsg) {
        // Write code here that turns the phrase above into concrete actions
    	assertEquals(expectedMsg, MSG);
    }

    @When("the Time are not Valid")
    public void theTimeAreNotValid() {
        // Write code here that turns the phrase above into concrete actions
        boolean msg = app.checkValidTime(TIME);
        if(msg)
            MSG="valid time";
        else
            MSG="invalid time";
    }


    @When("the appointment is already exist")
    public void theAppointmentIsAlreadyExist() {
        // Write code here that turns the phrase above into concrete actions
    	Appointment appointment=new Appointment();
        appointment.setDate(app.createDate(DATE));
        appointment.setTime(app.createTime(TIME));
    	if(app.checkAppointmentExist(appointment))
            MSG="Appointment already booked";
    }

    // Delete

    @Given("The {string} enter {int} existing appointment")
    public void theEnterExistingAppointment(String user, Integer numberofelemant) {
        // Write code here that turns the phrase above into concrete actions
       USER =user;
       appointmentID =numberofelemant;
    }
    @When("the user select the appointment to Delete")
    public void theUserSelectTheAppointmentToDelete() {
        // Write code here that turns the phrase above into concrete actions
        User u=app.searchUsers(USER);
        if(u ==null)
            MSG="Fail Delete the appointment";
        else
            if(app.deleteAppointment(appointmentID))
                 MSG="Success Delete the appointment";
            else
                 MSG="Fail Delete the appointment";
    }

//update
    @When("the user enter new {string} and new {string}")
    public void theUserEnterNewAndNew(String Time, String Date) {

        User u=app.searchUsers(USER);
        Appointment a =new Appointment();
        if(!app.checkValidDate(Date) || !app.checkValidTime(Time))
            MSG="fail update";
        else {
            a.setDate(app.createDate(Date));
            a.setTime(app.createTime(Time));

            if (app.checkAppointmentExist(a))
                MSG = "Appointment already booked";
            else {

                for(Appointment appointment:app.getDb().getAppointments())
                    if(appointment.getId()==appointmentID){
                        appointment.setDate(app.createDate(Date));
                        appointment.setTime(app.createTime(Time));
                        break;
                    }


                MSG = "success Update";
            }
        }

    	
    }
    


}