package com.ultimateQA.tests.testCases.signIn;

import com.ultimateQA.base.TestUtilities;
import com.ultimateQA.pages.CollectionAreaP;
import com.ultimateQA.pages.createAccPage.CreateAccountP;
import com.ultimateQA.pages.HomeAutoP;
import com.ultimateQA.pages.UserSignInP;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccTest extends TestUtilities {

    @Test
    public void createAccTest() throws InterruptedException {

        log.info(" [ STARTING OF SIGN UP TEST ] ");

        // open main page
        HomeAutoP homeAutoP = new HomeAutoP(driver, log);
        homeAutoP.openHomePage();

        // Click on signIn link
        UserSignInP userSignInP = homeAutoP.loginLink();

        //Scroll to the bottom
        sleep(5000);
        homeAutoP.scrollToBottom();
        sleep(5000);

        //click on Create a SignIn link
        CreateAccountP createAccountP = homeAutoP.createAccLink();

        //Scroll to the bottom
        sleep(2000);
        homeAutoP.scrollToBottom();
        sleep(2000);

        //execute sign in
        CollectionAreaP collectionAreaP = createAccountP.signUp("Nave", "Green",
                        "green@gmail.com", "navveed00");

        // verifications
        // new page url is expected
        Assert.assertEquals(collectionAreaP.getCurrentUrl(), collectionAreaP.getUserPUrl());

        sleep(2000);

        // Successful log in message
//        String expectedSuccessMessage = "Signed in successfully.";
//        String actualSuccessMessage = collectionAreaP.getSuccessMessageText();
//        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
//                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
//                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

        log.info(" [ END OF SIGN UP TEST ] ");
    }
}
