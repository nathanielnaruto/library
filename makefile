main/Library.class : main/Library.java gui/MainGui.class gui/LoginGui.class gui/BorrowGui.class gui/ReturnGui.class 
	javac main/Library.java
gui/MainGui.class : gui/MainGui.java
	javac gui/MainGui.java
gui/LoginGui.class : gui/LoginGui.java
	javac gui/LoginGui.java
gui/BorrowGui.class : gui/BorrowGui.java
	javac gui/BorrowGui.java
gui/ReturnGui.class : gui/ReturnGui.java
	javac gui/ReturnGui.java

run:
	java -cp .:./lib/mysql-connector-java-5.1.37-bin.jar main.Library
