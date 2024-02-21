package TestSteps;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.mypackage.App;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginSteps {
	
	String USERNAME;
	String PASSWORD;
	App app;
	String msg;
	
	public UserLoginSteps() {
		
		app=new App();
	}
	
	@Given("the user is not logged in")
	public void theUserIsNotLoggedIn() {

		Assert.assertFalse(app.isLoginStatus());

	}
	@Given("user enters {string} and {string}")
	public void userEntersAnd(String username, String password) {

		USERNAME=username;
		PASSWORD=password;
		
	}

	@When("user try to login")
	public void userTryToLogin() {
	    
		msg = app.attemptLogin(USERNAME,PASSWORD);
		
	}

	@Then("user should be told {string}")
	public void userShouldBeTold(String expectedMsg) {
	    assertEquals(expectedMsg, msg);
	}


 
}