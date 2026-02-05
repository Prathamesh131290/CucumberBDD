package pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsDetailsPage 
{
	WebDriver driver;
	
	@FindBy (xpath="//h1[@class='pdp-name']")
	private WebElement productName;
	
	@FindBy (xpath="//span[@class='pdp-price']//child::strong")
	private WebElement productPrice;
	
	
	public ProductsDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void viewDetails(WebDriver driver, WebDriverWait wait)
	{
		String originalWindowHandle = driver.getWindowHandle();
        //System.out.println("Original window handle: " + originalWindowHandle);
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		//System.out.println("Total number of open tabs: " + allWindowHandles.size());
		
		for(String currentWindowHandle : allWindowHandles) 
		{
            // Check if the current handle is NOT the original window handle
            if(!originalWindowHandle.contentEquals(currentWindowHandle)) 
            {
                driver.switchTo().window(currentWindowHandle);
                //System.out.println("Switched to new tab with handle: " + currentWindowHandle);
                break;
            }
        }
		
		System.out.println("Title of the new tab: " + driver.getTitle());
		
		System.out.println("Title of the product: " + productName.getText());
		
		System.out.println("Price of the product: " + productPrice.getText());
	}
}
