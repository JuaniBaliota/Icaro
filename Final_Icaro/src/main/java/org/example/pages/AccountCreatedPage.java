package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountCreatedPage {
    private final WebDriverWait wait;

    public AccountCreatedPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getSuccessMessage() {
        WebElement successMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("content")));
        wait.until(ExpectedConditions.visibilityOf(successMessageElement));
        return successMessageElement.getText();
    }
}