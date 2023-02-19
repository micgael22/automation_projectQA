package com.ultimateQA.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class UserSignInP extends BasePageObject {

    //User email input
    private By userEmail = By.id("user[email]");
    //User password input
    private By userPassword = By.id("user[password]");
    //Tick remember checkbox
    private By rememberCheckbox = By.id("user[remember_me]");
    //sign up button
    private By signInButton = By.xpath("/html/body/main/div/div/article/form/div[5]/button");
    //error message
    private By errorMessage = By.xpath("//*[@id=\"notice\"]/ul/li");


    public UserSignInP(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Execute Sign in page
    public CollectionAreaP signIn (String email, String password) {
        log.info(" [ Executing SignIn details with userFirstname = ] [" + email + "]  userPassword= [" + password + "]");
        type(email, userEmail);
        type(password, userPassword);
        click(signInButton);
        return new CollectionAreaP(driver, log);
    }

    //Wait for error message to be visible on the page
    public void waitForErrorMessage() {
        waitForVisibilityOf(errorMessage, Duration.ofSeconds(10));
    }

    public String getErrorMessageText() {
        return find(errorMessage).getText();
    }

}
