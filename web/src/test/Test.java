package test;

import web.Client;

public class Test {
	public static void main(String[] args){
		System.out.println("Hello world");

		Client cc = new Client("https://www.google.com/", "firefox", "");
	}
}
