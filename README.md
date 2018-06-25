# FinalProject_Brackets

This is the final year project of UCD Computer Science 17/18.
This will be a stock exchange application based on web services and AI. 

# Live demo
Can be found in the Project Documentation

# Set Up locally 
  Prerequisite

  - Java 8
  - Apache Maven 3.5.0 or higer
  - Mysql 5.6 or higher
  - Node: 8.11.2 or higher 

 Set Up instructions

 - Clone the repo git clone https://github.com/Supitha/FinalProject_Brackets.git
 - cd FinalProject_Brackets

 Set up the Database

 - Source the stockexchange.sql 

 Running the micro service

- cd stockexchange
- edit the file /src/main/resources/application.properties according to your database configurations
- go back to stockexchange and run 
- mvn clean install
- java -jar target/stockexchange-0.0.1-SNAPSHOT.jar
- the microservice will run on port 8080

 Running the client 

Frontend of this project is made using Angular 6
- goto project root directory 
- cd stockexchange-client
- open up terminal/cmd in that directory and install dependencies by typing
- npm install -g @angular/cli
- npm install 
- ng-serve
- server will start at http://localhost:4200/

 Sample API request and responses

- List Stock data

Request 
```sh
GET  localhost:8080/stocks/all
```
Response 

```sh
[
    {
        "id": 1,
        "stockName": "WSO2",
        "price": 1028,
        "qty": 10,
        "sector": "GOV0"
    },
    {
        "id": 2,
        "stockName": "TELCO",
        "price": -843,
        "qty": 10,
        "sector": "GOV-1"
    }
]
```
- Check The balance of a player

Requet
```sh
POST localhost:8080/bank/balance

{
  "username": "Player-1"
}

```
Response 
 - Return 200 ok with balance to a existing account
 - Return No Account Registered Account for non-existing account