import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class SelenuimWebSignUpTest {

    private WebDriver driver;

    public void setUp() throws interruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chromedriver", "C:\\Users\\vnaba\\Downloads\\Team-Bughunters-AboutMe\\FacebookTest\\resources\\chromedriver-win64\\chromedriver.exe");
        //1.open chrome browser
        driver=new ChromeDriver();
        //2.Input your Selenium Demo webpage URL https://selenium-blog.herokuapp.com/
        driver.get("https://selenium-blog.herokuapp.com/");
        Thread.sleep(Duration.ofMillis(5000));
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4.Click on the signup button to open the signup page
        driver.findElement(By.ByXPath("/html/body/div[2]/div/a[2]")).click();
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Vick1");
        //6. Input your email address on the email address field
        driver.findElement(By.id("user_email")).sendKeys("Vic1@gmail.com");
        //7. locate the password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("p@ss");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        //9. Click on user item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/ul/div/div/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        //10. Search for an item (using python with selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/a")).click();
        //11. click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();

    @AfterTest
    public void closeBrowser() {
        // quit the browser
        if (driver != null) {
            driver.quit();
        }
    }


}