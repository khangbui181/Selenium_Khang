import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Buoi05_HandleDropdown {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        // Khởi tạo 1 select class
        WebElement eleMonth = driver.findElement(By.xpath("//select[@id='month']"));
        Select drpMonth = new Select(eleMonth);

        // chọn giá trị theo OptionId
        drpMonth.selectByIndex(9);

        // chọn giá trị theo Option value
        drpMonth.selectByValue("5");

        // chọn giá trị theo Option Text
        drpMonth.selectByVisibleText("Tháng 6");

        // Lấy giá trị đầu tiên đang dc chọn
        WebElement selectOpt = drpMonth.getFirstSelectedOption();
        System.out.println(selectOpt.getText());

        // Kiểm tra  số lượng option trong dropdown
        int drpSize= drpMonth.getOptions().size();
        System.out.println(drpSize);

        // In
        for (int i=0; i< drpSize; i++)
        {
            String optText = drpMonth.getOptions().get(i).getText();
            System.out.println(optText);
        }


    }
}
