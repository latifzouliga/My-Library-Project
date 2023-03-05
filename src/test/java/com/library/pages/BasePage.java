package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void navigateTo(String page) {
        WebElement linkToPage = Driver.getDriver().findElement(By.xpath("//span[.='" + page + "']"));
        linkToPage.click();
    }


    @FindBy(xpath = "//span[contains(.,'Librarian')]")
    public WebElement btn_accountName;

    @FindBy(xpath = "//a[.='Log Out']")
    public WebElement btn_logout;







}
