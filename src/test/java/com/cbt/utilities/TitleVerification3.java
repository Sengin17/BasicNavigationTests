package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com", "https://westelm.com/");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        for (String newUrl : urls) {

            driver.get(newUrl);

            String title = driver.getTitle();

            title = title.replace(" ", "").toLowerCase();

            System.out.println(newUrl + " contains: " + title + "Result : " + newUrl.contains(title));

        }
        driver.close();
    }
}
