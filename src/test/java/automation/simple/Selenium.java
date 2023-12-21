package automation.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Selenium {
    WebDriver driver;
    @Test
    public void loginTest(){
        //open browser
        WebDriverManager.firefoxdriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://yopmail.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        //Tunggu halaman sampai inputan termuat sempurna
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login\"]")));
        driver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys("automationtest");
        driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
        
        //Switch ke iframe isi email
        driver.switchTo().frame("ifmail");
        String searchIsiMail = driver.findElement(By.xpath("//span[.='Deliverability']")).getText();
        String txtExpectedMail = "Deliverability";
        
         //verifikasi isi email
         Assert.assertEquals(searchIsiMail,txtExpectedMail);
         System.out.println(txtExpectedMail);
         System.out.println("Test Berhasil");
        

        //close browser
        driver.quit();

    }

    
}
