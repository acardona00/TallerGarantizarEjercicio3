/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class accountPage {
    WebDriver webDriver;
    By customerId = By.name("cusid");
    By selectType = By.name("selaccount");
    By initDeposit = By.name("inideposit");
    By btnSubmmit = By.name("button2");
    By btnReset = By.name("reset");

    public accountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setCustomerId(String strCustomerId) {
        webDriver.findElement(customerId).clear();
        webDriver.findElement(customerId).sendKeys(strCustomerId);
    }

    public void setSelectType(String strSelectType) {
        new Select(webDriver.findElement(customerId)).selectByVisibleText(strSelectType);
    }

    public void setInitDeposit(String strInitDeposit) {
        webDriver.findElement(initDeposit).clear();
        webDriver.findElement(initDeposit).sendKeys(strInitDeposit);
    }

    public void setBtnSubmmit() {
        webDriver.findElement(btnSubmmit).click();
    }

    public void setBtnReset() {
        webDriver.findElement(btnReset).click();
    }
    
    
    
    
}
