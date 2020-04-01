package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7 {
    private WebDriver driver;
    private String URL= "https://practice-cybertekschool.herokuapp.com";
    private By fileUploadLinkBy = By.linkText( "File Upload" );

    @BeforeMethod
    public void setup() {

        driver = BrowserFactory.getDriver( "chrome" );
        driver.manage().window().maximize();
        driver.get( URL );
        BrowserUtils.wait( 2 );

    }

    @Test
    public void uploadFileTest(){

        driver.findElement( fileUploadLinkBy ).click();
        WebElement uploadFile = driver.findElement(By.id("file-upload"));
        String filePath = System.getProperty("/Users/semaengin/Desktop")+"Not.docx";
        BrowserUtils.wait( 3 );
        uploadFile.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

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
