/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public final class depositPage {
    WebDriver webDriver;
    By fieldAccountNumber = By.name("accountno");
    By fieldAmount = By.name("ammount");
    By fieldDescription = By.name("desc");
    By btnSubmmit = By.name("AccSubmit");
    By btnReset = By.name("res");
    By alertLabel = By.id("message1");

    public depositPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    
    public depositPage(WebDriver webDriver,String accountNum,String amount,String description) {
        setWebDriver(webDriver);
        setFieldAccountNumber(accountNum);
        setFieldAmmount(amount);
        setFieldDescription(description);
        setBtnSubmmit();
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setFieldAccountNumber(String strFieldAccountNumber) {
        webDriver.findElement(fieldAccountNumber).clear();
        webDriver.findElement(fieldAccountNumber).sendKeys(strFieldAccountNumber);
    }

    public void setFieldAmmount(String strFieldAmmount) {
        webDriver.findElement(fieldAmount).clear();
        webDriver.findElement(fieldAmount).sendKeys(strFieldAmmount);
    }

    public void setFieldDescription(String strFieldDescription) {
        webDriver.findElement(fieldDescription).clear();
        webDriver.findElement(fieldDescription).sendKeys(strFieldDescription);
    }

    public void setBtnSubmmit() {
        webDriver.findElement(btnSubmmit).click();
    }

    public void setBtnReset() {
        webDriver.findElement(btnReset).click();
    }

    public String getAlertLabel() {
        return webDriver.switchTo().alert().getText();
    }
    
    
}
