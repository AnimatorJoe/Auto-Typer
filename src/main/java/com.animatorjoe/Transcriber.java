package com.animatorjoe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

class Transcriber {
    public static void main(String[] args) {
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
            String str = "";
            List<WebElement> elements = driver.findElement(By.className("Prompt")).findElements(By.className("Character"));
            for (WebElement e : elements) { str += e.getText(); }
            str = str.trim();
            System.out.printf("Typing Input: %s%n%n", str);

            WebElement outputBox = driver.findElement(By.className("InputField"));
            outputBox.click();
            String[] strList = str.split(" ");
            for (String s : strList) {
                TimeUnit.MILLISECONDS.sleep(5);
                outputBox.sendKeys(s + "  ");
            }

            System.out.printf("Wow look at you, you typed at %s words per minute.%n", driver.findElement(By.className("Indicator")).getText().split(": ")[1]);

            // enter captcha challenge
            WebElement enterChallenge = new WebDriverWait(driver, 8)
                    .until(d -> d.findElement(By.xpath("//button[contains(text(),'Request Challenge')]")));
            enterChallenge.click();

            // solve captcha
            WebElement captchaImages =  new WebDriverWait(driver, 8)
                    .until(d -> d.findElement(By.className("images")));
            List<WebElement> images = captchaImages.findElements(By.tagName("img"));

            System.out.println("Found captcha images");
            System.out.println(images);
            for (WebElement img : images) {
                System.out.println(img.getAttribute("src"));
            }

            // completion
//            TimeUnit.SECONDS.sleep(3);
//            ((JavascriptExecutor)driver).executeScript("window.open(\"https://youtu.be/6Dh-RL__uN4?t=38\")");
            TimeUnit.SECONDS.sleep(30);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
//            driver.quit();
        }
    }
}