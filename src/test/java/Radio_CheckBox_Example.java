import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Radio_CheckBox_Example {

    WebDriver driver;

    @BeforeMethod

    public void radioCheckTestMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/radio.xhtml");
    }
    @Test
    public void radioTest() {
        //01)find the default select radio button

        boolean cromeOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (cromeOption) {
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console1:0']")).getText();
            System.out.println("default select radio button : " + chromeText);

        } else if (firefoxOption) {
            String firefoxTest = driver.findElement(By.xpath("//label[@for='j_idt87:console1:1']")).getText();
            System.out.println("default select radio button : " + firefoxTest);
        } else if (safariOption) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console1:2']")).getText();
            System.out.println("default select radio button : " + safariText);
        } else if (edgeOption) {
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console1:3']")).getText();
            System.out.println("default select radio button : " + edgeText);
        }


        //02)select the age group (only if not selected)
            WebElement ageGroup = driver.findElement(By.id("j_idt87:age:0"));
            boolean isChecked = ageGroup.isSelected();

            if (!isChecked){
                driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
            }
    }
    @Test
    public void checkBoxTest(){

//        //1)select wanted checkboxes and verifying those checkboxes selected status
//         driver.get("https://www.leafground.com/checkbox.xhtml");
//
//         driver.findElement(By.id())
    }
}