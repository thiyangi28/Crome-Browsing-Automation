import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod

    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();  //can customize the size >>>>>maximize getting the full size of screen
//        Dimension newSize = new Dimension(800,600); //Dimension comes from the getWidth method so this use for some element not visibile for max size so that when using dimension class with arguments.crete the constructor also
        driver.get("https://www.leafground.com/button.xhtml");

    }
    @Test
    public  void  buttonTest(){
        //01)Click and Confirm title
        //*[@id="j_idt88:j_idt90"]
            driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
            String expectTitle = "Dashboard";
            String actualTitle = driver.getTitle();
            if (expectTitle.equals(actualTitle)){
                System.out.println("Actual Title same as expected");
            }else {
                System.out.println("Actual Title not same as expected");
            }
        //Assert.assertEquals(actualTitle,expectTitle,"Title miss matched");//TestNG giving support to check the actual value as a validation method (Assert)

        //02)Find the position of the submit button
            driver.navigate().back();
            WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
            Point xPoint = getPosition.getLocation();   // X cordination Y cordination  serching by calling the getLocation method
            int x = xPoint.getX();
            int y = xPoint.getY();
            System.out.println("X position is : "+ x + "Y position is : " +y);

        //03)Find the save button color
            WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
            String color = buttonColor.getCssValue("background");
            System.out.println("Button color is : " + color);

        //04)Find the height and the width of this button
           WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
           int height = size.getSize().getHeight();
           int width = size.getSize().getWidth();
           System.out.println("Height : " + height +" "+ "Width : " + width);

    }
}
