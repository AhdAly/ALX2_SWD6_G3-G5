import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoblazeTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("http://www.demoblaze.com/");
        driver.findElement(By.id("login2")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("loginusername")).sendKeys("groupfivetest@gmail.com");
        driver.findElement(By.id("loginpassword")).sendKeys("group55555");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement username = driver.findElement(By.id("nameofuser"));
        if (username.isDisplayed()) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }
        driver.findElement(By.linkText("Laptops")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("MacBook Pro")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.linkText("Add to cart")).click();

        try {
            Thread.sleep(5000);
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("cartur")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement productInCart = driver.findElement(By.xpath("//td[text()='MacBook Pro']"));

        if (productInCart.isDisplayed()) {
            System.out.println("Product successfully added to cart");
        } else {
            System.out.println("Product not found in cart");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//button[text()='Place Order']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("name")).sendKeys("Group Five");
        driver.findElement(By.id("country")).sendKeys("Egypt");
        driver.findElement(By.id("city")).sendKeys("Alexandria");
        driver.findElement(By.id("card")).sendKeys("1234 5678 9012 3456");
        driver.findElement(By.id("month")).sendKeys("04");
        driver.findElement(By.id("year")).sendKeys("2025");

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement confirmation = driver.findElement(By.className("sweet-alert"));
        if (confirmation.isDisplayed()) {
            System.out.println("Order placed successfully");
        } else {
            System.out.println("Order failed");
        }

        driver.findElement(By.xpath("//button[text()='OK']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}