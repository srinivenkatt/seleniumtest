import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Srini on 28-05-2017.
 */
public class Mainpage {
    WebDriver driver;

    public Mainpage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName() {

        //We click the account tab in the homepage and try to get the username of the logged in User.
        driver.findElement(By.xpath("//span[contains(@class, 'gb_8a gbii')]")).click();
        String userName = driver.findElement(By.xpath("//div[contains(@class,'gb_ub gb_vb')]")).getText();
        return userName;
    }

    //Return the driver(with logged in homepage) to Newmail class.
    public Newmail sendMail() {
        return new Newmail(driver);
    }
}
