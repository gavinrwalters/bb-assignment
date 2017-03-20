package com.walters.bb.utils;

import static org.junit.Assert.fail;

import com.walters.bb.views.AddAComputerView;
import com.walters.bb.views.AmendAComputerView;
import com.walters.bb.views.HomePageView;

/**
 * 
 * @author Gavin Walters
 *
 */

public class Navigation {
	
	public void loadHomePage(){
		BrowserDriver.loadStartingPage();
	}

	public void selectButton(String button) {
		if(button.equalsIgnoreCase("Add a new computer")){
			HomePageView.selectNewButton();
		}
		else if(button.equalsIgnoreCase("Create this computer")){
			AddAComputerView.selectConfirmButton();
		}
		else if(button.equalsIgnoreCase("Delete this computer")){
			AmendAComputerView.selectDeleteButton();
		}
		else if(button.equalsIgnoreCase("Filter by name")){
			HomePageView.submitSearch();
		}
		else if(button.equalsIgnoreCase("Save this computer")){
			AmendAComputerView.submitUpdateButton();
		}
		else{
			fail("no button found");
		}
	}

	public void enterNameNew() {
		AddAComputerView.enterComputerName();
	}
	
	public void enterNameNew(String name) {
		AddAComputerView.enterComputerName(name);
	}
	
	public void enterNameUpdated() {
		AmendAComputerView.enterComputerName();
	}
	
	public void enterNameUpdated(String name) {
		AmendAComputerView.enterComputerName(name);
	}
	
	public void enterIntroducedDateNew() {
		AddAComputerView.enterIntroducedDate();
	}
	
	public void enterIntroducedDateNew(String date) {
		AddAComputerView.enterIntroducedDate(date);
	}
	
	public void enterIntroducedDateUpdated() {
		AmendAComputerView.enterIntroducedDate();
	}
	
	public void enterIntroducedDateUpdated(String date) {
		AmendAComputerView.enterIntroducedDate(date);
	}
	
	public void enterDiscontinuedDateNew() {
		AddAComputerView.enterDiscontinuedDate();
	}
	
	public void enterDiscontinuedDateNew(String date) {
		AddAComputerView.enterDiscontinuedDate(date);
	}
	
	public void enterDiscontinuedDateUpdated() {
		AmendAComputerView.enterDiscontinuedDate();
	}
	
	public void enterDiscontinuedDateUpdated(String date) {
		AmendAComputerView.enterDiscontinuedDate(date);
	}
	
	public void enterCompanyNew() {
		AddAComputerView.enterCompany();
	}
	
	public void enterCompanyNew(String company) {
		AddAComputerView.enterCompany(company);
	}
	
	public void enterCompanyUpdated() {
		AmendAComputerView.enterCompany();
	}
	
	public void enterCompanyUpdated(String company) {
		AmendAComputerView.enterCompany(company);
	}

	public void messageDisplayed(String type) {
		if(type.equalsIgnoreCase("created")){
			HomePageView.messageDisplayed("Done!", "has been created");
		}
		else if(type.equalsIgnoreCase("deleted")){
			HomePageView.messageDisplayed("Done!", "has been deleted");
		}
		else if(type.equalsIgnoreCase("updated")){
			HomePageView.messageDisplayed("Done!", "has been updated");
		}
		else{
			fail("no error message found");
		}
	}

	public void validateDropDown(String page) {
		if(page.equalsIgnoreCase("add")){
			AddAComputerView.validateDropDown();
	    }
	    else if(page.equalsIgnoreCase("amend")){
	    	AmendAComputerView.validateDropDown();
	    }
	    else{
	    	fail("no page found");
	    }
	}

	public void selectTopRecord() {
		HomePageView.selectTopRecord();
	}

	public void getNumberOfRecords() {
		HomePageView.getNumberOfRecords();
	}

	public void countIncreased() {
		HomePageView.countIncreased();
	}
	
	public void countDecreased() {
		HomePageView.countDecreased();
	}

	public void isDisplayed(String page) {
		if(page.equalsIgnoreCase("add")){
			AddAComputerView.isPagePresent();
	    }
	    else if(page.equalsIgnoreCase("amend")){
	    	AmendAComputerView.isPagePresent();
	    }
	    else{
	    	fail("no page found");
	    }
	}

	public void enterInSearchBox(String name) {
		HomePageView.enterInSearchBox(name);
	}

	public void submitSearch() {
		HomePageView.submitSearch();
	}

	public void isSearchedForPresent() {
		HomePageView.isSearchedForPresent();
	}
}
