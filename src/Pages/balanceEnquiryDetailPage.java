/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class balanceEnquiryDetailPage {

    WebDriver webDriver;
    By actualBalance = By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]");
    

    public balanceEnquiryDetailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getActualBalance(){
        return webDriver.findElement(actualBalance).getText();
    }

}
