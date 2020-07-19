package com.animatorjoe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

class Transcriber {
    public static void main(String[] args) throws Exception {
        System.out.println("Let's get ready");

        WebDriver driver = new ChromeDriver();

        try {
            // load page
            driver.get("https://cats.cs61a.org/");

            // enter
            WebElement enter = new WebDriverWait(driver, 5)
                    .until(d -> d.findElement(By.xpath("//button[contains(text(),'Single Player')]")));
            enter.click();

            // read input and write output
            StringBuilder str = new StringBuilder();
            List<WebElement> elements = driver.findElement(By.className("Prompt")).findElements(By.className("Character"));
            for (WebElement e : elements) { str.append(e.getText()); }
            System.out.printf("Typing Input: %s%n", str);

            WebElement outputBox = driver.findElement(By.className("InputField"));
            outputBox.click();
            outputBox.sendKeys(str.toString());

            // celebrate
            System.out.printf("Wow look at you, you typed at %s words per minute.%n", driver.findElement(By.className("Indicator")).getText().split(": ")[1]);
            TimeUnit.SECONDS.sleep(5);
            driver.get("https://youtu.be/6Dh-RL__uN4?t=38");

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            // quit
            TimeUnit.SECONDS.sleep(5);
//            driver.quit();
        }

    }
}