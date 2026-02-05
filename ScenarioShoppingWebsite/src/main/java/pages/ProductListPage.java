package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListPage 
{
	WebDriver driver;
	
	@FindBy (xpath="//a[@data-group='men']") 
	private WebElement men;
	
	@FindBy (xpath="(//a[text()='T-Shirts'])[1]")
	private WebElement tshirt;
	
	@FindBy (xpath="(//div[@class='common-checkboxIndicator'])[1]")
	private WebElement checkTshirt;
	
	@FindBy (xpath="//div[@class='spinner-spinner']")
	private WebElement spinner;
	
	@FindBy (xpath="//div[@class='sort-sortBy']")
	private WebElement sortByDropdown;
	
	@FindBy (xpath="//li[3]/label[text()='Popularity']")
	private WebElement sortByOptionSelected;
	
	@FindBy (xpath="//ul[@class='results-base']/li[1]/a")
	private WebElement firstProduct;
	
	
	public ProductListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void mouseHoverMen(WebDriver driver, WebDriverWait wait)
	{
		Actions a = new Actions(driver);
		a.moveToElement(men).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(tshirt));
		tshirt.click();
	}
	
	public void selectCategory(WebDriver driver, WebDriverWait wait)
	{
		checkTshirt.click();
		
		wait.until(ExpectedConditions.invisibilityOf(spinner));
	}
	
	public void filterAndSort(WebDriver driver, WebDriverWait wait)
	{
		Actions a = new Actions(driver);
		a.moveToElement(sortByDropdown).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(sortByOptionSelected));
		sortByOptionSelected.click();
	}
	
	public void viewProduct(WebDriverWait wait)
	{
		wait.until(ExpectedConditions.invisibilityOf(spinner));
		firstProduct.click();
	}
}
