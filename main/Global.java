package main;

public class Global {
	static private String hno;
	static public void setHandle(String h) {
		hno = h;
	}
	static public String getHandle() {
		return hno;
	}
}
