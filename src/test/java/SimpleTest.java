import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleTest {

    public static final String GOOGLE_URL = "http://www.google.com";
    public static final String SEARCHING_PHRASE = "http://slovvik.blogspot.com/";

    static {
        System.setProperty("webdriver.chrome.driver", "D:\\Projects\\chromedriver.exe");
    }

    private WebDriver driver = new ChromeDriver();
    private WebDriverWait webDriverWait;

    @Test
    public void simpleGoogleTest() {
        driver.get(GOOGLE_URL);
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 5);
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(SEARCHING_PHRASE);
        WebElement searchButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
        searchButton.click();
        String pageTitle = driver.getTitle();
        Assert.assertThat(pageTitle, CoreMatchers.containsString(SEARCHING_PHRASE));
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
