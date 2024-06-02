package sitaDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import com.aventstack.extentreports.*;



public class sitaReservation 
    extends functions
{
	//protected WebDriver driver;
	
    public sitaReservation() {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	private ExtentTest extenttest;
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
	
	static WebDriver driver = new ChromeDriver();
	
	@Given ("I Launch into Sita URL {string}")
    public void SitaLaunch(String strURL)
    
    {
		
		try {
		WebDriverManager.chromedriver().setup();
		 driver.manage().window().maximize();
		 driver.navigate().to(strURL);
		 Thread.sleep(5000);
		}
		catch(Exception e){
			extenttest.log(Status.INFO, e);
		
		}
    }
	
	 /**
     * implemented under functions class
     */
	@And ("I verify landed on Home page successfully")
	public void verify_HomePage()
    {  
		try {
		homepage_verify();
		}
		catch(Exception e){
			extenttest.log(Status.INFO, e);
		
		}
    }

    /**
     * implemented under functions class
     */
	@And ("I click on explore More button beside Carribean")
	public void click_explore_button()
    {  
		try {
		explore_buttonclick();
		}
		catch(Exception e){
			extenttest.log(Status.INFO, e);
		
		}
    }
	
	/**
     * implemented under functions class
     */
	
	@And ("I click on  Make a Reservation in Kingston")
	public void makeReservation()
    {
		try {
		makeReservation_buttonclick();
		}
		
		catch(Exception e){
			extenttest.log(Status.INFO, e);
		
		}
    }
	
	
	/**
     * implemented under functions class
     */
	       
	
	
	@When ("I enter details of the trip {string} {string} {string} {string} {string}") 
	public void enter_Details(String strName, String strPhone, String strGuests, String strDate, String strDestination)
    { 
		try {
			

		    enter_Name(strName);
			enter_Phone(strPhone);
			enter_guests(strGuests);
			enter_Date(strDate);
			enter_Destination(strDestination);
		}
		
		catch(Exception e){
			extenttest.log(Status.INFO, e);
		
		}
		
    }
	
	/**
     * implemented under functions class
     */
	
	@Then ("I click on submit reservation now")
	public void submitReservation()  
    {
		try {
		submitReservation_buttonclick();
		
		driver.quit();
		}
		
		catch(Exception e){
			extenttest.log(Status.INFO, e);
		
		}
    }

  
   
}
