package com.library.step_defs;

import com.library.pages.LoginPage;
import com.library.pages.UsersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US04_ShowRecordsOptions {

    LoginPage login = new LoginPage();
    UsersPage usersPage = new UsersPage();


    @Given("Librarian click on {string} link")
    public void librarian_click_on_link(String usersLink) {
        usersPage.navigateTo(usersLink);
    }

    @When("Librarian select Show {int} records")
    public void librarian_select_show_records(Integer recordsCount) {
        String recordsCountAsString = String.valueOf(recordsCount);
        usersPage.showRecords(recordsCountAsString);
    }

    @Then("show records value needs to be {int}")
    public void show_records_value_needs_to_be(Integer recordsCount) {
        String expectedRecordsCount = String.valueOf(recordsCount);
        Select select = new Select(usersPage.showRecords);
        String actualRecordsCount = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedRecordsCount, actualRecordsCount);
    }

    @Then("users table must display {int} records")
    public void users_table_must_display_records(Integer expectedTotalRecords) {
        List<WebElement> records = usersPage.records;
        Integer actualTotalRecords = records.size();

        Assert.assertEquals(expectedTotalRecords, actualTotalRecords);
    }
}
