/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class balanceEnquiryPage {

    WebDriver webDriver;
    By accountNumber = By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]");
    By submitButton = By.name("AccSubmit");
    By resetButton = By.name("res");

    public balanceEnquiryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public balanceEnquiryPage(String accountNum) {
        setFieldAccounNumber(accountNum);
        clickSubmitButton();
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setFieldAccounNumber(String strFieldAccountNumber) {
        webDriver.findElement(accountNumber).clear();
        webDriver.findElement(accountNumber).sendKeys(strFieldAccountNumber);
    }

    public void clickSubmitButton() {
        webDriver.findElement(submitButton).click();
    }

    public void clickResetButton() {
        webDriver.findElement(resetButton).click();
    }

}
