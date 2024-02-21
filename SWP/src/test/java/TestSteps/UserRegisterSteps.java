package TestSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

import org.mypackage.App;

public class UserRegisterSteps {


    String USERNAME;
    String PASSWORD;
    String EMAIL;
    String PHONE;

    App app;
    String msg;


    public UserRegisterSteps(App app) {

        this.app=app;
    }


    @Given("user enters {string} and {string} and {string} and {string}")
    public void userEntersAndAndAnd(String username, String password, String email, String phone) {
        USERNAME=username;
        PASSWORD=password;
        EMAIL=email;
        PHONE=phone;
    }

    @When("user try to register")
    public void userTryToRegister() {

        msg = app.attemptRegister(USERNAME,PASSWORD,EMAIL,PHONE);
    }



    @Then("the user should be told {string}")
    public void theUserShouldBeTold(String expectedMsg) {
        assertEquals(expectedMsg, msg);
    }


}