package com.ultimateQA.tests.testCases.signIn;

import com.ultimateQA.base.TestUtilities;
import com.ultimateQA.pages.CollectionAreaP;
import com.ultimateQA.pages.HomeAutoP;
import com.ultimateQA.pages.UserSignInP;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignInTest extends TestUtilities {

    @Test
    public void signInTest() throws InterruptedException {

        log.info(" [ STARTING SIGN IN TEST ] ");

        // open main page
        HomeAutoP homeAutoP = new HomeAutoP(driver, log);
        homeAutoP.openHomePage();
        takeScreenshot("WelcomePage opened");

        // Click on signIn link
        UserSignInP userSignInP = homeAutoP.loginLink();
        takeScreenshot("SignInPage opened");
        //Get cookies
//        String username = sCollectionAreaPage.getCookie("username");
//        log.info("Username cookie: " + username);
//        String session = sCollectionAreaPage.getCookie("rack.session");
//        log.info("Session cookie: " + session);

        // Add new cookie
        //Cookie ck = new Cookie("username", "tom", "pageUrl", "/", null);
        //loginP.setCookie(ck);

        //execute sign in
        CollectionAreaP collectionAreaP = userSignInP.signIn("fisherjack@gmail.com","demo123_");
        takeScreenshot("SignIn opened");


        // verifications
        // new page url is expected
        Assert.assertEquals(collectionAreaP.getCurrentUrl(), collectionAreaP.getPageUrl());

        // log out button is visible
        //Assert.assertTrue(sCollectionAreaPage.isLogOutButtonVisible(), "LogOut Button is not Visible");

        // Successful log in message
        String expectedSuccessMessage = "Signed in successfully.";
        String actualSuccessMessage = collectionAreaP.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }
}
