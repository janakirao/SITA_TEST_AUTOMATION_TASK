package sitaDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class functions{
	
	protected WebDriver driver;
	
	public functions(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//*[@id=\"top-banner-2\"]/div/div[2]/div/div/div/div/div[4]/div/a")
	private WebElement explore_button;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div/div/div[1]/div/div[5]/div/div/div/div[2]/a")
	private WebElement kingston_reserve_button;
	
	
	@FindBy(xpath="//*[@id=\"reservation-form\"]/div/div[2]/fieldset/input")
	private WebElement Name_text;
	
	@FindBy(xpath="//*[@id=\"reservation-form\"]/div/div[3]/fieldset/input")
	private WebElement Phone_text;
	
	@FindBy(xpath="//*[@id=\"chooseGuests\"]")
	private WebElement guests_Num_text;
	
	@FindBy(xpath="//*[@id=\"chooseCategory\"]")
	private WebElement destination_select;
	
		
	@FindBy(xpath="//*[@id=\"reservation-form\"]/div/div[5]/fieldset/input")
	private WebElement date_text;
	
	
	
	@FindBy(xpath="//*[@id=\"reservation-form\"]/div/div[7]/fieldset/button")
	private WebElement submitReservation_button;
	
	
	
	@FindBy(xpath="/html/body/header/div/div/div/nav/ul/li[1]/a")
	private WebElement home_link;
	
	public functions homepage_verify(){
		
		if(home_link.isDisplayed())
		{
		Assert.assertTrue(true, "Inside Home Page");
		}
		else
		{
	    Assert.assertFalse(true, "Not landed on HomePage");	
		}
		
		
		return this;
		
	}
	
	
	public functions explore_buttonclick(){
		explore_button.click();
		
		return this;
		
	}
	
	public functions makeReservation_buttonclick()
    {
		kingston_reserve_button.click();
		
		return this;
		
	}
	
	public functions enter_Name(String strName){
		
		System.out.println("enterName");
		Name_text.sendKeys(strName);
		
		return this;
		
	}
	
	public functions enter_Phone(String strPhone){
		Phone_text.sendKeys(strPhone);
		
		return this;
		
	}
	public functions enter_guests(String strGuests){
		guests_Num_text.sendKeys(strGuests);
		
		return this;
		
	}
	
	public functions enter_Destination(String strDestination){
		destination_select.click();
		Select dropdown = new Select(destination_select);
		dropdown.selectByVisibleText(strDestination);

		
		return this;
		
	}
	
	public functions enter_Date(String strDate){
		
		String strDataArray[] = strDate.split("/");
		
		date_text.sendKeys(strDataArray[0]);
		date_text.sendKeys(strDataArray[1]);
		date_text.sendKeys(strDataArray[2]);
		return this;
		
	}
	

	
	public functions submitReservation_buttonclick()
    {
	submitReservation_button.click();
		
		return this;
		
	}
	
}