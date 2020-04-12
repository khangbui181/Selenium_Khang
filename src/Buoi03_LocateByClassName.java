import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi03_LocateByClassName {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        // tìm element theo class name
        WebElement eleWelcomeText = driver.findElement(By.className("_5iyx"));

        // Get text của element
        String textValue = eleWelcomeText.getText();

        driver.close();
        // IN textValue lên màn hình console
        System.out.println(textValue);
       }
}
