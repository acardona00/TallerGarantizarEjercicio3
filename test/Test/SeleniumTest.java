/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Pages.accountCreatedPage;
import Pages.accountPage;
import Pages.customerCreatedPage;
import Pages.depositPage;
import Pages.homePage;
import Pages.newCustomerPage;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

/**
 *
 * @author acard
 */
public class SeleniumTest {

    String userId = "mngr130026",
            logPassword = "duqabuq",
            customerId = "",
            customerName = "RUBENDARIO",
            gender = "male",
            birth = "76-01-18",
            address = "Cra 90",
            city = "medallo",
            state = "antioquia",
            pin = "123456",
            mobileNumber = "12345678",
            email = "prueba@poli.com",
            password = "prueba",
            
            initDeposit = "500",
            
            accountId="",
            
            amount="200",
            description="Hi world",
            actualAmount="";

    LoginPage loginPage;
    homePage homePage;
    newCustomerPage newCustomerPage;
    customerCreatedPage customerCratedPage;
    accountPage accountPage;
    accountCreatedPage accountCreatedPage;
    depositPage depositPage;

    private WebDriver webDriver;
    private String baseUrl = "http://demo.guru99.com/V4/";

    public SeleniumTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new homePage(webDriver);
        customerCratedPage = new customerCreatedPage(webDriver);
        
  
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void testLogin() throws InterruptedException {
        webDriver.get(baseUrl + "/index.php");
        loginPage.login(userId, logPassword);
        Thread.sleep(2000);
        String mnsj = loginPage.getLoginTitle();
        assertEquals(mnsj, "Manger Id : " + userId);
    }
    
    @Test
	  public void testCreateCustomer() throws InterruptedException {
	    webDriver.get(baseUrl + "/index.php");
            loginPage.login(userId, logPassword);
            homePage.clickOnNewCustomer();
            newCustomerPage = new newCustomerPage(webDriver, customerName,gender,birth,
                address,city,state,pin,mobileNumber,email,password);
            Thread.sleep(2000);
            String mnsj =  customerCratedPage.getTitle();
            customerId = customerCratedPage.getCustomerId();
            assertEquals(mnsj, "Customer Registered Successfully!!!");   
	  }
          
    @Test
	  public void testCreateAccount() throws InterruptedException {
	    webDriver.get(baseUrl + "/index.php");
            loginPage.login(userId, logPassword);
            homePage.clickOnNewCustomer();
            newCustomerPage = new newCustomerPage(webDriver, customerName,gender,birth,
                address,city,state,pin,mobileNumber,email,password);
            Thread.sleep(2000);
            customerId = customerCratedPage.getCustomerId();
            homePage.clickOnNewAccount();
            accountPage = new accountPage(webDriver, customerId, initDeposit);
            accountId = accountCreatedPage.getAccountId();
            String mnsj =  accountCreatedPage.getTitle();
            assertEquals(mnsj, "Account Generated Successfully!!!");   
	  }
          
          public void testValidateDepositAmount() throws InterruptedException {
	    webDriver.get(baseUrl + "/index.php");
            homePage.clickOnDeposit();
            depositPage = new depositPage(webDriver,accountId,"",description);
            Thread.sleep(2000);
            customerId = customerCratedPage.getCustomerId();
            homePage.clickOnNewAccount();
            accountPage = new accountPage(webDriver, customerId, initDeposit);
            accountId = accountCreatedPage.getAccountId();
            String mnsj =  accountCreatedPage.getTitle();
            assertEquals(mnsj, "Account Generated Successfully!!!");   
	  }
          
    

    
}
