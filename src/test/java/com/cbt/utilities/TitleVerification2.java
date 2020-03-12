package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;
import static com.cbt.utilities.StringUtility.verifyEquals;

public class TitleVerification2 {
    public static void main(String[] args) throws Exception{

        List<String> urls = Arrays.asList(
                "https://lulugandgeorgia.com",
                "https://wayfair.com/",
                "https://walmart.com",
                "https://westelm.com/");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        for (int i = 0; i < urls.size(); i++) {

            driver.get(urls.get(i));

            String title = driver.getTitle().toLowerCase().replace(" ","");

            if (urls.get(i).contains(title)) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }

        }
        Thread.sleep(2000);
        driver.close();
    }
}
