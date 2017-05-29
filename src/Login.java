import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Srini on 28-05-2017.
 */
public class Login {

    WebDriver driver;
    Wait<WebDriver> wait;

    public Login(WebDriver driver) {
        this.driver = driver;

        //Fluent Wait while checking for the element every 5 seconds to maximum timeout of 10 seconds.
        this.wait = new FluentWait<>(driver)
                .withTimeout(10, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public Mainpage loginTest() {

        //We login with the user name and password.
        driver.findElement(By.cssSelector("#identifierId")).sendKeys("seleniumtestsrini@gmail.com");
        driver.findElement(By.cssSelector("#identifierNext")).click();
        driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys("seleniumtest12345");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'RveJvd snByac')]")));
        driver.findElement(By.cssSelector("#passwordNext > content")).click();

        return new Mainpage(driver);

    }

}
