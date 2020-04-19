import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.sql.SQLOutput;

public class Buoi05_HandleText {
    public static void main(String[] args) throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Vào trang facebook
        driver.get("https://facebook.com");
        //tagName[@attrName=attrValue]
       // WebElement welcomeText = driver.findElement(By.xpath("//div[@class='_5iyx']"));
        WebElement welcomeText = driver.findElement(By.xpath("//div[starts-with(text(),'Facebook')]"));

        // Get text
        String textValue = welcomeText.getText();
        System.out.println(textValue);

        // Get length of text
        int textLenght = welcomeText.getText().length();
        System.out.println(textLenght);

        // get css value
        String fontColor = welcomeText.getCssValue("color");
       //System.out.println("Color: "+ fontColor);
        System.out.println("Color: "+ Color.fromString(fontColor).asHex());

        String fontFamily = welcomeText.getCssValue("font-family");
        System.out.println("font-family: "+ fontFamily);

        String fontSize = welcomeText.getCssValue("font-size");
        System.out.println("font-size: "+ fontSize);


    }
}
