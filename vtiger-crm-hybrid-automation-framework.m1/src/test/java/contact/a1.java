package contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class a1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

      //  driver.get("http://localhost:8888/index.php?action=Login&module=Users");
        
        // newWindow() => Create a new browser window and switches the focus to the new window .
        //WindowType => Represents the type of new browser window that may be created. 
        
        //driver.switchTo().newWindow(WindowType.WINDOW);
        
        
        

        driver.get("https://google.com");

        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://amazon.in");
        
        

        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.quit();
    }
}