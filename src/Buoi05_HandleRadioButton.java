import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi05_HandleRadioButton {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        WebElement lblNam = driver.findElement(By.xpath("//label[text()='Nam']"));
        lblNam.click();
        // check radio button Nam dc click chua?
        WebElement radNam = driver.findElement(By.xpath("//label[text()='Nam']/preceding-sibling::input"));
        boolean radState = radNam.isSelected();
        System.out.println(radState);

    }

}
