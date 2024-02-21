package TestSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.mypackage.App;
import org.mypackage.Appointment;
import org.mypackage.Service;

public class invoiceSteps {
    App app;
    private Appointment appointment;
    double totalPrice;
    private String msg;
    private Integer ID;

    public invoiceSteps(App app){
        this.app=app;
    }

    @Given("an appointment with id {int} is marked as visited")
    public void an_appointment_with_id_is_marked_as_visited(Integer id) {
        // Write code here that turns the phrase above into concrete actions
        ID=id;
        for(Appointment a:app.getDb().getAppointments())
            if(a!=null && a.getId()==id && a.isCheckedIn())
                appointment = a;
    }
    @Given("services {int} and {int} are added")
    public void services_and_are_added(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
       for(Service s:appointment.getServices())
           assertTrue(s.getId()==int1 || s.getId()==int2);
    }
    @When("user selects check out")
    public void user_selects_check_out() {
        // Write code here that turns the phrase above into concrete actions

        for(Appointment a : app.getDb().getAppointments())
            if(a!=null && a.getId()==ID )
                totalPrice=app.checkout(a);

        if (totalPrice<0)
            msg="cart empty, the user didn't visit";
        else
            msg="successful checkout";

    }
    @Then("invoice total value should be {double}")
    public void invoice_total_value_should_be(Double price) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(totalPrice, price,0.00);
    }

    @Given("an appointment with id {int} is not marked as visited")
    public void an_appointment_with_id_is_not_marked_as_visited(Integer id) {
        // Write code here that turns the phrase above into concrete actions
        ID=id;
        for(Appointment a : app.getDb().getAppointments())
            if(a!=null && a.getId()==id && a.isCheckedIn())
                appointment = a;
    }

    @Then("user must be told {string}")
    public void user_must_be_told(String string) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(msg,string);
    }


}