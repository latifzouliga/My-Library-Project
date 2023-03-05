package com.library.pages;

import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(id = "inputEmail")
    public WebElement txt_username;

    @FindBy(id = "inputPassword")
    public WebElement txt_password;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement btn_signIn;


    public void loginAsStudent() {
        txt_username.sendKeys(ConfigurationReader.getProperty("studentUsername1"));
        txt_password.sendKeys(ConfigurationReader.getProperty("studentPassword"));
        btn_signIn.click();
    }


    public void loginAsLibrarian() {
        txt_username.sendKeys(ConfigurationReader.getProperty("librarianUsername1"));
        txt_password.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
        btn_signIn.click();
    }





}
