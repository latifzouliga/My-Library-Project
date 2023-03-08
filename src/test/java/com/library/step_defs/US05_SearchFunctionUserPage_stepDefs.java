package com.library.step_defs;

import com.library.pages.UsersPage;
import com.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US05_SearchFunctionUserPage_stepDefs {

    UsersPage usersPage = new UsersPage();

    @When("Librarian search for {string}")
    public void librarian_search_for(String searchValue) {
        usersPage.txt_search.sendKeys(searchValue, Keys.ENTER);
    }

    @Then("table should contain rows with {string}")
    public void table_should_contain_rows_with(String searchValue) {

        BrowserUtils.waitFor(3);

        List<String> fullNames_asString = BrowserUtils.getElementsText(usersPage.fullName);

        BrowserUtils.waitFor(3);

        for (String each : fullNames_asString) {
            Assert.assertTrue(each.contains(searchValue));
        }
    }


    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedUserInfoRow) {

        //List<String> actualUserInfoRow = BrowserUtils.getElementsText(usersPage.userInfoRow);

        List<String> actual = new ArrayList<>();
        for (WebElement each : usersPage.userInfoRow) {
            actual.add(each.getText());
        }

        Assert.assertEquals(expectedUserInfoRow, actual);


    }


}











