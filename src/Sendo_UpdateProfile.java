
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

    public class Sendo_UpdateProfile  {
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

            // Vào trang sendo.vn
            driver.get("https://sendo.vn");

            // Tắt popup "Ở nhà là nhất - 10K
            List<WebElement> btnClose1 =
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='modal-content']/button[starts-with(@class,'close')]")));
            if (btnClose1.size()>0) {
                btnClose1.get(0).click();
            }

            // Tắt popup "Bật thông báo để không bỏ lỡ..."
            List<WebElement> btnClose2 =
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[starts-with(@class,'closeBtn')]")));
            if (btnClose2.size()>0){
                btnClose2.get(0).click();
            }

            // Click Đăng nhập
            WebElement btnLogin = driver.findElement(By.xpath("//button[@id='login']"));
            btnLogin.click();

            // Click link "Đã có SendoID"
            WebElement eleHaveSendoId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Đã có SendoID']")));
            eleHaveSendoId.click();

            // Nhập textbox Email
            WebElement txtEmail = driver.findElement(By.xpath("//input[@name='username']"));
            txtEmail.sendKeys("tester001gm@gmail.com");

            // Nhập text Pass
            WebElement txtPass = driver.findElement(By.xpath("//input[@name='password']"));
            txtPass.sendKeys("123456");

            // Click button Đăng nhập
            WebElement btnLogin2 = driver.findElement(By.xpath("//button[starts-with(@class,'btnLogin')]"));
            btnLogin2.click();

            //Tắt poup đăng nhập thành công
            //driver.findElement(By.xpath(("//button[starts-with(@class,'close')]"))).click();
            //WebElement eleClose = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[starts-with(@class,'close')]")));
            //eleClose.click();
            String txtLogin = driver.findElement(By.xpath("//div[starts-with(@class,'toast')]/div/p")).getText();
            System.out.println(txtLogin);

            //Nhấn vào tên user
            WebElement eleMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='user_menu']")));
            eleMenu.click();

            //Nhấn vào thông tin tài khoản
            WebElement eleProfile = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Thông tin tài khoản')]")));
            eleProfile.click();

            //Cập nhật Họ và tên đệm
            //driver.findElement(By.xpath(("//input[@name='firstName']"))).clear();
            WebElement txtFirstName = driver.findElement(By.xpath("//input[@name='firstName']"));
            txtFirstName.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
            txtFirstName.sendKeys("Cheng Cheng");

            //Cập nhật Tên
            //driver.findElement(By.xpath(("//input[@name='lastName']"))).clear();
            WebElement txtLastName = driver.findElement(By.xpath("//input[@name='lastName']"));
            txtLastName.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
            txtLastName.sendKeys("Phạm");

            //Cập nhật Giới tính
            WebElement radNam = driver.findElement(By.xpath("//label[contains(text(),'Nam')]/preceding-sibling::input"));
            if (radNam.isSelected()) {
                radNam.click();
            }

            //Cập nhật ngày sinh
            WebElement eleCalendar = driver.findElement(By.xpath("//div[@class='DayPickerInput']"));
            eleCalendar.click();

            WebElement eleMonth = driver.findElement(By.xpath("//select[@id='month']"));
            Select drpMonth = new Select(eleMonth);
            drpMonth.selectByVisibleText("Tháng 6");

            WebElement eleYear = driver.findElement(By.xpath("//select[@id='year']"));
            Select drpYear = new Select(eleYear);
            drpYear.selectByVisibleText("1980");

            driver.findElement((By.xpath("//div[starts-with(@class,'DayPicker-Day') and text()='16']"))).click();

            // Chờ calendar biến mất
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='DayPicker']")));

            //Nhấn button Cập nhật
            driver.findElement(By.xpath(("//button[starts-with(@class,'userSubmit')]"))).click();

            //Get text popup Cập nhật thành công
            String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@class,'toast')]/div/p"))).getText();
            System.out.println(message);

            // Đóng trình duyệt
            driver.close();
        }
    }
