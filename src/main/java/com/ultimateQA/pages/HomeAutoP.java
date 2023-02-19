package com.ultimateQA.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeAutoP extends BasePageObject{

    private String pageUrl = "https://ultimateqa.com/automation";
    private By loginLink = new By.ByLinkText("Login automation");

    public HomeAutoP(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openHomePage() {
        log.info(" [ Opening Page: ]" + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    //Open LoginPage by Clicking on Form Authentication Link
    public UserSignInP loginLink() {
        log.info(" [ Clicking on LogIn link on Automation Page: ] ");
        click(loginLink);
        return new UserSignInP(driver, log);
    }



}
