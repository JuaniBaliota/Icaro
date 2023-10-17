package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRegistrationForm(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);
    }

    public void agreePrivacyPolicy() {
        driver.findElement(By.name("agree")).click();
    }

    public void clickContinue() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}