package com.library.step_defs;

import com.github.javafaker.Faker;
import com.library.pages.UsersPage;
import com.library.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AddUser_stepDefs {


    UsersPage usersPage = new UsersPage();
    Faker faker = new Faker();


    @Given("Librarian clicks Add user button")
    public void librarian_clicks_add_user_button() {
        usersPage.btn_adduser.click();
    }

    @Then("Librarian should see Add User popup window")
    public void librarian_should_see_add_user_popup_window() {
        BrowserUtils.waitForVisibility(usersPage.header_addUser,10);
        Assert.assertTrue(usersPage.header_addUser.isDisplayed());
    }

    @Then("Librarian enters Full Name")
    public void librarian_enters_full_name() {
        usersPage.txt_fullName.sendKeys(faker.name().fullName());
    }

    @Then("Librarian enters Email")
    public void librarian_enters_email() {
        usersPage.txt_email.sendKeys(faker.internet().emailAddress());
    }

    @Then("Librarian enters password")
    public void librarian_enters_password() {
        usersPage.txt_password.sendKeys(faker.internet().password());
    }


    @Then("Librarian enters Start Date")
    public void librarian_enters_start_date() {
        usersPage.startDate.clear();
        usersPage.startDate.sendKeys("2023-04-05");
    }

    @Then("Librarian enters End Date")
    public void librarian_enters_end_date() {
        usersPage.endDate.clear();
        usersPage.endDate.sendKeys("2023-04-22");
    }

    @Then("Librarian enters Address")
    public void librarian_enters_address() {
        usersPage.txt_address.sendKeys(faker.address().fullAddress());
    }

    @Then("Librarian clicks Save changes")
    public void librarian_clicks_save_changes() {
        usersPage.btn_saveChanges.click();
    }

    @Then("Librarian should see {string}")
    public void librarian_should_see(String expectedMessage) {
        BrowserUtils.waitForVisibility(usersPage.toastMessage,10);
        Assert.assertEquals(expectedMessage, usersPage.toastMessage.getText());
    }


    @Then("Librarian enters fullName {string}")
    public void librarian_enters_full_name(String fullName) {
        usersPage.txt_fullName.sendKeys(fullName);
    }
    @Then("Librarian enters email {string}")
    public void librarian_enters_email(String email) {
        usersPage.txt_email.sendKeys(email);
    }
    @Then("Librarian enters password {string}")
    public void librarian_enters_password(String password) {
        usersPage.txt_password.sendKeys(password);
    }
    @Then("Librarian enters start date {string}")
    public void librarian_enters_start_date(String startDate) {
        usersPage.startDate.sendKeys(startDate);
    }
    @Then("Librarian enters end date {string}")
    public void librarian_enters_end_date(String endDate) {
        usersPage.endDate.sendKeys(endDate);
    }
    @Then("Librarian enters address {string}")
    public void librarian_enters_address(String address) {
        usersPage.txt_address.sendKeys(address);
    }







}
