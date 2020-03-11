package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.cbt.utilities.StringUtility.verifyEquals;

public class NavigationTests {

    public static void main(String[] args) throws Exception{

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://google.com");
        Thread.sleep(2000);
        String expectedTitleGoogle = "Google";
        verifyEquals(driver.getTitle(), "Google");

        driver.navigate().to("https://etsy.com");
        Thread.sleep(2000);
        String expectedTitleEtsy = "Etsy";
        verifyEquals(driver.getTitle(), "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");

        driver.navigate().back();
        Thread.sleep(2000);
        verifyEquals(driver.getTitle(), "Google");

        driver.quit();
//================================================================================
        WebDriver driver2 = BrowserFactory.getDriver("Safari");
        driver2.get("http://google.com");
        Thread.sleep(2000);
        String expectedTitleGoogle2 = "Google";
        verifyEquals(driver2.getTitle(), "Google");

        driver2.navigate().to("https://etsy.com");
        Thread.sleep(2000);
        String expectedTitleEtsy2 = "Etsy";
        verifyEquals(driver2.getTitle(), "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");

        driver2.navigate().back();
        Thread.sleep(2000);
        verifyEquals(driver2.getTitle(), "Google");

        driver2.quit();

//================================================================================
        WebDriver driver3 = BrowserFactory.getDriver("Firefox");
        driver3.get("http://google.com");
        Thread.sleep(2000);
        String expectedTitleGoogle3 = "Google";
        verifyEquals(driver3.getTitle(), "Google");

        driver3.navigate().to("https://etsy.com");
        Thread.sleep(2000);
        String expectedTitleEtsy3 = "Etsy";
        verifyEquals(driver3.getTitle(), "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");

        driver3.navigate().back();
        Thread.sleep(2000);
        verifyEquals(driver3.getTitle(), "Google");

        driver3.quit();

    }

}
