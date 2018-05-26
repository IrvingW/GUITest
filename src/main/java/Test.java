import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Test {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://wj.qq.com/s/2123779/5eb8");
        //driver.manage().window().maximize();

        // single selection
        WebElement question1 = driver.findElement(By.id("question_q-1-QGrG"));
        List<WebElement> options = question1.findElements(By.className("option_item"));
        WebElement ratio = options.get(2);
        ratio.click();
        // give it a break
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }

        // question 2
        // Selecting an item from Drop Down list Box
        Select dropdown = new Select(driver.findElement(By.name("answer_q-2-n8Sc")));

        try {
            dropdown.selectByIndex(1);
            Thread.sleep(500);
            dropdown.selectByIndex(2);
            Thread.sleep(500);
            dropdown.selectByIndex(3);
            Thread.sleep(500);
            dropdown.selectByIndex(4);
            Thread.sleep(500);
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        // give it a break
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }

        // multiple selection
        WebElement question3 = driver.findElement(By.id("question_q-3-qmYa"));
        options = question3.findElements(By.className("option_item"));
        WebElement checkbox = options.get(3);
        checkbox.click();
        checkbox = options.get(4);
        checkbox.click();
        // give it a break
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }

        // question 4
        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.name("answer_q-4-4XiB")).sendKeys("MM路径");
        // Get the text box from the application
        String result = driver.findElement(By.name("answer_q-4-4XiB")).getAttribute("value");
        //Print a Log In message to the screen
        System.out.println(" The Result is " + result);


        System.out.println("End.");
    }
}
