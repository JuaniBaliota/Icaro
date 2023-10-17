package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://opencart.abstracta.us/");
    }

    public void clickMyAccount() {
        driver.findElement(By.linkText("My Account")).click();
    }
}