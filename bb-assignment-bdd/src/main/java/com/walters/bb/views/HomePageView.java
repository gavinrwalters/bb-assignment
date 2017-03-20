package com.walters.bb.views;

/**
 * 
 * @author Gavin Walters
 *
 */

import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import com.walters.bb.containers.HomePageContainer;
import com.walters.bb.utils.BrowserDriver;

public class HomePageView {
	
	private static final HomePageContainer homePageContainer = PageFactory.initElements(BrowserDriver.getCurrentDriver(), HomePageContainer.class);
	
	static String numberOfRecords = "";
	
	public static void selectNewButton() {
		homePageContainer.add.click();
	}
	
	public static void messageDisplayed(String message1, String message2) {
		assertTrue(BrowserDriver.getCurrentDriver().getPageSource().contains(message1));
		assertTrue(BrowserDriver.getCurrentDriver().getPageSource().contains(message2)); 
	}

	public static void selectTopRecord() {
		homePageContainer.firstRecord.click();
	}

	public static void getNumberOfRecords() {
		String working = homePageContainer.numberOfRecords.getText();
		numberOfRecords = working.substring(0,3);
	}

	public static void countIncreased() {
		int oldCount = Integer.parseInt(numberOfRecords);
		String working = homePageContainer.numberOfRecords.getText();
		int newCount = Integer.parseInt(working.substring(0,3));
		oldCount ++;
		assertEquals(oldCount,newCount);
	}
	
	public static void countDecreased() {
		int oldCount = Integer.parseInt(numberOfRecords);
		String working = homePageContainer.numberOfRecords.getText();
		int newCount = Integer.parseInt(working.substring(0,3));
		oldCount --;
		assertEquals(oldCount,newCount);
	}

	public static void enterInSearchBox(String name) {
		homePageContainer.searchBox.sendKeys(name);
	}

	public static void submitSearch() {
		homePageContainer.searchSubmit.click();
	}

	public static void isSearchedForPresent() {
		assertEquals("QWERTY12345",homePageContainer.firstRecord.getText());
		assertEquals("01 Jan 2001",homePageContainer.firstRecordIntroduced.getText());
		assertEquals("01 Jan 2002",homePageContainer.firstRecordDiscontinued.getText());
		assertEquals("Atari",homePageContainer.firstRecordCompany.getText());
	}
}
