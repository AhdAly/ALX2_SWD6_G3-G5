import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BugDetection {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
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
        driver.findElement(By.id("month")).sendKeys("40");
        driver.findElement(By.id("year")).sendKeys("3");

        String month = driver.findElement(By.id("month")).getAttribute("value");
        String year = driver.findElement(By.id("year")).getAttribute("value");


        if (Integer.parseInt(month) > 12 || Integer.parseInt(month) < 1) {
            System.out.println("Bug Detected: Invalid month entered! Month must be between 1 and 12.");
        }

        else if (Integer.parseInt(year) < 2025) {
            System.out.println("Bug Detected: Invalid year entered! Year cannot be less than the current year.");
        } else {

            System.out.println("Valid month and year entered.");
            driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            WebElement confirmation = driver.findElement(By.className("sweet-alert"));
            if (confirmation.isDisplayed()) {
                System.out.println("Order placed successfully");
                driver.findElement(By.xpath("//button[text()='OK']")).click();
            }
        } catch (Exception e) {
            System.out.println("Order failed");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
}
}