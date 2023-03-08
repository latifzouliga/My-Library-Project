package com.library.step_defs;

import com.library.pages.LoginPage;
import com.library.pages.UsersPage;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;


public class US03_ManageUserInfoTable {
    LoginPage login = new LoginPage();
    UsersPage usersPage = new UsersPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Given("user login as a librarian")
    public void user_login_as_a_librarian() {
        login.loginAsLibrarian();
    }

    @Given("user click on {string} link")
    public void user_click_on_link(String usersLink) {
        login.navigateTo(usersLink);
    }

    @When("user select Show {int} records")
    public void user_select_show_records(Integer numberOfRecords) {
        String records = String.valueOf(numberOfRecords);
        usersPage.showRecords(records);
    }

    @Then("show records value should be {int}")
    public void show_records_value_should_be(Integer recordValue) {

        Select select = new Select(usersPage.showRecords);
        String actualRecordsValue = select.getFirstSelectedOption().getText();
        String expectedRecordValue = String.valueOf(recordValue);

        Assert.assertEquals(expectedRecordValue, actualRecordsValue);
    }

    @Then("the users table must display {int} records")
    public void the_users_table_must_display_records(Integer expectedRecordsTotal) {

        List<WebElement> actualRecords = usersPage.records;
        Integer actualRecordsTotal = actualRecords.size();
        Assert.assertEquals(expectedRecordsTotal, actualRecordsTotal);

    }
}
