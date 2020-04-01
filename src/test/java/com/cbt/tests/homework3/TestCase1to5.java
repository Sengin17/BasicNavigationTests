package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1to5 {

    private WebDriver driver;

    private String URL = "https://practice-cybertekschool.herokuapp.com/";
    private By registrationFormBy = By.linkText("Registration Form");

    private By firstnameBy = By.cssSelector("[name='firstname']");
    private By lastnameBy = By.xpath("//input[@name='lastname']");
    private By usernameBy = By.xpath("//input[@name='username']");
    private By emailBy = By.name("email");
    private By passwordBy = By.xpath("//input[@class='form-control'] [@name='password']");
    private By phoneNumberBy = By.xpath("//input[@type='tel']");
    private By femaleBy = By.cssSelector("[value='female']");
    private By birthdayBy = By.name("birthday");
    private By departmentBy = By.cssSelector("[name='department']");
    private By jobTitleBy = By.cssSelector("[name='job_title']");
    private By cPlusPlusBy = By.id("inlineCheckbox1");
    private By javaBy = By.id("inlineCheckbox2");
    private By javaScriptBy = By.id("inlineCheckbox3");
    private By submitBtnBy = By.id("wooden_spoon");


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(registrationFormBy).click();
        BrowserUtils.wait(2);

    }

    @Test
    public void birthdayVerifyMessageTest(){

        driver.findElement(birthdayBy).sendKeys("wrong_dob");

        WebElement warningDisplayMessage =  driver.findElement(By.xpath("//small[contains(text(), 'The date of birth is not valid')]"));
        Assert.assertTrue(warningDisplayMessage.isDisplayed());
    }

    @Test
    public void languageVerifyTest(){

        WebElement cPlusPlus = driver.findElement(cPlusPlusBy);
        Assert.assertTrue(cPlusPlus.isDisplayed());

        WebElement java = driver.findElement(javaBy);
        Assert.assertTrue(java.isDisplayed());

        WebElement javaScript = driver.findElement(javaScriptBy);
        Assert.assertTrue(javaScript.isDisplayed());

    }
    @Test
    public void firstNameVerifyMessageTest() {

        driver.findElement(firstnameBy).sendKeys("S");

        WebElement warningDisplayMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
                                                            // //small[starts-with(text(),'first name must be more')]
                                                            // // small[@class='help-block' and contains(text(),'first name must be more than 2')]
                                                            // //small[@data-bv-for='firstname'])[2]")
        Assert.assertTrue(warningDisplayMessage.isDisplayed());
    }
    @Test
    public void lastNameVerifyMessageTest() {

        driver.findElement(lastnameBy).sendKeys("E");
        WebElement warningDisplayMessage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningDisplayMessage.isDisplayed());

    }
    @Test
    public void registrationVerifyMessageTest() {

        //first name
        driver.findElement(firstnameBy).sendKeys("Sema");
        //Last name
        driver.findElement(lastnameBy).sendKeys("Engin");
        //user name
        driver.findElement(usernameBy).sendKeys("sengin");
        //email
        driver.findElement(emailBy).sendKeys("sengin@gmail.com");
        //password
        driver.findElement(passwordBy).sendKeys("1qaz2wsx");
        // phone number
        driver.findElement(phoneNumberBy).sendKeys("121-111-3434");
        // gender
        driver.findElement(femaleBy).click();
        // birthday
        driver.findElement(birthdayBy).sendKeys("02/02/1980");
        // department
        Select department = new Select(driver.findElement(departmentBy));
        department.selectByVisibleText("MCR");
        // job title
        Select jobTitle = new Select(driver.findElement(jobTitleBy));
        jobTitle.selectByVisibleText("Developer");
        // programming language
        driver.findElement(javaBy).click();

        driver.findElement(submitBtnBy).click();

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actual, expected);

    }
    @AfterMethod
    public void close(){

        BrowserUtils.wait(2);
        driver.quit();
    }
}
