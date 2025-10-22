import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver = new ChromeDriver(); //driver is the reference varible for webDriver

    @BeforeMethod  // this annotation use for run before the methods as @Test so then firstly redirect to the page then run the test cases(Pre Conditions)
    public void openLinkTestPage(){

        driver.manage().window().maximize();  //can customize the size
        driver.get("https://www.leafground.com/link.xhtml  ");

    }
    @Test
    public void linkTest(){
        //01)take me to Dashbord

        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard")); //from string driver element cath the return value as WebElement and store variable is homeLink
        homeLink.click(); // we are doing click so that use and open the dashbord
        driver.navigate().back(); //navigate to the back from the page (back/forward/refresh)

        //02)find my destination

        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL without clicking me.")); // partialLinkText --- half of the text serching. no any issue >>>>> but the linktext need full text to serch
        String path = wheretoGo.getAttribute("href");
        System.out.println("This link is going to : " + path);

        //03)am i broken link?
        //out put is when clicking the page is broken showing as status code 404
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        //page name load of that 404
        String title = driver.getTitle();
        if (title.contains("404")){
            System.out.println("The link is broken");
        }else{
            System.out.println("Not Broken");
        }
        driver.navigate().back();

        //04)duplicate Link ?
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        //05)count page link?
        List<WebElement> countPageLinks = driver.findElements(By.tagName("a")); //more elements catch from this can't use as webElemnt need to get this as List
        int pageCounts = countPageLinks.size();
        System.out.println("Count of full page links :"+ pageCounts);

        //06)count layout link?
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLink = layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of layout links : "+countOfLayoutLink.size());
    }

}
