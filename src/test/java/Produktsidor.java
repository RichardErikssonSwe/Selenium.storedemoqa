import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Produktsidor {
	private static WebDriver driver;

	 @BeforeClass
	 public static void beforeclass(){
	  driver = new FirefoxDriver();
	  driver.get("http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/");
	 }

	@Test
	public void Test1() {
		String title = driver.findElement(By.className("prodtitle")).getText();
		Assert.assertEquals("Wrong title name: ", "Magic Mouse", title);
	}
	
	@Test
	public void Test2(){
		String produktbes = driver.findElement(By.className("product_description")).getText();
		String produkttext = "Splashing Pixels' WordPress e-commerce themes offer the best e-commerce solution for online stores. Our highly customizable WordPress e-commerce theme design and technology is unlike anything else on the market. We put an amazing amount of care and detail into the design and functionality to ensure that we're creating the best user experience for your customers.";
		Assert.assertEquals("Error wrong product description: ", produktbes, produkttext);
	}
	
	@Test
	public void Test3(){
		String pris = driver.findElement(By.className("currentprice")).getText();
		Assert.assertEquals("Error incorrect current price: ", "$150.00" , pris);
	}
	
	@Test
	 public void Test4() throws InterruptedException{
	  driver.findElement(By.className("wpsc_buy_button")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.className("go_to_checkout")).click();
	  String prodnamn = driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/a")).getText();
	  Assert.assertEquals("Error product not found", "Magic Mouse", prodnamn);
	 }
	
	@Test
	 public void Test5(){
	  driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/']")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div/div[1]/div[2]/div[2]/span/div[4]/a")).click();
	  //driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
	}
	
	@Test
	public void Test6() throws InterruptedException{
		  WebElement facebook = driver.findElement(By.xpath("//iframe[@title='fb:like Facebook Social Plugin']"));
		  Actions action1 = new Actions(driver);
		  action1.moveToElement(facebook).perform();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div/div[1]/div[2]/ul")).click();
		  Assert.assertEquals("Incorrect page title: ", "Facebook", driver.getTitle());
		 }
	
	@Test
	public void Test7() throws InterruptedException{
		WebElement facebook2 = driver.findElement(By.xpath("//iframe[@title='fb:like Facebook Social Plugin']"));
		  Actions action2 = new Actions(driver);
		  action2.moveToElement(facebook2).perform();
		  Thread.sleep(3000);
		boolean likes = driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[2]/div/div[1]/span/span[2]")).isDisplayed();
		Assert.assertTrue("Numbers of likes not shown: ", likes);
	}
	  
	@AfterClass
	 public static void afterClass(){
	  driver.close();
	 }

}
