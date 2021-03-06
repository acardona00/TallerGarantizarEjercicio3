/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Pages.WithdrawalPage;
import Pages.WithdrawalSubstractPage;
import Pages.accountCreatedPage;
import Pages.accountPage;
import Pages.balanceEnquiryPage;
import Pages.customerCreatedPage;
import Pages.depositCreatedPage;
import Pages.depositPage;
import Pages.homePage;
import Pages.newCustomerPage;
import java.util.Random;
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
            email = "prueba@finalsi.com",
            password = "prueba",
            initDeposit = "1000",
            accountId1 = "",
            accountId2 = "",
            amount = "200",
            substractAmount = "100",
            description = "Hi world",
            actualAmount = "";

    LoginPage loginPage;
    homePage homePage;
    newCustomerPage newCustomerPage;
    customerCreatedPage customerCratedPage;
    accountPage accountPage;
    accountCreatedPage accountCreatedPage;
    depositPage depositPage;
    depositCreatedPage depositCreatedPage;
    balanceEnquiryPage balanceEnquiryPage;
    WithdrawalPage withdrawalPage;
    WithdrawalSubstractPage withdrawalSubstractPage;

    private WebDriver webDriver;
    private final String baseUrl = "http://demo.guru99.com/V4/";

    public SeleniumTest() {
    }

    //Genera string aleatorio para crear nuevos customers
    public static String RandomEmail() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
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
        depositCreatedPage = new depositCreatedPage(webDriver);
        accountCreatedPage = new accountCreatedPage(webDriver);
        withdrawalSubstractPage = new WithdrawalSubstractPage(webDriver);
        this.email = RandomEmail() + "@gmail.com";


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
        newCustomerPage = new newCustomerPage(webDriver, customerName, gender, birth,
                address, city, state, pin, mobileNumber, email, password);
        Thread.sleep(2000);
        String mnsj = customerCratedPage.getTitle();
        customerId = customerCratedPage.getCustomerId();
        assertEquals(mnsj, "Customer Registered Successfully!!!");
    }

    @Test
    public void testCreateAccount() throws InterruptedException {
        webDriver.get(baseUrl + "/index.php");
        loginPage.login(userId, logPassword);
        homePage.clickOnNewCustomer();
        newCustomerPage = new newCustomerPage(webDriver, customerName, gender, birth,
                address, city, state, pin, mobileNumber, email, password);
        Thread.sleep(2000);
        customerId = customerCratedPage.getCustomerId();
        homePage.clickOnNewAccount();
        accountPage = new accountPage(webDriver, customerId, initDeposit);
        accountId1 = accountCreatedPage.getAccountId();
        String mnsj = accountCreatedPage.getTitle();
        assertEquals(mnsj, "Account Generated Successfully!!!");
    }

    /*Caso de prueba 1: Verificar que al realizar deposito (opción Deposit), el campo “Amount” sea
     obligatorio.*/
    @Test
    public void testValidateDepositAmount() throws InterruptedException {
        webDriver.get(baseUrl + "/index.php");
        loginPage.login(userId, logPassword);
        homePage.clickOnDeposit();
        depositPage = new depositPage(webDriver, "41017", "", description);
        String alert = depositPage.getAlertLabel();
        assertEquals(alert, "Please fill all fields");
    }

    /*Caso de prueba 2: Verificar que al realizar un deposito (opción Deposit), el saldo de la cuenta si se
     actualice con el nuevo valor. Para ello, debe crear un customer, luego una account.*/
    @Test
    public void testDepositUpdate() throws InterruptedException {
        webDriver.get(baseUrl + "/index.php");
        loginPage.login(userId, logPassword);
        homePage.clickOnNewCustomer();
        newCustomerPage = new newCustomerPage(webDriver, customerName, gender, birth,
                address, city, state, pin, mobileNumber, email, password);
        Thread.sleep(2000);
        customerId = customerCratedPage.getCustomerId();
        homePage.clickOnNewAccount();
        accountPage = new accountPage(webDriver, customerId, initDeposit);
        accountId1 = accountCreatedPage.getAccountId();
        homePage.clickOnDeposit();
        depositPage = new depositPage(webDriver, accountId1, amount, description);
        Thread.sleep(2000);
        int currentBalance = Integer.parseInt(depositCreatedPage.getCurrentBalance());
        assertEquals(currentBalance, Integer.parseInt(amount) + Integer.parseInt(initDeposit));
    }

    /*Caso de prueba 3: Verificar que al realizar un retiro (opción Withdrawal), el saldo de la cuenta sea
     afectado.*/
    @Test
    public void testSubstractActualAmount() throws InterruptedException {
        webDriver.get(baseUrl + "/index.php");
        loginPage.login(userId, logPassword);
        homePage.clickOnNewCustomer();
        newCustomerPage = new newCustomerPage(webDriver, customerName, gender, birth,
                address, city, state, pin, mobileNumber, email, password);
        Thread.sleep(2000);
        customerId = customerCratedPage.getCustomerId();
        homePage.clickOnNewAccount();
        accountPage = new accountPage(webDriver, customerId, initDeposit);
        accountId1 = accountCreatedPage.getAccountId();
        Thread.sleep(2000);
        homePage.clickOnNewAccount();
        accountPage = new accountPage(webDriver, customerId, initDeposit);
        accountId2 = accountCreatedPage.getAccountId();
        Thread.sleep(2000);
        System.out.println(accountId2);
        homePage.clickOnWithdrawal();
        withdrawalPage = new WithdrawalPage(webDriver, accountId2, substractAmount, description);
        Thread.sleep(2000);
        int currentBalance = Integer.parseInt(withdrawalSubstractPage.getCurrentBalance());
        assertEquals(currentBalance, Integer.parseInt(initDeposit) - Integer.parseInt(substractAmount));
    }

}
