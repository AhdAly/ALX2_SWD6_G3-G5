import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestScenario2 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.eg/?language=en_AE");
    }


    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[text() = 'Fashion']")).click();
        driver.findElement(By.xpath("//a[@class='a-color-base a-link-normal']/span[text()='Men']")).click();
        driver.findElement(By.xpath("//img[@alt=\"Dice Mens Set of 3 Plain " +
                "Lycra Sockets Socks (pack of 3)\"]")).click();
        driver.findElement(By.xpath("//a[@title='Add to List'] ")).click();;
    }


    @AfterClass
    public void tearDown() {

        driver.quit();
    }

}
