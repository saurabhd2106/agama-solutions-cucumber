package tests;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

public class LoginSteps {

	WebDriver driver;

	@Given("user navigates to facebook page")
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Saurabh Dhingra/workspace/libs/chromedriver-2.46/chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.addArguments("disable-infobar");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com");
	}

	@Given("user enter username as (.*)")
	public void enterUsername(String username) {
		driver.findElement(By.id("email")).sendKeys(username);
	}

	@Given("user enter password as (.*)")
	public void enterPassword(String password) {
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@Then("user logged in")
	public void clickLoginButton() {
		driver.findElement(By.id("u_0_2")).click();
	}

	@And("user closes the browser")
	public void closeBrowser() {
		driver.quit();
	}

	/*
	 * @Given("user enter following details") public void
	 * user_enter_following_details(DataTable dataTable) {
	 * 
	 * 
	 * List<String> userDetails = dataTable.asList();
	 * 
	 * driver.findElement(By.name("firstname")).sendKeys(userDetails.get(0));
	 * driver.findElement(By.name("lastname")).sendKeys(userDetails.get(1));
	 * driver.findElement(By.name("reg_email__")).sendKeys(userDetails.get(2));
	 * driver.findElement(By.name("reg_passwd__")).sendKeys(userDetails.get(3));
	 * }
	 */

	@Given("user enter following details")
	public void user_enter_following_details(DataTable dataTable) {

		Map<String, String> userDetails = dataTable.asMap(String.class, String.class);

		driver.findElement(By.name("firstname")).sendKeys(userDetails.get("Name"));
		driver.findElement(By.name("lastname")).sendKeys(userDetails.get("lastname"));
		driver.findElement(By.name("reg_email__")).sendKeys(userDetails.get("email"));
		driver.findElement(By.name("reg_passwd__")).sendKeys(userDetails.get("password"));
	}

	@Given("user enter signup button")
	public void user_enter_signup_button() {
		driver.findElement(By.id("u_0_11")).click();
	}

}
