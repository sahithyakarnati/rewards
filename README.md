This project will calculate rewards for user purchases.


In order to run this application, Please run

Run DemoApplication.java file

This project contains two endpoints 

1. SavePurchase

2. Generate Report



Save Purchase:
This Endpoint is used to save the purchase information of a user

Below is the request payload

aidl
POST: localhost:8080/purchase

{
	"userId": "userId",
	"purchaseInfo": "Shopping",
	"price": 300,
	"date": "28-03-2020"
}



Generate Report:
This Endpoint is used to generate the list of purchases between two different dates and gives the total rewards earned during the period


POST localhost:8080/generateReport

{
	"fromDate": "27-02-2020",
	"toDate": "28-03-2020",
	"userId": "userId"
}
