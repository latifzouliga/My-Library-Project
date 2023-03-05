package com.library.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtils {


    public static void drawBorderOnElement(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'");

    }


    /**
     * This static method accepts one argument as a webElement
     * This method uses javaScript executor to change the background color of a webElement and also it will draw line over it
      * @param element
     */
    public static void drawBorder(WebElement element) {
        //casting webDriver to JavascriptExecutor interface
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('style','background:yellow;3px solid red')", element);
    }



}
