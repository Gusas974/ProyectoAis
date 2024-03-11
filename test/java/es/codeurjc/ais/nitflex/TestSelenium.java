package es.codeurjc.ais.nitflex;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestSelenium {
	private WebDriver driver;


	@BeforeEach
	void setUp() throws Exception {
		driver=new ChromeDriver();
	}
	
	@AfterEach
	public void teardown() {
		if(driver != null) {
			driver.quit();
		}
	}
	@Test
	void testBorrar() {
		driver.get("http://localhost:8080/");
		driver.findElement(By.linkText("Lemuria")).click();
		driver.findElement(By.id("remove-film")).click();
		assertNotNull(driver.findElement(By.id("message")));
	}
	@Test
	void testAñadir() {
		driver.get("http://localhost:8080/");
		driver.findElement(By.id("create-film")).click();
		driver.findElement(By.name("title")).sendKeys("Lemuria");
		driver.findElement(By.name("releaseYear")).sendKeys("2029");
		driver.findElement(By.name("url")).sendKeys("https://okdiario.com/img/2021/04/07/-cual-es-el-continente-de-lemuria_-655x368.jpg");
		driver.findElement(By.name("synopsis")).sendKeys("Continente perdido en el oceano");
		driver.findElement(By.id("Save")).click();
		driver.findElement(By.id("all-films")).click();		
		assertNotNull(driver.findElement(By.linkText("Lemuria")));
	}
	@Test
	void testBug() {
		driver.get("http://localhost:8080/");
		driver.findElement(By.linkText("Lemuria")).click();
		driver.findElement(By.id("edit-film")).click();
		driver.findElement(By.xpath("//*[text()='Cancel']")).click();
		assertNotNull(driver.findElement(By.id("edit-film")));
		
	}
	
	

}
