
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author acard
 */
public class homePage {
    
    WebDriver webDriver;
    By optionNewCustomer = By.xpath("/html/body/div[3]/div/ul/li[2]/a");
    By optionNewAccount = By.xpath("/html/body/div[3]/div/ul/li[5]/a");
    By optionDeposit = By.xpath("/html/body/div[3]/div/ul/li[8]/a");

    public homePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    
    public void setDriver(WebDriver driver) {
        this.webDriver = driver;
    }
    
    public void clickOnNewCustomer(){
        
        webDriver.findElement(optionDeposit).click();
    }
    
    public void clickOnNewAccount(){
        
        webDriver.findElement(optionNewAccount).click();
    }
    
    public void clickOnDeposit(){
        
        webDriver.findElement(optionDeposit).click();
    }
    
    
}
