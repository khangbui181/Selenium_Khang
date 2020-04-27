import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class Buoi06_HandleTabWindow {
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
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[text()='Instagram']")).click();
        String facebookTitle = driver.getTitle();
        System.out.println(facebookTitle);

        // Switch Tab
        // danh sách iterator lưu trữ danh sách các tab của trình duyệt
        Iterator<String> iter = driver.getWindowHandles().iterator();
        String parentID = iter.next();
        String childID = iter.next();

        // switch to instagram
        driver.switchTo().window(childID);
        // lấy titlte và in ra màn hình
        String instagramTitle = driver.getTitle();
        System.out.println(instagramTitle);

        // Switch back faacebok
        driver.switchTo().window(parentID);
        String facebookTitle2 = driver.getTitle();
        System.out.println(facebookTitle2);

        // tắt tất cả tab trong trình duyệt
        driver.quit();
    }
}
