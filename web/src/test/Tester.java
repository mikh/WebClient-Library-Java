package test;

import web.Client;

public class Tester {
	public static void main(String[] args){
		System.out.println("Starting test");
		Client cc = new Client("https://www.google.com/");
		cc.sendKeys("gbqfq", "test", false);
		cc.click("gbqfb", false);
		System.out.println("Test Finished");
	}
}
