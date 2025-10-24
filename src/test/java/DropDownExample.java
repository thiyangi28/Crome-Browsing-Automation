import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
                /// //////////////////////////video 7///////////////////////////
import java.util.List;

public class DropDownExample {


    WebDriver driver;
    @BeforeMethod

    public void dropdownTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();  //can customize the size >>>>>maximize getting the full size of screen
//        Dimension newSize = new Dimension(800,600); //Dimension comes from the getWidth method so this use for some element not visibile for max size so that when using dimension class with arguments.crete the constructor also
        driver.get("https://www.leafground.com/select.xhtml");

    }

    @Test
    public void leafGroundDropDownTest() {

        //01 -1)Ways of select values in basic dropdown

        WebElement droppDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(droppDown); // when have select element on dropdowns sellenium provide the selec class for create the object
        select.selectByIndex(1);
        select.selectByVisibleText("Playwright");


        //01 -2)Get the numbers of dropdown option

        List<WebElement> listOfOptions = select.getOptions(); // getting the select tag options in dropdown (create as a list)
        int size = listOfOptions.size();
        System.out.println("Number of elements in dropDown : " + size);

        for (WebElement element : listOfOptions) {   //appliying for loop and get the option on webElemnt
            System.out.println(element.getText());
        }

        //01 - 3)Using sendkeys select dropdown value (Sendkeys --> meaning is on a dropdown we type a letter its suggest the word in a dropdown)
        droppDown.sendKeys("Puppeteer");

        //01 - 4)Selecting value in a boostrap dropdown  // this dropdown type doesn't have select tag bcz of the bootstrap styles
        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();
        List<WebElement> listOfdropdown2values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']"));

        for (WebElement element : listOfdropdown2values) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("USA")) {
                element.click();
                break;
            }

        }
    }
        //02)Google search - pick a value from suggestions
    @Test
    public void googleSerchDropDown(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("cristiano");
        //driver.findElements(By.xpath(""))

    }


        //02)Handle Hidden auto suggestions drop down and serch using DOM Debugger trick

}
