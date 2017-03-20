package com.walters.bb.views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.walters.bb.containers.AddAComputerContainer;
import com.walters.bb.utils.BrowserDriver;

/**
 * 
 * @author Gavin Walters
 *
 */

public class AddAComputerView {
	
	private static final AddAComputerContainer addAComputerContainer = PageFactory.initElements(BrowserDriver.getCurrentDriver(), AddAComputerContainer.class);

	public static void selectConfirmButton() {
		addAComputerContainer.confirm.click();
	}
	
	public static void enterComputerName(){
		Random r = new Random();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabet1 = "abcdefghijklmnopqrstuvwxyz";
		String computerName = "" + alphabet.charAt(r.nextInt(alphabet.length())) + alphabet1.charAt(r.nextInt(alphabet1.length())) 
				+ alphabet1.charAt(r.nextInt(alphabet1.length())) + alphabet1.charAt(r.nextInt(alphabet1.length())) 
				+ alphabet1.charAt(r.nextInt(alphabet1.length())) + alphabet1.charAt(r.nextInt(alphabet1.length()));
		addAComputerContainer.name.clear();
		addAComputerContainer.name.sendKeys(computerName);
	}
	
	public static void enterComputerName(String name){
		addAComputerContainer.name.clear();
		addAComputerContainer.name.sendKeys(name);
	}
	
	public static void enterIntroducedDate(){
		addAComputerContainer.introduced.clear();
		addAComputerContainer.introduced.sendKeys("2001-01-01");
	}
	
	public static void enterIntroducedDate(String date){
		addAComputerContainer.introduced.clear();
		addAComputerContainer.introduced.sendKeys(date);
	}
	
	public static void enterDiscontinuedDate(){
		addAComputerContainer.discontinued.clear();
		addAComputerContainer.discontinued.sendKeys("2017-01-01");
	}
	
	public static void enterDiscontinuedDate(String date){
		addAComputerContainer.discontinued.clear();
		addAComputerContainer.discontinued.sendKeys(date);
	}
	
	public static void enterCompany(){
		Random r = new Random();	
		String[] computers = {"Apple Inc.", "Thinking Machines", "RCA", "Netronics", "Tandy Corporation", "Commodore International", 
				"MOS Technology", "Micro Instrumentation and Telemetry Systems", "IMS Associates, Inc.", "Digital Equipment Corporation", 
				"Lincoln Laboratory", "Moore School of Electrical Engineering", "IBM", "Amiga Corporation", "Canon", "Nokia", "Sony", "OQO", 
				"NeXT", "Atari", "Acorn computer", "Timex Sinclair", "Nintendo", "Sinclair Research Ltd", "Xerox", "Hewlett-Packard", 
				"Zemmix", "ACVS", "Sanyo", "Cray", "Evans & Sutherland", "E.S.R. Inc.", "OMRON", "BBN Technologies", "Lenovo Group", "ASUS", 
				"Amstrad", "Sun Microsystems", "Texas Instruments", "HTC Corporation", "Research In Motion", "Samsung Electronics"};		
		addAComputerContainer.company.click();
		addAComputerContainer.company.sendKeys(computers[r.nextInt(42)]);
	}
	
	public static void enterCompany(String company){
		addAComputerContainer.company.click();
		addAComputerContainer.company.sendKeys(company);
	}

	public static void validateDropDown() {
		List<WebElement> allOptions;
		String[] computers = {"-- Choose a company --", "Apple Inc.", "Thinking Machines", "RCA", "Netronics", "Tandy Corporation", "Commodore International", 
				"MOS Technology", "Micro Instrumentation and Telemetry Systems", "IMS Associates, Inc.", "Digital Equipment Corporation", 
				"Lincoln Laboratory", "Moore School of Electrical Engineering", "IBM", "Amiga Corporation", "Canon", "Nokia", "Sony", "OQO", 
				"NeXT", "Atari", "Acorn computer", "Timex Sinclair", "Nintendo", "Sinclair Research Ltd", "Xerox", "Hewlett-Packard", 
				"Zemmix", "ACVS", "Sanyo", "Cray", "Evans & Sutherland", "E.S.R. Inc.", "OMRON", "BBN Technologies", "Lenovo Group", "ASUS", 
				"Amstrad", "Sun Microsystems", "Texas Instruments", "HTC Corporation", "Research In Motion", "Samsung Electronics"};
		WebElement selectElement = addAComputerContainer.company;
		Select select = new Select(selectElement);
		allOptions = select.getOptions();
		assertEquals(43, allOptions.size());
		for (int i = 0; i < computers.length; i++) {  
			assertEquals(computers[i],allOptions.get(i).getText());
		}
	}

	public static void isPagePresent() {
		assertTrue(BrowserDriver.getCurrentDriver().getPageSource().contains("Add a computer"));
	}
}
