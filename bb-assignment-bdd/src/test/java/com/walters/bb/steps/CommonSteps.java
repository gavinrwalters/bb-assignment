package com.walters.bb.steps;

import static org.junit.Assert.fail;

import com.walters.bb.utils.NavigatorFactory;

import cucumber.api.java8.En;

/**
 * 
 * @author Gavin Walters
 *
 */

public class CommonSteps implements En{
	
	public CommonSteps(){
		
		Given("^The user is on the application home page$", () -> {
		    NavigatorFactory.getNavigator().loadHomePage();
		    NavigatorFactory.getNavigator().getNumberOfRecords();
		});

		Given("^selects the \"([^\"]*)\" button$", (String button) -> {
			NavigatorFactory.getNavigator().selectButton(button);
		});

		Given("^enters valid information in all fields$", () -> {
			NavigatorFactory.getNavigator().enterNameNew();
			NavigatorFactory.getNavigator().enterIntroducedDateNew();
			NavigatorFactory.getNavigator().enterDiscontinuedDateNew();
			NavigatorFactory.getNavigator().enterCompanyNew();
		});
		
		Given("^enters valid mandatory information only$", () -> {
			NavigatorFactory.getNavigator().enterNameNew();
		});
		
		Given("^enters special characters in the name field$", () -> {
			NavigatorFactory.getNavigator().enterNameNew("!£$<>:@");
		});
		
		Given("^enters (\\d+) characters in the name field$", (Integer arg1) -> {
			NavigatorFactory.getNavigator().enterNameNew("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
					+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
					+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB");
		});
		
		Given("^selects any record from the results table$", () -> {
			NavigatorFactory.getNavigator().selectTopRecord();
		});
		
		Given("^a date of \"([^\"]*)\" into the introduced field and valid information in all others$", (String date) -> {
			NavigatorFactory.getNavigator().enterNameNew();
			NavigatorFactory.getNavigator().enterIntroducedDateNew(date);
			NavigatorFactory.getNavigator().enterDiscontinuedDateNew();
			NavigatorFactory.getNavigator().enterCompanyNew();
		});
		
		Given("^a date of \"([^\"]*)\" into the discontinued field and valid information in all others$", (String date) -> {
			NavigatorFactory.getNavigator().enterNameNew();
			NavigatorFactory.getNavigator().enterIntroducedDateNew();
			NavigatorFactory.getNavigator().enterDiscontinuedDateNew(date);
			NavigatorFactory.getNavigator().enterCompanyNew();
		});
		
		Given("^is on the Add a computer page following a date validation error$", () -> {
			NavigatorFactory.getNavigator().selectButton("Add a new computer");
			NavigatorFactory.getNavigator().enterNameNew();
			NavigatorFactory.getNavigator().enterIntroducedDateNew();
			NavigatorFactory.getNavigator().enterDiscontinuedDateNew("xxxx-01-01");
			NavigatorFactory.getNavigator().enterCompanyNew();
			NavigatorFactory.getNavigator().selectButton("Create this computer");
		});

		Given("^when the date is corrected$", () -> {
			NavigatorFactory.getNavigator().enterDiscontinuedDateNew("2017-01-01");
		});
		
		Given("^enters an introduced date that is later than the discontinued date$", () -> {
			NavigatorFactory.getNavigator().enterNameNew();
			NavigatorFactory.getNavigator().enterIntroducedDateNew("2010-01-01");
			NavigatorFactory.getNavigator().enterDiscontinuedDateNew("2000-01-01");
			NavigatorFactory.getNavigator().enterCompanyNew();
		});
		Given("^a computer has been created with the following details \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$", (String name, String introducedDate, String discontinuedDate, String company) -> {
			NavigatorFactory.getNavigator().selectButton("Add a new computer");
			NavigatorFactory.getNavigator().enterNameNew(name);
			NavigatorFactory.getNavigator().enterIntroducedDateNew(introducedDate);
			NavigatorFactory.getNavigator().enterDiscontinuedDateNew(discontinuedDate);
			NavigatorFactory.getNavigator().enterCompanyNew(company);
			NavigatorFactory.getNavigator().selectButton("Create this computer");
		});

		Given("^\"([^\"]*)\" is entered into the search box$", (String name) -> {
		    NavigatorFactory.getNavigator().enterInSearchBox(name);
		    NavigatorFactory.getNavigator().submitSearch();
		});
		
		Given("^updates the \"([^\"]*)\" field$", (String field) -> {
			if(field.equalsIgnoreCase("name")){
				NavigatorFactory.getNavigator().enterNameUpdated();
		    }
		    else if(field.equalsIgnoreCase("introduced")){
		    	NavigatorFactory.getNavigator().enterIntroducedDateUpdated();
		    }
		    else if(field.equalsIgnoreCase("discontinued")){
		    	NavigatorFactory.getNavigator().enterDiscontinuedDateUpdated();
		    }
		    else if(field.equalsIgnoreCase("company")){
		    	NavigatorFactory.getNavigator().enterCompanyUpdated();
		    }
		    else{
		    	fail("no field found");
		    }
		});

		Then("^the computer is updated successfully$", () -> {
			NavigatorFactory.getNavigator().messageDisplayed("updated");
		});

		Then("^the computer searched for is displayed$", () -> {
			NavigatorFactory.getNavigator().isSearchedForPresent();
		});

		Then("^the computer is not created and the user remains on the Add a computer page$", () -> {
			NavigatorFactory.getNavigator().isDisplayed("add");
		});

		Then("^the computer is created successfully$", () -> {
			NavigatorFactory.getNavigator().messageDisplayed("created");
			NavigatorFactory.getNavigator().countIncreased();
		});
		
		Then("^all valid options are present in the company dropdown on the \"([^\"]*)\" page$", (String page) -> {
		    if(page.equalsIgnoreCase("Add a computer")){
		    	NavigatorFactory.getNavigator().validateDropDown("add");
		    }
		    else if(page.equalsIgnoreCase("Amend a computer")){
		    	NavigatorFactory.getNavigator().validateDropDown("amend");
		    }
		    else{
		    	fail("no page found");
		    }
		});
		
		Then("^the computer is deleted successfully$", () -> {
			NavigatorFactory.getNavigator().messageDisplayed("deleted");
			NavigatorFactory.getNavigator().countDecreased();
		});
	}
}
