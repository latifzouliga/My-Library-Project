package com.library.step_defs;

import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.lang.module.Configuration;

public class Login_stepDefs {

    LoginPage login = new LoginPage();


    @Given("Librarian on the login page")
    public void librarian_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("Librarian enters valid email address")
    public void librarian_enters_valid_email_address() {
        login.txt_username.sendKeys(ConfigurationReader.getProperty("librarianUsername1"));
    }
    @When("Librarian enters valid password")
    public void librarian_enters_valid_password() {
        login.txt_password.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
    }
    @Then("Librarian clicks Sign in button")
    public void librarian_clicks_sign_in_button() {
        login.btn_signIn.click();
    }

    @Then("Librarian should see Library title")
    public void librarian_should_see_library_title() {
        BrowserUtils.waitFor(4);
        Assert.assertEquals("Library",Driver.getDriver().getTitle());
    }

    @When("Librarian enters invalid {string} address")
    public void librarian_enters_invalid_address(String emailAddress) {
        login.txt_username.sendKeys( (emailAddress.equals("empty") ? "" : emailAddress) );
    }

    @When("Librarian enters invalid {string}")
    public void librarian_enters_invalid(String password) {
        login.txt_password.sendKeys( (password.equals("empty") ? "" : password) );
    }

    @Then("Librarian should not be able to login")
    public void librarian_should_not_be_able_to_login() {
        String expectedTitle = "Login - Library";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }







}
















