package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By userId = By.name("uid");

    By password = By.name("password");

    By titleText =By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td");

    By login = By.name("btnLogin");

    

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(userId).sendKeys(strUserName);

    }

    

    //Set password in password textbox

    public void setPassword(String strPassword){

         driver.findElement(password).sendKeys(strPassword);

    }

    

    //Click on login button

    public void clickLogin(){

            driver.findElement(login).click();

    }

    public String getLoginTitle(){

     return    driver.findElement(titleText).getText();

    }


    public void login(String strUserName,String strPasword){
        
        this.setUserName(strUserName);
        this.setPassword(strPasword);
        this.clickLogin();        

        

    }

}
