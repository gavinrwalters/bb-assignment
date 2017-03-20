package com.walters.bb.views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.walters.bb.containers.AmendAComputerContainer;
import com.walters.bb.utils.BrowserDriver;

/**
 * 
 * @author Gavin Walters
 *
 */

public class AmendAComputerView {
	
	private static final AmendAComputerContainer amendAComputerContainer = PageFactory.initElements(BrowserDriver.getCurrentDriver(), AmendAComputerContainer.class);
	
	public static void enterComputerName(){
		Random r = new Random();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabet1 = "abcdefghijklmnopqrstuvwxyz";
		String computerName = "" + alphabet.charAt(r.nextInt(alphabet.length())) + alphabet1.charAt(r.nextInt(alphabet1.length())) 
				+ alphabet1.charAt(r.nextInt(alphabet1.length())) + alphabet1.charAt(r.nextInt(alphabet1.length())) 
				+ alphabet1.charAt(r.nextInt(alphabet1.length())) + alphabet1.charAt(r.nextInt(alphabet1.length()));
		amendAComputerContainer.name.clear();
		amendAComputerContainer.name.sendKeys(computerName);
	}
	
	public static void enterComputerName(String name){
		amendAComputerContainer.name.clear();
		amendAComputerContainer.name.sendKeys(name);
	}
	
	public static void enterIntroducedDate(){
		amendAComputerContainer.introduced.clear();
		amendAComputerContainer.introduced.sendKeys("2001-01-01");
	}
	
	public static void enterIntroducedDate(String date){
		amendAComputerContainer.introduced.clear();
		amendAComputerContainer.introduced.sendKeys(date);
	}
	
	public static void enterDiscontinuedDate(){
		amendAComputerContainer.discontinued.clear();
		amendAComputerContainer.discontinued.sendKeys("2017-01-01");
	}
	
	public static void enterDiscontinuedDate(String date){
		amendAComputerContainer.discontinued.clear();
		amendAComputerContainer.discontinued.sendKeys(date);
	}
	
	public static void enterCompany(){
		Random r = new Random();	
		String[] computers = {"Apple Inc.", "Thinking Machines", "RCA", "Netronics", "Tandy Corporation", "Commodore International", 
				"MOS Technology", "Micro Instrumentation and Telemetry Systems", "IMS Associates, Inc.", "Digital Equipment Corporation", 
				"Lincoln Laboratory", "Moore School of Electrical Engineering", "IBM", "Amiga Corporation", "Canon", "Nokia", "Sony", "OQO", 
				"NeXT", "Atari", "Acorn computer", "Timex Sinclair", "Nintendo", "Sinclair Research Ltd", "Xerox", "Hewlett-Packard", 
				"Zemmix", "ACVS", "Sanyo", "Cray", "Evans & Sutherland", "E.S.R. Inc.", "OMRON", "BBN Technologies", "Lenovo Group", "ASUS", 
				"Amstrad", "Sun Microsystems", "Texas Instruments", "HTC Corporation", "Research In Motion", "Samsung Electronics"};		
		amendAComputerContainer.company.click();
		amendAComputerContainer.company.sendKeys(computers[r.nextInt(42)]);
	}
	
	public static void enterCompany(String company){
		amendAComputerContainer.company.click();
		amendAComputerContainer.company.sendKeys(company);
	}
	
	public static void validateDropDown() {
		List<WebElement> allOptions;
		String[] computers = {"-- Choose a company --", "Apple Inc.", "Thinking Machines", "RCA", "Netronics", "Tandy Corporation", "Commodore International", 
				"MOS Technology", "Micro Instrumentation and Telemetry Systems", "IMS Associates, Inc.", "Digital Equipment Corporation", 
				"Lincoln Laboratory", "Moore School of Electrical Engineering", "IBM", "Amiga Corporation", "Canon", "Nokia", "Sony", "OQO", 
				"NeXT", "Atari", "Acorn computer", "Timex Sinclair", "Nintendo", "Sinclair Research Ltd", "Xerox", "Hewlett-Packard", 
				"Zemmix", "ACVS", "Sanyo", "Cray", "Evans & Sutherland", "E.S.R. Inc.", "OMRON", "BBN Technologies", "Lenovo Group", "ASUS", 
				"Amstrad", "Sun Microsystems", "Texas Instruments", "HTC Corporation", "Research In Motion", "Samsung Electronics"};
		WebElement selectElement = amendAComputerContainer.company;
		Select select = new Select(selectElement);
		allOptions = select.getOptions();
		assertEquals(43, allOptions.size());
		for (int i = 0; i < computers.length; i++) {  
			assertEquals(computers[i],allOptions.get(i).getText());
		}
	}

	public static void selectDeleteButton() {
		amendAComputerContainer.deleteButton.click();
	}
	
	public static void submitUpdateButton() {
		amendAComputerContainer.updateButton.click();
	}

	public static void isPagePresent() {
		assertTrue(BrowserDriver.getCurrentDriver().getPageSource().contains("Edit computer"));
	}
}
