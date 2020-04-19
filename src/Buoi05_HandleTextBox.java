import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi05_HandleTextBox {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement txtSearch =  driver.findElement(By.xpath("//input[@name='q']"));
        // nhap text vào ô search
        txtSearch.sendKeys("Selenium");
        // clear
        // txtSearch.clear();
        // Click on "Tim voi Google" button
        // driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).click();
        // Enter
        txtSearch.sendKeys(Keys.ENTER);

        //find Element in result page
        WebElement txtSearch2 =  driver.findElement(By.xpath("//input[@name='q']"));
        // Get valuse from textbox
       String txtValue =   txtSearch2.getAttribute("value");
        System.out.println(txtValue);
    }
}
