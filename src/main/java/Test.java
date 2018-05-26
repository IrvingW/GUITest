import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Test {
    private static String driver_path = "chromedriver.exe";
    private static String upload_file_path = "E:\\worksapce\\IntelliJ\\GUITest\\upload_sample.pdf";
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", driver_path);
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

        // question 5
        driver.findElement(By.name("file")).sendKeys(upload_file_path);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        WebElement question5  = driver.findElement(By.id("question_q-5-1qvt"));
        WebElement uploaded = question5.findElement(By.className("uploaded"));
        while(true){
            String finish = uploaded.getAttribute("style");
            if(finish.equals("display: block;"))
                break;  // finish upload
            else{   // sleep 1s and check again when wake up
                System.out.println("uploading.....");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }

        }
        // take a break
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.out.println("interrupted");
        }

        // submit
        WebElement control = driver.findElement(By.className("survey_control"));
        WebElement button = control.findElement(By.className("survey_submit"));
        button.click();
        System.out.println("End.");
    }
}
