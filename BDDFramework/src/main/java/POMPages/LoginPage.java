package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	 @FindBy(xpath="//input[@name='user_name']")
	    private WebElement userNameTextField;
	    
	    @FindBy(xpath="//input[@name='user_password']")
	    private WebElement passwordTextField;
	    
	    @FindBy(xpath="//input[@id='submitButton']")
	    private WebElement loginBtn;
	    
	    public LoginPage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }
	    
	    //Business Library
	    
	    /**
	     * This method is used to login to the application
	     * @param userName
	     * @param password
	     */
	    public void loginAction(String username,String password)
	    {
	    	userNameTextField.sendKeys(username);
	    	passwordTextField.sendKeys(password);
	    	loginBtn.click();
	    }

}
