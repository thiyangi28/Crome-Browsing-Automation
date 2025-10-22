import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {

        driver.manage().window().maximize();  //can customize the size
        driver.get("https://www.leafground.com/input.xhtml");
        Thread.sleep(3000);//window waiting time   not for best practice

    }
    @Test
    public void textBoxTest(){
        //01)Type your Name
        WebElement name = driver.findElement(By.id("j_idt88:name")); //return type WebElement / reference variable name
        name.sendKeys("Alex Andrew");

        //02)Append Country to this city
        WebElement appendCity = driver.findElement(By.id("j_idt88:j_idt91"));
        appendCity.sendKeys("Sri Lanka");

        //03)Verify if text box is disabled
        boolean verify = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Text Box Enabled : " + verify);

        //04)Clear the typed text
        //*[@id="j_idt88:j_idt95"]
        WebElement clearText = driver.findElement((By.xpath("//*[@id='j_idt88:j_idt95']")));
        clearText.clear();

        //05)Retrive the typed text
        WebElement retriveType = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = retriveType.getAttribute("value");
        System.out.println(value);

        //06)Type email and Tab confirm control moved to next element
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("alexandrew4@gmail.com" + Keys.TAB + "Confirmd control move to next element");
        //Above code line first type email-sendKeys>>> athen tab button for tab - Keys.Tab
    }
}
