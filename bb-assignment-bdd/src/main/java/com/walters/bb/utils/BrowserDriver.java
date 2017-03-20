package com.walters.bb.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Gavin Walters
 *
 */

public class BrowserDriver {

	private static WebDriver webDriver;

	private static final String TEST_URL = "http://computer-database.herokuapp.com/computers";	

	public synchronized static WebDriver getCurrentDriver() {
		if (webDriver == null) {
			try {
				webDriver = null;
				URL url = BrowserDriver.class.getClassLoader().getResource("chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", new File(url.toURI()).getAbsolutePath());
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				options.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
				webDriver = new ChromeDriver(options);
				webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				webDriver.get(TEST_URL);
				return webDriver;
			} catch (URISyntaxException e) {
				throw new IllegalStateException("Cannot find driver");
			} finally {
				Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}
		}
		return webDriver;
	}

	private static class BrowserCleanup implements Runnable {
		public void run() {
			close();
		}
	}
	
	public static void loadStartingPage() {
		getCurrentDriver().get(TEST_URL);
	}

	public static void close() {
		try {
			getCurrentDriver().quit();
			webDriver = null;
		} catch (UnreachableBrowserException e) {
			e.printStackTrace();
		}
	}
	
	public static WebElement waitForElement(WebElement elementToWaitFor) {
		return waitForElement(elementToWaitFor, null);
	}

	public static WebElement waitForElement(WebElement elementToWaitFor, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 3;
		}

		WebDriverWait wait = new WebDriverWait(getCurrentDriver(), waitTimeInSeconds);
		return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
	}
}
