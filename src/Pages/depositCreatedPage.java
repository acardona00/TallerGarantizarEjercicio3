
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class depositCreatedPage {
    WebDriver webDriver;
    By currentBalance = By.xpath("//*[@id=\"deposit\"]/tbody/tr[23]/td[2]");

    public depositCreatedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentBalance() {
       return webDriver.findElement(currentBalance).getText();
    }
       
    
}
