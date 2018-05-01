/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Pages.homePage;
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
            customerName = "RUBENDARIO",
            gender = "male",
            birth = "1976-01-18",
            address = "Cra 90",
            city = "medallo",
            state = "antioquia",
            pin = "123456",
            mobileNumber = "12345678",
            email = "prueba@garantizar.com",
            password = "prueba";

    LoginPage loginPage;
    homePage homePage;

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
        driver.get(baseUrl + "/computers");

        pageHome.crearComputer();
        pageComputer.crearComputer(nombre, intro, disco, compañia2);
        Thread.sleep(2000);
        String mnsj = pageHome.getMensaje();
        assertEquals(mnsj, "Done! Computer " + nombre + " has been created");
    }

}
