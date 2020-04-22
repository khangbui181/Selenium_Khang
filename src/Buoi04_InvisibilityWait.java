import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Buoi04_InvisibilityWait {
    public static void main(String[] args) throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage(" time out affter 10 second")
                .ignoring(NoSuchElementException.class);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
        String text = driver.findElement(By.xpath("//div[@id='loading']")).getText();
        System.out.println(text);

    }
    }
