package example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {

    private WebDriver driver = null;

    @BeforeClass
    public void setUp() {
        System.out.println("*******************");
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", "D:\\teja\\SeleniumJars\\Selenium\\chromedriver.exe");

    }

    @Test
    public void testGooglePageTitleInIEBrowser() throws InterruptedException {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("ignoreZoomSetting", true);

        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testSampleOne();
        String strPageTitle = driver.getTitle();
        System.out.println("Page title: - " + strPageTitle);
        // driver.quit();

    }

    @Test
    public void testSampleOne() throws InterruptedException {
        System.out.println("Im in test sample one");

        // driver.navigate().
        driver.get("http://10.118.56.149:8090/techathon-web-1.0-SNAPSHOT/");
        driver.findElement(By.id("name")).sendKeys("Techathon");
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("Techathon.hcl.com");
        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys("tejavegi");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("Techathon123");
        Thread.sleep(1000);

        driver.findElement(By.id("confirm")).sendKeys("Techathon123");

        driver.findElement(By.id("submit")).click();
        // driver.navigate().to("http://store.demoqa.com/");
        // driver.manage().timeouts().wait();

        System.out.println(driver.getCurrentUrl() + " " + driver.getTitle());
        String strPageTitle = driver.getTitle();

    }

    /*
     * @Test public void testSampleTwo() { System.out.println( "Im in test sample two"); }
     * 
     * @Test public void testSampleThree() { System.out.println( "Im in test sample three"); }
     */

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            System.out.println("Closing Chrome browser");
            // driver.quit();
        }
    }

}
