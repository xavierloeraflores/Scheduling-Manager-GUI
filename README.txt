Scheduling Manager GUI
This application manages the schedules for employees of a software company. It also stores data on Customers, Users, and Contacts all with respect to local timezones. 
The application connects to a mysql database and also features native language support for both english and french

Created by Xavier Alejandro Loera Flores
xavier@loeraflores.tech
Version 1.0
July 13, 2023

IntelliJ Community 2021.1.3 x64
Java SE 17.0.1
JavaFx-SDK-17.0.1
mysql-connector-java-8.0.26

Running The Program on Intellij Community Edition IDE:
Open the Preferences panel on the IDE and then click on "Path Variables"
Set the path variables for the JavaFX Library
Run the main method on the Main.java file

The 3rd report on the Reports screen will display the total amount of customers on per Country or FirstLevelDivision.
The user can select just the Country to only display Customers from that given Country.
The user can also narrow down their selection even further by selecting a division.
The purpose of this report was to allow the user to gauge how many customers are in a given region for data collection.

LAMBDA SET 1:
src/MainController.fxml:
Lambda Lines: 141, 161, 179
Interface: FetchTables - 192
Function: public void updateTables(FetchTables func) - 199

LAMBDA SET 2:
src/MainController.fxml:
Lambda Lines: 237, 256, 264, 310, 328
Interface: errorLabelFunc - 497
Function: public void displayError( String text, errorLabelFunc func) - 504
