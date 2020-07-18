package com.animatorjoe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Brrr {
    public static void main(String[] args) {
        System.out.println("Let's get ready");

        // load page
        WebDriver driver = new ChromeDriver();
        driver.get("https://cats.cs61a.org/");

    }
}