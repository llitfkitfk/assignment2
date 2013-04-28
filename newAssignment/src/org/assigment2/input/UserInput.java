package org.assigment2.input;

import java.util.Scanner;

public class UserInput {
	private  Scanner scanner;
	
	public UserInput() {
		// TODO Auto-generated constructor stub
		this.scanner = new Scanner(System.in);
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return scanner.hasNext();
	}

	public String getInput() {
		// TODO Auto-generated method stub
		return scanner.nextLine();
	}
}
