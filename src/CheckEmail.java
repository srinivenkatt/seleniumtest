import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Srini on 28-05-2017.
 */
public class CheckEmail {

    WebDriver driver;

    public CheckEmail(WebDriver driver) {
        this.driver = driver;
    }

    public String emailCheck() {

        //We login again and verify if the message has been received.
        driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys("seleniumtest12345");
        driver.findElement(By.cssSelector("#passwordNext > content")).click();
        driver.findElement(By.xpath("//span[contains(@class, 'bog')]")).click();
        String subject = driver.findElement(By.xpath("//h2[contains(@class, 'hP')]")).getText();
        return subject;
    }

    public String backTest() {

        // We go back to the browser's history to check if it works properly.
        driver.navigate().back();
        String title = driver.getTitle();
        return title;
    }
}
