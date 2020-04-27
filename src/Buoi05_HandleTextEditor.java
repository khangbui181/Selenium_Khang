import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Buoi05_HandleTextEditor {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Fluent Wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Time out after 12 seconds")
                .ignoring(NoSuchElementException.class);
        driver.get("https://yizeng.me/2014/01/31/test-wysiwyg-editors-using-selenium-webdriver/");

        //switch to iframe
        driver.switchTo().frame(0);

        // nhập text vào editor
        driver.switchTo().activeElement().sendKeys("khang");

        // thoát ra khỏi Iframe
        driver.switchTo().defaultContent();
    }
}
