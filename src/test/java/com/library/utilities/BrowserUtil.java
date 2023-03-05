package com.library.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtil {


    /** check title contains an expected string word */
    public static void verifyTitleContains(String expectedTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    /** check actual title equals to the expected title method */
    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());

    }


    /** switch window and verify method
     * */
    public static void switchWindowAndVerify(WebDriver driver, String expectedURL, String expectedTitle) {

        Set<String> handles = driver.getWindowHandles();
        for (String each : handles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().contains(expectedURL)) {
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

    }

    /** sleep method */
    public static void sleep(int seconds) {
        seconds *= 1000;

        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            // do nothing
        }
    }

    /** this method accepts a dropdown element and returns dropdown text as List<String> */
    public static List<String> dropdownOptions_as_STRING(WebElement dropDownElement) {

        Select select = new Select(dropDownElement);
        // list od webElement
        List<WebElement> options = select.getOptions();

        // storing options as a string
        List<String> optionsAsString = new ArrayList<>();

        // iterating over WebElement list and adding it to and array list as a text
        for (WebElement each : options) {
            optionsAsString.add(each.getText());
        }
        return optionsAsString;
    }

    /** this method accepts a list<WebElement> text as List<String> */
    public static List<String> dropdownOptions_as_STRING(List<WebElement> dropDownOptions) {

        // storing options as a string
        List<String> optionsAsString = new ArrayList<>();

        // iterating over WebElement list and adding it to and array list as a text
        for (WebElement each : dropDownOptions) {
            optionsAsString.add(each.getText());
        }
        return optionsAsString;
    }

    /** This will be storing only the methods that can be used across the project */



    /** switching to a window with the expectedURL and verify the title */


    /** verify and check if the actual title matches the expected title */
    public static void verifyTitle(WebDriver driver, String  expectedTitle){

        Assert.assertEquals(expectedTitle,driver.getTitle());

    }

    /** check and verify the actual title if it contains an expected word */
    public static void verifyTitleContains(WebDriver driver, String  expectedInTitle){

        Assert.assertTrue(driver.getTitle().contains(expectedInTitle));

    }

    /** This method accepts List of WebElements and return a String list of webElements texts */
    public static List<String> getMeText(List<WebElement> elements){

        List<String> list = new ArrayList<>();

        for (WebElement element : elements) {
            list.add(element.getText());
        }
        return list;
    }


    /** this method accepts one element and scroll to it */
    public static void scrollToElement(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(element).perform();
    }


    public static void scrollToElement(By by){
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(Driver.getDriver().findElement(by)).perform();
    }

    /** This method does what it says, but it is more powerful than the regular click method
     *  It waits for the visibility of the element, and then it click on it*/
    public static void clickElement(WebElement element){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

    }

    public static void clickElement(By by){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        WebElement element = Driver.getDriver().findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

    }

    /** This method accepts a webElement as an arguments and wait until the condition is true */
    public static void waifForVisibilityOfElement(WebElement element){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    /** This method accepts a webElement as an arguments and wait until the condition is true */
    public static void waifForVisibilityOfElement(By by){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        WebElement element = Driver.getDriver().findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    /** This method accepts a webElement as an argument and hover over it */
    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).pause(2000).perform();
    }



}





















