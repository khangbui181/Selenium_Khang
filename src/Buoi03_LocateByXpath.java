import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi03_LocateByXpath {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        // tim element textbox Email theo id
        // WebElement txtEmail = driver.findElement(By.id("email"));
        // tìm element textbox Email theo Xpath
        // WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement txtEmail = driver.findElement(By.xpath("//input[@name='email']"));

        // Tìm element textbox Pass theo id
        // WebElement txtPass  = driver.findElement(By.id("pass"));
        // tìm element textbox Email theo Xpath
        // WebElement txtPass = driver.findElement(By.xpath("//input[@id='pass']"));
        WebElement txtPass = driver.findElement(By.xpath("//input[@name='pass']"));

        //Nhập dữ liệu vào txtEmail
        txtEmail.sendKeys("tester01@gmail.com");

        // nhập dữ liệu vào txtPass
        txtPass.sendKeys("123456");
    }
    }
