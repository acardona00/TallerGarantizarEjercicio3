
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

    public newCustomerPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setFieldCustomerName(String strFieldCustomerName) {
        webDriver.findElement(fieldCustomerName).clear();
        webDriver.findElement(fieldCustomerName).sendKeys(strFieldCustomerName);
    }

    public void setCheckbox(String strCheckbox) {
        if (strCheckbox.equalsIgnoreCase("male")) {
            webDriver.findElement(checkboxMale).click();
        } else {
            webDriver.findElement(checkboxFemale).click();
        }
    }


    public void setDateBirth(String strDateBirth) {
        webDriver.findElement(dateBirth).clear();
        webDriver.findElement(dateBirth).sendKeys(strDateBirth);
    }

    public void setTextAddress(String strtextAddress) {
        webDriver.findElement(textAddress).clear();
        webDriver.findElement(textAddress).sendKeys(strtextAddress);
    }

    public void setFieldCity(String strFieldCity) {
        webDriver.findElement(fieldCity).clear();
        webDriver.findElement(fieldCity).sendKeys(strFieldCity);
    }

    public void setFieldState(String strFieldState) {
        webDriver.findElement(fieldState).clear();
        webDriver.findElement(fieldState).sendKeys(strFieldState);
    }

    public void setFieldPin(String strFieldPin) {
        webDriver.findElement(fieldPin).clear();
        webDriver.findElement(fieldPin).sendKeys(strFieldPin);
    }

    public void setFieldTelephone(String strFieldTelephone) {
        webDriver.findElement(fieldTelephone).clear();
        webDriver.findElement(fieldTelephone).sendKeys(strFieldTelephone);
    }

    public void setFieldEmail(String strFieldEmail) {
        webDriver.findElement(fieldEmail).clear();
        webDriver.findElement(fieldEmail).sendKeys(strFieldEmail);
    }

    public void setFieldPassword(String strFieldPassword) {
        webDriver.findElement(fieldPassword).clear();
        webDriver.findElement(fieldPassword).sendKeys(strFieldPassword);
    }

    public void setBtnSubmmit() {
        webDriver.findElement(btnSubmmit).click();
    }

    public void setBtnReset() {
        webDriver.findElement(btnReset).click();
    }
    
    
}
