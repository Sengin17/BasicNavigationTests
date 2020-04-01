package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 {

    private WebDriver driver;
    private String URLTempMail = "https://www.tempmailaddress.com/";
    private String URLCyberTek = "https://practice-cybertekschool.herokuapp.com";
    private By signUpLinkBy = By.linkText( "Sign Up For Mailing List" );
    private By emailTempBy = By.id( "email" );
    private By fullnameBy = By.cssSelector( "[type='text']" );
    private By emailCyberBy = By.cssSelector( "[type='email']" );
    private By signUpBtn = By.cssSelector( "[name='wooden_spoon']" );
    private By signUpMessageBy = By.cssSelector( "[name='signup_message']" );
    private By receivedMailBy = By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]");





    @BeforeMethod
    public void setup() {

        driver = BrowserFactory.getDriver( "chrome" );
        driver.manage().window().maximize();
        driver.get( URLTempMail );
        BrowserUtils.wait( 2 );

    }

    @Test
    public void testCase6(){

        String email = driver.findElement( emailTempBy ).getText();

        driver.navigate().to( URLCyberTek );
        driver.findElement(signUpLinkBy).click();
        BrowserUtils.wait( 2 );
        driver.findElement( fullnameBy ).sendKeys( "DenDen" );
        driver.findElement( emailCyberBy ).sendKeys( email );
        BrowserUtils.wait( 2 );
        driver.findElement( signUpBtn ).click();

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(signUpMessageBy ).getText();
        Assert.assertEquals( actual, expected );

        BrowserUtils.wait( 3 );
        driver.navigate().to( URLTempMail );

        WebElement displayMessage = driver.findElement(receivedMailBy);
        Assert.assertTrue(displayMessage.isDisplayed());

        BrowserUtils.wait( 3 );

         driver.findElement( receivedMailBy ).click();
         String expectedFromMessage = "do-not-reply@practice.cybertekschool.com";
         String actualFromMessage = driver.findElement( By.id("odesilatel") ).getText();
         Assert.assertEquals( actualFromMessage, expectedFromMessage );

         BrowserUtils.wait( 3 );

         String expectedSubjectMessage = "Thanks for subscribing to practice.cybertekschool.com!";
         String actualSubjectMessage = driver.findElement( By.id("predmet") ).getText();
         Assert.assertEquals( actualSubjectMessage, expectedSubjectMessage );

    }

    @AfterMethod
    public void close() {

        BrowserUtils.wait( 3 );

        if (driver != null) {

            driver.quit();

            driver = null;
        }
    }
}