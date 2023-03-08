package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UsersPage extends BasePage {


    @FindBy(xpath = "//h3[.='User Management']")
    public WebElement txt_header;

    @FindBy(xpath = "//i[@class='fa fa-plus']/..")
    public WebElement btn_adduser;

    @FindBy(xpath = "//h5[.='Add User']")
    public WebElement header_addUser;

    @FindBy(name = "full_name")
    public WebElement txt_fullName;

    @FindBy(name = "email")
    public WebElement txt_email;

    @FindBy(name = "password")
    public WebElement txt_password;

    @FindBy(name = "start_date")
    public WebElement startDate;

    @FindBy(name = "end_date")
    public WebElement endDate;

    @FindBy(name = "address")
    public WebElement txt_address;

    @FindBy(xpath = "//button[.='Save changes']")
    public WebElement btn_saveChanges;

    @FindBy(xpath = "//button[.='Close']")
    public WebElement btn_close;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement toastMessage;

    @FindBy(xpath = "//th[@colspan='6']")
    public WebElement btn_monthYear;

    // date arrow (next)
    // (//i[@class='fa fa-angle-right'])[3]
    @FindBy(xpath = "//select[@name='tbl_users_length']")
    public WebElement showRecords;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> records;

    @FindBy(xpath = "//div[@id='tbl_users_filter']//input")
    public WebElement txt_search;

    @FindBy(xpath = "//td[3]")
    public List<WebElement> fullName;

    @FindBy(xpath = "//tr/th")
    public List<WebElement> userInfoRow;


    public void showRecords(String records){
        WebElement element = Driver.getDriver().findElement(By.xpath("//select[@name='tbl_users_length']"));
        Select select = new Select(element);
        select.selectByVisibleText(records);

    }


    public void dayOfMonth(String day){
        String element = "//td[.='"+day+"']";
        Driver.getDriver().findElement(By.xpath(element)).click();
    }



}
