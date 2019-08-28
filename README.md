# Angular and Spring application
* an application that has been build with angular 6 ,hibernate,bootstrap 4,java7 and the spring framworks : spring boot,spring mvc,spring data jpa 
* it is a maven application it is a CRUD application that allows to manage the stock of products each product has three characteristics: name, price, quantity
* this application allows you to consult the products on the database, add a product in the database, search for a product according to its ID and delete it from the database and also be able to add a user account to the database which will allow you to access the application 
* the database tables will be automatically updated once you execute the code of the backend you shold just have a database named prductapp  where you import the fill productapp and have the mysql server on port 3306 
* the server backend listening port 9090 and the frontend use port 4200 all the servers ports and database configurations can be modified on the file application.propriety in the backend and by executing the command ng serve --port X for the frontend on the terminal IDE when you execute the frontend code
## Running the application locally
* for the backend : 

git clone https://github.com/ALLAMSOUKAINA/angular-and-spring-application-the-backend-part.git

cd angular-and-spring-application

./mvnw package

java -jar target/*.jar
* for the front end : 

git clone https://github.com/ALLAMSOUKAINA/angular-and-spring-application-the-front-end.git


* You can then access the application here: http://localhost:4200/

## Working with the application in your IDE
### Prerequisites
#### back end :
* Java 7 or newer. 
•	git command line tool (https://help.github.com/articles/set-up-git) 
* Your preferred IDE Eclipse . 
* Spring Tools Suite (STS) 
#### front end :
* VS Code
* webstorm 
* atom 
* node js

### Steps:
#### for the back end
+ run mysql server using the port 3306
+ On the command line git clone https://github.com/ALLAMSOUKAINA/angular-and-spring-application-the-backend-part.git 
+ Inside Eclipse or STS File -> Import -> Maven -> Existing Maven project Run the application main method by right clicking on it and choosing Run As -> spring Application.

#### for the front end
+ Inside VS Code or webstorm or atom File -> open folder and choose de folder of the front end
