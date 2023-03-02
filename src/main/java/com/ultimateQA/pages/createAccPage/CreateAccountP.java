package com.ultimateQA.pages.createAccPage;

import com.ultimateQA.pages.BasePageObject;
import com.ultimateQA.pages.CollectionAreaP;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CreateAccountP extends BasePageObject {
    private By userFName = By.id("user[first_name]");
    private By userLName = By.id("user[last_name]");
    private By userEmail = By.id("user[email]");
    private By userPassword = By.id("user[password]");
    private By termsBox = By.id("user[terms]");
    //sign up button
    private By signUpButton = By.xpath("/html/body/main/div/div/article/form/div[6]/button");
    private By errorMessage = By.className("form-error__list-item");

    public CreateAccountP(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public CollectionAreaP signUp (String firstName, String lastName, String email, String password) {
        log.info(" [ Executing Create account: userFirstname = ] [" + firstName + "] " + " userLastname= [" + lastName + "]  userEmail= [" + email + "] " + " userPassword= [" + password + "] ");
        type(firstName, userFName);
        type(lastName, userLName);
        type(email, userEmail);
        type(password, userPassword);
        click(termsBox);
        click(signUpButton);
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
