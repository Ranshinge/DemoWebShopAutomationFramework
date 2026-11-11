package com.demowebshop.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
public class KeyboardUtils {
	
	//Press Enter
	public static void pressEnter(WebDriver driver) {
	    Actions action = new Actions(driver);
	    action.sendKeys(Keys.ENTER).perform();
	}
	
	//Press Tab
	public static void pressTab(WebDriver driver) {
	    Actions action = new Actions(driver);
	    action.sendKeys(Keys.TAB).perform();
	}
	
	//Copy Text – Ctrl + C
	public static void copyText(WebDriver driver) {
	    Actions action = new Actions(driver);
	    action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
	}
	
	//Paste Text – Ctrl + V
	public static void pasteText(WebDriver driver) {
	    Actions action = new Actions(driver);
	    action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	}

}
