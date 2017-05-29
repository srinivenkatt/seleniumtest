import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Srini on 21-05-2017.
 */
public class Main1 {

    private static WebDriver driver;

    //Configuring the Webdriver
    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "C:/selenium-java-2.35.0/chromedriver_win32_2.2/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.gmail.com");
    }

    @After
    public void close(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogin() throws InterruptedException, IOException {
        Login lg = new Login(driver);

        Mainpage mp = lg.loginTest();
        assertTrue(driver.getTitle().contains("Gmail"));

        //Checking if its the correct User.
        assertTrue(mp.getUserName().equals("Example Test"));

        Newmail nw = mp.sendMail();
        nw.newEmail();

        //Checking if it logs out and displays the login page again with the same user.
        assertTrue(nw.signOut().equals("Hi Example"));

        CheckEmail ce = nw.mailCheck();

        //Checking if the correct email is received that we sent with the subject.
        assertTrue(ce.emailCheck().equals("Email Test"));

        //Checking if the back button takes us back from the message to the inbox.
        assertTrue(ce.backTest().startsWith("Inbox"));

        Cookies ck = new Cookies(driver);

        //Checking if it returns the exact cookie we created.
        assertTrue(ck.addcookies().equals("seleniumtest -> 545431232"));

        //Checking if it return null after deleting the cookie.
        assertNull(ck.deleteCookie());
    }
}
