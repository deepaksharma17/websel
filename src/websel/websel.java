package websel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class websel {

	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://192.168.56.101:3001/");
		driver.findElement(By.name("login")).sendKeys("devops");
		driver.findElement(By.name("password")).sendKeys("test");
		driver.findElement(By.name("click")).click();
		Thread.sleep(50);
		if (driver.getPageSource().contains("Login Succeeded")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		driver.close();
	}

}
