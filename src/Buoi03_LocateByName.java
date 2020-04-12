import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi03_LocateByName {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        WebElement txtEmail = driver.findElement(By.name("email"));
        WebElement txtPass = driver.findElement(By.name("pass"));
        txtEmail.sendKeys("tester01@gmail.com");
        txtPass.sendKeys("123456");
    }
}
