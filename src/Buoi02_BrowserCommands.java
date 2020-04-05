import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi02_BrowserCommands {
    public static  void main(String[] args){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.close();
        // trình duyệt truy cập vào 1 trang web
        driver.get("https://google.com");

        // lấy title của 1 trang web
        String title = driver.getTitle();
       System.out.println(title);

        // lấy địa chỉ trang web
         String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        // String pageSource = driver.getPageSource();
        // System.out.println(pageSource);

        // trình duyệt   truy cập vào 1 trang web
        driver.navigate().to("https://ngoisao.net/");
        driver.navigate().back();
        // driver.navigate().refresh();

        driver.navigate().forward();
        // driver.manage().window().maximize();
}
}
