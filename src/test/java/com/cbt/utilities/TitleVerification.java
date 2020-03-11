package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) throws Exception {

        List<String> urls = Arrays.asList(
                "http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        for (String url : urls) {
            driver.get(url);
            System.out.println(url);
            Thread.sleep(2000);

            if(driver.getTitle().equals("Practice") && url.startsWith("http://practice.cybertekschool.com")){
                System.out.println("PASS");
            }else{
                System.out.println("FAILD");
            }

        }

        Thread.sleep(2000);
        driver.quit();

    }
}
