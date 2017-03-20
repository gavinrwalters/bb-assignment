package com.walters.bb.containers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Gavin Walters
 *
 */

public class AmendAComputerContainer {
	
	@FindBy (id="name") 
	public WebElement name;
	
	@FindBy (id="introduced") 
	public WebElement introduced;
	
	@FindBy (id="discontinued") 
	public WebElement discontinued;
	
	@FindBy (id="company") 
	public WebElement company;
	
	@FindBy (xpath=".//*[@id='main']/form[2]/input") 
	public WebElement deleteButton;
	
	@FindBy (xpath="/html/body/section/form[1]/div/input") 
	public WebElement updateButton;
}
