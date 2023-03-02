package com.ultimateQA.pages.createAccPage;

import com.ultimateQA.pages.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpAutoP extends BasePageObject {

    private String pageUrlSign = "https://courses.ultimateqa.com/users/sign_in";
    private By createAccLink = new By.ByLinkText("Create a new account");

    public SignUpAutoP(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openSignUp() {
        log.info(" [ Opening Page ]" + pageUrlSign);
        openUrl(pageUrlSign);
        log.info("Page opened!");
    }

    //Clicking on Create Account Link
    public CreateAccountP createAccLink() {
        log.info(" [ Clicking on Create Account Link ] ");
        click(createAccLink);
        return new CreateAccountP(driver, log);
    }
}
