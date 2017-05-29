import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 * Created by Srini on 28-05-2017.
 */
public class Cookies {

    WebDriver driver;

    public Cookies(WebDriver driver) {
        this.driver = driver;
    }

    public String addcookies() {

        // We are adding a cookie named seleniumtest
        Cookie name = new Cookie("seleniumtest", "545431232");
        driver.manage().addCookie(name);
        Cookie cookiesList = driver.manage().getCookieNamed("seleniumtest");
        if(cookiesList != null) {
            return String.format("%s -> %s", cookiesList.getName(), cookiesList.getValue());
        }
        return null;
    }

    public Cookie deleteCookie() {

        // We delete the cookie named seleniumtest and try to get it but it should return null.
        driver.manage().deleteCookieNamed("seleniumtest");
        Cookie cookieList = driver.manage().getCookieNamed("seleniumtest");

        if(cookieList == null) {
            return null;
        }
        return cookieList;
    }
}
