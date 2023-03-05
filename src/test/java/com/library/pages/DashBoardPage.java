package com.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

// page_url = https://library3.cydeo.com/#dashboard
public class DashBoardPage extends BasePage{
    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement btn_dashboard;

    @FindBy(xpath = "//span[.='Users']")
    public WebElement btn_users;

    @FindBy(xpath = "//span[.='Books']")
    public WebElement btn_books;

    @FindBy(xpath = "//h6")
    public List<WebElement> categories;
    
    


   
    
    
    
}