import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.w3c.dom.html.HTMLImageElement;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Buoi04_Wait_Gmail {

    public static void main(String[] args) throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
         // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Wait<WebDriver> wait =  new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage(" time out affter 10 second")
                .ignoring(NoSuchElementException.class);

        driver.get("https://gmail.com");


        //tagName[@attrName=attrValue]
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(("trainer@way2automation.com"));
        driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))).sendKeys("12345678");
        driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();




    }
}
