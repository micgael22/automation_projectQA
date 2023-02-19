package com.ultimateQA.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CollectionAreaP extends BasePageObject {

    private String pageUrl = "https://courses.ultimateqa.com/collections";
    private By message = By.xpath("//*[@id=\"notifications\"]/div/div/div/p");

    public CollectionAreaP(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Get url from PageObject
    public String getPageUrl() {
        return pageUrl;
    }

    //Return Text from success message
    public String getSuccessMessageText(){
        return find(message).getText();
    }
}
