
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class accountCreatedPage {
    
    WebDriver webDriver;
    By accountId =  By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]");
    
    By title = By.className("heading3");

    public accountCreatedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getAccountId() {
        return webDriver.findElement(accountId).getText();
    }
    
    public String getTitle(){
    
    return webDriver.findElement(title).getText();
    }

   
    
    
}
