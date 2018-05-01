/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class WithdrawalPage {

    WebDriver webDriver;
    By accountNumber = By.name("accountno");
    By ammount = By.name("ammount");
    By description = By.name("desc");
    By submitButton = By.name("AccSubmit");
    By resetButton = By.name("res");

    public WithdrawalPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WithdrawalPage(WebDriver webDriver,String accountNumber, String amount, String description) {
        setWebDriver(webDriver);
        setFieldAccounNumber(accountNumber);
        setFieldAmount(amount);
        setFieldDescription(description);
        clickSubmitButton();
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    
    public void setFieldAccounNumber(String strFieldAccountNumber) {
        webDriver.findElement(accountNumber).clear();
        webDriver.findElement(accountNumber).sendKeys(strFieldAccountNumber);
    }

    public void setFieldAmount(String strFieldAmount) {
        webDriver.findElement(ammount).clear();
        webDriver.findElement(ammount).sendKeys(strFieldAmount);
    }

    public void setFieldDescription(String strFieldDescription) {
        webDriver.findElement(description).clear();
        webDriver.findElement(description).sendKeys(strFieldDescription);
    }

    public void clickSubmitButton() {
        webDriver.findElement(submitButton).click();
    }

    public void clickResetButton() {
        webDriver.findElement(resetButton).click();
    }

}
