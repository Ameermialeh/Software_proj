package TestSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import org.mypackage.Admin;
import org.mypackage.App;
import org.mypackage.Appointment;
import org.mypackage.Service;

import static org.junit.Assert.*;

public class VisitSteps {

    App app;
    int selectedAppointment;
    private boolean msg;
    private String AdminName;

    public VisitSteps(App app){
        this.app =app;
    }

    @Given("the admin {string} is logged in with password {string}")
    public void theAdminIsLoggedInWithPassword(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        String msg=app.attemptLogin(username,password);
        assertEquals("logged in as admin",msg);
        AdminName=username;
    }
    @Given("an appointment with the admin is booked")
    public void anAppointmentWithTheAdminIsBooked() {
        // Write code here that turns the phrase above into concrete actions
    	List<Appointment> appointments = null;
    	for(Admin a : app.getDb().getAdmins()){
    		if( a.getUsername().equals(AdminName)) {
    			appointments= app.getAllAppointmentsForAdmin(a);
    		}
    	}
        assertFalse(appointments.isEmpty());
    }
    @Given("admin selects appointment number {int}")
    public void adminSelectsAppointmentNumber(int appointmentID) {
        // Write code here that turns the phrase above into concrete actions
        selectedAppointment=appointmentID;
    }
    @When("user add service {int}")
    public void userAddService(int serviceID) {
        // Write code here that turns the phrase above into concrete actions
        msg=app.addServicesToAppointment(selectedAppointment,serviceID);
    }
    @Then("appointment should be converted to visit")
    public void appointmentShouldBeConvertedToVisit() {
        // Write code here that turns the phrase above into concrete actions
        Appointment appointment ;
        for(Appointment a:app.getDb().getAppointments())
            if(a.getId()==selectedAppointment){
                appointment=a;
                assertTrue(appointment.isCheckedIn());
                break;
            }
    }
    @Then("services {int} should be added to invoice")
    public void servicesAndShouldBeAddedToInvoice(int serviceID) {
        // Write code here that turns the phrase above into concrete actions

        assertTrue(msg);

    }
    @Then("show error")
    public void showError() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(msg);
    }

}
