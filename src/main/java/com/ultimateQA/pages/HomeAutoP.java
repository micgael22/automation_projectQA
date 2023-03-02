package com.ultimateQA.pages;

import com.ultimateQA.pages.createAccPage.CreateAccountP;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeAutoP extends BasePageObject{

    private String pageUrl = "https://ultimateqa.com/automation";
    private By loginLink = new By.ByLinkText("Login automation");
    private By createAccLink = new By.ByXPath("/html/body/main/div/div/aside/a");

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
        log.info(" [ Clicking on LogIn link on Automation Page ] ");
        click(loginLink);
        return new UserSignInP(driver, log);
    }

    //Clicking on Create Account Link
    public CreateAccountP createAccLink() {
        log.info(" [ Clicking on Create Account Link ] ");
        click(createAccLink);
        return new CreateAccountP(driver, log);
    }

}
