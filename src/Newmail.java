import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

/**
 * Created by Srini on 28-05-2017.
 */
public class Newmail {

    static WebDriver driver;
    static Wait<WebDriver> wait;

    public Newmail(WebDriver driver) {
        this.driver = driver;
    }

    public void newEmail() throws InterruptedException, IOException {

        // We compose a new mail and send it to ourself.
        driver.findElement(By.xpath("//div[contains(@class, 'T-I J-J5-Ji T-I-KE L3')]")).click();

        //Using explicit wait for the compose window to open with the following textbox.
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[contains(@class, 'vO')]")));
        driver.findElement(By.xpath("//textarea[contains(@class, 'vO')]")).sendKeys("seleniumtestsrini@gmail.com");

        driver.findElement(By.xpath("//input[contains(@class, 'aoT')]")).sendKeys("Email Test");
        driver.findElement(By.xpath("//div[contains(@class, 'Am Al editable LW-avf')]")).sendKeys("Hello, this is a test Email from Srini");
        driver.findElement(By.xpath("//div[contains(@class, 'T-I J-J5-Ji aoO T-I-atl L3')]")).click();
    }

    public String signOut() throws InterruptedException {

        //Pause the execution for 5 seconds to wait for the mail to get delivered.
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@class='gb_8a gbii']")).click();
        driver.findElement(By.xpath("//a[@class='gb_Fa gb_pf gb_wf gb_xb']")).click();
        String user = driver.findElement(By.xpath("//h1[contains(@class, 'sfYUmb')]")).getText();
        return user;
    }

    //We send the driver(after sending the email) to the CheckEmail class for verifying if the mail is received.
    public CheckEmail mailCheck() {
        return new CheckEmail(driver);
    }
}
