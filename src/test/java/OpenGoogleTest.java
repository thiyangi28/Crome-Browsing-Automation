import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenGoogleTest {

    @Test
    public  void googleTest() {
        WebDriver driver = new ChromeDriver();//1  .......1&2 lines are direct to the browser
        driver.get("https://www.google.com/");//2
        //web page serching element catch by name then given to serch as colombo after that press enter key
        driver.findElement(By.name("q")).sendKeys("Colombo" + Keys.ENTER);
        //driver.quit();
    }
}
