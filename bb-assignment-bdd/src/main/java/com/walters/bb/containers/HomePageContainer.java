package com.walters.bb.containers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Gavin Walters
 *
 */

public class HomePageContainer {
	
	@FindBy (id="searchbox") 
	public WebElement searchBox;
	
	@FindBy (id="searchsubmit") 
	public WebElement searchSubmit;
	
	@FindBy (id="add") 
	public WebElement add;
	
	@FindBy (xpath="/html/body/section/h1") 
	public WebElement numberOfRecords;
	
	@FindBy (xpath=".//*[@id='main']/table/tbody/tr[1]/td[1]/a") 
	public WebElement firstRecord;
	
	@FindBy (xpath="/html/body/section/table/tbody/tr[1]/td[2]") 
	public WebElement firstRecordIntroduced;
	
	@FindBy (xpath="/html/body/section/table/tbody/tr[1]/td[3]") 
	public WebElement firstRecordDiscontinued;
	
	@FindBy (xpath="/html/body/section/table/tbody/tr[1]/td[4]") 
	public WebElement firstRecordCompany;
}
