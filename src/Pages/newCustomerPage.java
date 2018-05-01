
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class newCustomerPage {
    
    WebDriver webDriver;
    By fieldCustomerName = By.name("name");
    By checkboxMale = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]");
    By checkboxFemale = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]");
    By dateBirth = By.name("dob");
    By textAddress= By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea");
    By fieldCity = By.name("city");
    By fieldState = By.name("state");
    By fieldPin = By.name("pinno");
    By fieldTelephone = By.name("telephoneno");
    By fieldEmail = By.name("emailid");
    By fieldPassword = By.name("password");
    By btnSubmmit = By.name("sub");
    By btnReset = By.name("res");
    
}
