package main;

import gui.MainGui;


public class Library {
	public static void main(String[] args) {
		try {
			MainGui maingui = new MainGui();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
		

