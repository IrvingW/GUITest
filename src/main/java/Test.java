import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Test {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://wj.qq.com/s/2123779/5eb8");

        // single selection
        WebElement question1 = driver.findElement(By.id("question_q-1-QGrG"));
        List<WebElement> options = question1.findElements(By.className("option_item"));
        WebElement ratio = options.get(2);
        ratio.click();

        // multiple selection
        WebElement question3 = driver.findElement(By.id("question_q-3-qmYa"));
        options = question3.findElements(By.className("option_item"));
        WebElement checkbox = options.get(3);
        checkbox.click();
        checkbox = options.get(4);
        checkbox.click();
    }
}
