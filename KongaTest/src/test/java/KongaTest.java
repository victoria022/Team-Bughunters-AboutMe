import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class KongaTest {

    //import Selenium WebDriver
    private WebDriver driver;
    @BeforeTest

    public void SETUP() throws InterruptedException {
        // Locate where chrome driver is
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vnaba\\Downloads\\Team-Bughunters-AboutMe\\FacebookTest\\resources\\chromedriver-win64\\chromedriver.exe");
        //open Chrome browser
        driver = new ChromeDriver();

        //public void testKongaPageNavigation()
        //input Konga page url
        driver.get("https://www.konga.com/");
        //maximize the page
        driver.manage().window().maximize();
    }
    @Test
         public void positive() throws InterruptedException {
        //click on the Login/signup button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div[4]/a")).click();
        Thread.sleep(5000);
        //input valid email
        driver.findElement(By.id("username")).sendKeys("vnababa@gmail.com");
        driver.findElement(By.id("password")).sendKeys("vicky@2024");

        //click on login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);
        //categories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[1]")).click();
        Thread.sleep(10000);
        // click on the Computers and Accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(10000);
        //Click on the Laptop SubCategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(10000);
        // Click on the Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(10000);
        //Add an item to the cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/section/section/ul/li[8]/article/div[2]/form/div[2]/button")).click();
        Thread.sleep(10000);
        // Close pop up
        driver.findElement(By.xpath("/html/div/div/div[1]/button")).click();
        Thread.sleep(10000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[3]/div[3]/div/div[2]/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        Thread.sleep(10000);
        //PAYMENT PAGE



        //click pay now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(20000);

        //click continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(10000);

        //switch to iframe
        WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"kpg-frame-component\"]"));
        driver.switchTo().frame(iframeElement);
        Thread.sleep(10000);

        //click on card
        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[3]/button")).click();
        Thread.sleep(5000);

        // enter wrong card detail
        driver.findElement(By.id("card-number")).sendKeys("4920690182556718");
        Thread.sleep(10000);


        //Locate error message invalid card number
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"card-number_unhappy\"]"));
        Thread.sleep(10000);

        // print error message
        System.out.println("Error Message: " + errorMsg.getText());
        Thread.sleep(10000);


        //  //*[@id="card-number_unhappy"]

        // close frame
        driver.findElement(By.xpath("//*[@id=\"kpg-frame-component\"]")).click();
        driver.switchTo().defaultContent();
    }


    @AfterTest
    public void CloseBrowser() {
        //16. quit
        driver.quit();
    }
}






















