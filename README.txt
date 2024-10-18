LIBRARY MANAGEMET SYSTEM
----------------------------

Prerequisites
	java JDK.
	Maven.
	IntelliJ IDEA.

Importing the project
	Download the zip file of the project using the git link = https://github.com/Dhanushanandan/LMS_EAD2_CW.git
	Extract the files and Right click and open with IntelliJ
	wait until the necessary dependency download it might need internet connection. 

Import the database
	Inside database folder import the .sql file into your empty database in phpMyAdmin.
	In IntelliJ find application.properties file under src/main/resources and change the 	database name into your database name

RUN the project
	start the xampp server Apache and MySQL server. 
	Click the run button and wait for the tomcat server start.
	Search in browser http://localhost:8080

	IF You using Post man
		API Endpoints
			Books:

				POST /LMS/books : Add a new book
				GET /LMS/books/{id} : Get details of a specific book
				PUT /LMS/books/{id} : Update book details
				DELETE /LMS/books/{id} : Delete a book
			Members:

				POST /LMS/members : Add a new member
				GET /LMS/members/{id} : Get details of a specific member
				PUT /LMS/members/{id} : Update member details
				DELETE /LMS/members/{id} : Delete a member
			Memberships:

				POST /LMS/memberships : Add a new membership
				GET /LMS/memberships/{id} : Get membership details
				PUT /LMS/memberships/{id} : Update membership
				DELETE /LMS/memberships/{id} : Delete a membership