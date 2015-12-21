main/Library.class : main/Library.java gui/MainGui.class gui/LoginGui.class gui/BorrowGui.class gui/ReturnGui.class query/ConfirmLogin.class gui/ManageGui.class query/ManageDB.class
	javac main/Library.java
gui/MainGui.class : gui/MainGui.java
	javac gui/MainGui.java
gui/LoginGui.class : gui/LoginGui.java
	javac gui/LoginGui.java
gui/BorrowGui.class : gui/BorrowGui.java
	javac gui/BorrowGui.java
gui/ReturnGui.class : gui/ReturnGui.java
	javac gui/ReturnGui.java
query/ConfirmLogin.class : query/ConfirmLogin.java
	javac query/ConfirmLogin.java
gui/ManageGui.class : gui/ManageGui.java
	javac gui/ManageGui.java
query/ManageDB.class : query/ManageDB.java
	javac query/ManageDB.java
	

run:
	java -cp .:./lib/mysql-connector-java-5.1.37-bin.jar main.Library
