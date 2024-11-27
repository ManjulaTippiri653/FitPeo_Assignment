	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
    import org.testng.annotations.AfterClass;
    import org.testng.annotations.BeforeClass;
    import org.testng.annotations.Test;

	//import com.sun.tools.javac.util.Assert;

public class FitpeoAssignment {
	
	
	WebDriver driver;
	
@BeforeClass

public void setup() {
	System.setProperty("webdriver.chrome.driver", "/home/garikipatij/Downloads/chromedriver-linux64 (1)/chromedriver-linux64/chromedriver");
	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	
}


@Test
public void test() {		
					

					//1.Navigate to the FitPeo Homepage:
					
					driver.get("https://www.fitpeo.com/");
					
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					
					//2.Navigate to the Revenue Calculator Page:

					driver.findElement(By.xpath("/html/body/div[1]/div/header/div/div[3]/div[6]/a")).click();
					
					//3.Scroll Down to the Slider section:
					JavascriptExecutor js = (JavascriptExecutor) driver;		
					WebElement slider = driver.findElement(By.xpath("//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-16i48op']"));
					js.executeScript("arguments[0].scrollIntoView();", slider);

					
					//4.Adjust the Slider:
					WebElement sliderThumb = driver.findElement(By.cssSelector("span[data-index='0'] input"));
				    Actions actions = new Actions(driver);
				    actions.dragAndDropBy(sliderThumb, 94, 0).perform();
				   // Thread.sleep(3000);
				    
				    //5.Update the Text Field:
				       
				    driver.findElement(By.id(":r0:")).sendKeys(Keys.BACK_SPACE);
				    driver.findElement(By.id(":r0:")).sendKeys(Keys.BACK_SPACE);
				    driver.findElement(By.id(":r0:")).sendKeys(Keys.BACK_SPACE);
				    driver.findElement(By.id(":r0:")).sendKeys("560");
				    
				    //validate the slider value
				    
				    String value = driver.findElement(By.cssSelector("span[data-index='0'] input")).getAttribute("value");    
	                Assert.assertEquals(value,"560");
	                System.out.println("Success: Attribute value is as expected i.e 560");
				    
				   // Thread.sleep(3000);
				    driver.findElement(By.id(":r0:")).sendKeys(Keys.BACK_SPACE);
				    driver.findElement(By.id(":r0:")).sendKeys(Keys.BACK_SPACE);
				    driver.findElement(By.id(":r0:")).sendKeys(Keys.BACK_SPACE);
				    driver.findElement(By.id(":r0:")).sendKeys("820");
				  
				  		
				   
				    
					//6.Validate Slider Value:
				    //Ensure that when the value 560 is entered in the text field, the slider's position is updated to reflect the value 560.

					//7.Select CPT Codes:
				   
				  			    
				    WebElement scrolldown= driver.findElement(By.xpath("//*[text()='CPT-99457']"));
				    js.executeScript("arguments[0].scrollIntoView();", scrolldown);
				    
				    driver.findElement(By.xpath("(//span[contains(@class, 'MuiCheckbox-root')]//input[@type='checkbox'])[1]")).click();	
				    driver.findElement(By.xpath("(//span[contains(@class, 'MuiCheckbox-root')]//input[@type='checkbox'])[2]")).click();
				    driver.findElement(By.xpath("(//span[contains(@class, 'MuiCheckbox-root')]//input[@type='checkbox'])[3]")).click();	
				    driver.findElement(By.xpath("(//span[contains(@class, 'MuiCheckbox-root')]//input[@type='checkbox'])[8]")).click();
				    
				   				    
				    //8.Validate Total Recurring Reimbursement:
				    String actual =  driver.findElement(By.xpath("(//p[contains(@class, 'MuiTypo')]//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]")).getText();
					String expected = "$110700";
					Assert.assertEquals(actual,expected);
					System.out.println("Validation is scucess.");
					
					//9.Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month: shows the value $110700.	
					
					String te= driver.findElement(By.xpath("(//p[contains(@class, 'MuiTypo')])[7]")).getText();
					System.out.println(te); 
					
				 
				  }

@AfterClass
                   public void teardown() {
	                driver.close(); 
	
                      }


		}



