package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8 {

    private WebDriver driver;
    private String URL= "https://practice-cybertekschool.herokuapp.com";
    private By autocompleteBy = By.linkText( "Autocomplete" );
    private By countryBy = By.id( "myCountry" );
    private By submitBtnBy = By.cssSelector( "[value='Submit']" );

    @BeforeMethod
    public void setup() {

        driver = BrowserFactory.getDriver( "chrome" );
        driver.manage().window().maximize();
        driver.get( URL );
        BrowserUtils.wait( 2 );

    }

    @Test
    public void verifyCountryMessageTest(){

        driver.findElement(autocompleteBy ).click();
        driver.findElement( countryBy ).sendKeys( "United States of America" );
        driver.findElement( submitBtnBy ).click();
        BrowserUtils.wait( 3 );

//        WebElement verifyMessage = driver.findElement(By.id( "result" ));
//        Assert.assertTrue(verifyMessage.isDisplayed());


        String expectedMessage = "You selected: United States of America";
        String actualMessage = driver.findElement(By.id( "result" )).getText();
        Assert.assertEquals( actualMessage, expectedMessage );

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
