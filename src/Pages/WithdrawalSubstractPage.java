/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawalSubstractPage {

    WebDriver webDriver;
    By currentBalance = By.xpath("//*[@id=\"withdraw\"]/tbody/tr[23]/td[2]");

    public WithdrawalSubstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

       public String getCurrentBalance() {
        return webDriver.findElement(currentBalance).getText();
    }

}
