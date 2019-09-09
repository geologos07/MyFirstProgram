import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTestCase {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://market.yandex.ru/");

        driver.findElement(By.id("header-search")).sendKeys("MacBook", Keys.ENTER);

        driver.findElement(By.linkText("Ноутбук Apple MacBook Air 13 Mid 2017")).click();

        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.linkText("Отложить")).click();

        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.linkText("Перейти к отложенным")).click();
    }
}
