import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Buoi05_HandleLink {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        // get url of entire page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for (int i=0; i<links.size();i++){
            String linkValue = links.get(i).getAttribute("href");
            System.out.println(linkValue);
        }
        // get url footer page
        List<WebElement> childLinks =driver.findElement(By.xpath("//div[@id='pageFooterChildren']")).findElements(By.tagName("a"));
        System.out.println(childLinks.size());

        for(int i=0; i<childLinks.size();i++){
            String linkValue = childLinks.get(i).getAttribute("href");
            System.out.println(linkValue);
        }
        }

    }
