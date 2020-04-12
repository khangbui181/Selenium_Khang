import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Buoi03_LocateTagName {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        // Tìm tất cả Element là đường link trong trang web
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // In số lượng links trên trang web lên màn hình console
        System.out.println(links.size());
    }
    }
