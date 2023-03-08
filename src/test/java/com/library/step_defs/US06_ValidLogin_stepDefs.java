package com.library.step_defs;

import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US06_ValidLogin_stepDefs {

    LoginPage login = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("I login using {string} and {string}")
    public void i_login_using_and_library_user(String email, String password) {

        login.txt_username.sendKeys(email);
        login.txt_password.sendKeys(password);
       login.btn_signIn.click();
    }
    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String accountHolderName) {

        BrowserUtils.waitForVisibility(login.btn_accountHolderName,10);
        String actualName = login.btn_accountHolderName.getText();

        Assert.assertEquals(accountHolderName, actualName);
    }
}
