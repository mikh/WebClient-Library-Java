package web;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Client {
	WebDriver driver;
	
	public Client(String baseurl){
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("SELENIUM");
		driver = new FirefoxDriver(ffprofile);
		driver.get(baseurl);
	}
	
	public void getPage(String URL){
		driver.get(URL);
	}
	
	public String getPageSource(){
		return driver.getPageSource();
	}
	
	public void close(){
		driver.close();
	}
	
	public void printPage(){
		System.out.println(driver.getPageSource());
	}
	public void printPage(String filename){
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false));
			bw.write(driver.getPageSource());
			bw.close();
		} catch(IOException e){
			System.out.println("Error! Could not write to file " + filename);
		}
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public void sendKeys(String element, String value, boolean name){
		WebElement el = null;
		if(name){
			el = driver.findElement(By.name(element));
		} else{
			el = driver.findElement(By.id(element));
		}
		el.sendKeys(value);
	}
	
	public void submit(String element, boolean name){
		WebElement el = null;
		if(name){
			el = driver.findElement(By.name(element));
		} else{
			el = driver.findElement(By.id(element));
		}
		el.submit();
	}
	
	public void click(String element, boolean name){
		WebElement el = null;
		if(name){
			el = driver.findElement(By.name(element));
		} else{
			el = driver.findElement(By.id(element));
		}
		el.click();
	}
}
