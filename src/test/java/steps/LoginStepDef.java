package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginStepDef {
	
	@Given("open salesforce url")
    public void loginSalesforce() {
		System.out.println("This is login Step");
	}
	@And("I navigate to sales App")
	public void iNavigateToSalesApp() {
		System.out.println("This is Naviagation to Sales App  Step");
	}

}
