/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class customerCreatedPage {
    
    WebDriver webDriver;
    By customerId =  By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]");
    By title = By.className("heading3");

    public customerCreatedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCustomerId() {
        return webDriver.findElement(customerId).getText();
    }
    
    public String getTitle(){
    
    return webDriver.findElement(title).getText();
    }

   
    
    
}
