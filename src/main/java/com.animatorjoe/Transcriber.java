package com.animatorjoe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

class Transcriber {
    public static void main(String[] args) throws Exception {
        System.out.println("Let's get ready");

        WebDriver driver = new ChromeDriver();;

        try {
            // load page
            driver.get("https://cats.cs61a.org/");

            // enter
            WebElement enter = new WebDriverWait(driver, 5)
                    .until(d -> d.findElement(By.xpath("//button[contains(text(),'Single Player')]")));
            enter.click();



        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            // quit
            TimeUnit.SECONDS.sleep(2);
            driver.quit();
        }

    }
}