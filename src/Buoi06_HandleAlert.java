import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Buoi06_HandleAlert {
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
        driver.get("https://tizag.com/javascriptT/javascriptalert.php");
        driver.findElement(By.xpath("//div[@class='display']//form//input")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        // khởi tạo đối tượng arlet
        Alert alert = driver.switchTo().alert();

        // get text trong alert
        String alertText = alert.getText();
        System.out.println(alertText);

        // click nút ok trong alert
        alert.accept();

        // click nút cancel trong alert
      //  alert.dismiss();

    }
}
