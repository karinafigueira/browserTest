import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class simpleTest {
    WebDriver driver;

//    https://www.guru99.com/cross-browser-testing-using-selenium.html
    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            throw new Exception("Browser is not correctly configured");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }

    @Test
    public void shouldLogin() throws Exception {

        driver.get("https://www.twitter.com/");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("html body.three-col.logged-out.western.pt.static-logged-out-home-page.no-nav-banners div#doc div.StaticLoggedOutHomePage div.StaticLoggedOutHomePage-content div.StaticLoggedOutHomePage-cell.StaticLoggedOutHomePage-utilityBlock div.StaticLoggedOutHomePage-signupBlock div.StaticLoggedOutHomePage-noSignupForm div.StaticLoggedOutHomePage-buttons a.js-nav.EdgeButton.EdgeButton--medium.EdgeButton--secondary.StaticLoggedOutHomePage-buttonLogin")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".js-username-field")).sendKeys("user");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".js-password-field")).sendKeys("password");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("html body.three-col.logged-out.western.pt.no-nav-banners div#doc.route-login.login-responsive div#page-outer div#page-container.AppContent.wrapper.wrapper-login div.page-canvas div.signin-wrapper form.t1-form.clearfix.signin.js-signin div.clearfix button.submit.EdgeButton.EdgeButton--primary.EdgeButtom--medium")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".DashboardProfileCard-content"));
    }



    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
