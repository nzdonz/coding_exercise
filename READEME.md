##### Coding-Exercise


###### Set Up

(When you first clone this repository you will need to make a copy of the application.propertiesEXAMPLE file 
and rename to application.properties and set the emailaddresslogin and password to the ones I will email to Bridget Carson

You will also need to install Java and Maven if not already on your machine

I have used WebDriverManager so there is no need to download Chromedriver separately as this should do it for you

###### Running tests

Simply ensure the application.properties file is populated with the username and password emailed to Bridget

To run any feature files from the Run Config within Intellij, the set up is as follows:

Create a new junit config and add this command into the VM options field

-ea "-Dcucumber.options= --tags @addbankaccount"




