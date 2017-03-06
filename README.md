# Instant Bank Stat [![Build Status](https://travis-ci.org/sinanselimoglu/instantbank.svg?branch=master)](https://travis-ci.org/sinanselimoglu/instantbank)

##Description
Stats service designed for receiving transaction notification via rest call and return statistics about last 60 seconds.

##Assumptions

Timestamp data accepted as unique variable.

##Usage

 Run app via below command;
 
 ```
 java -jar stats-0.0.1.jar server config.yaml
 ```

 Send transaction data via cUrl code. (Postman export also included.)
 
 ```
 curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
 	"amount":20,
 	"timestamp":1488760603000
 }' "http://localhost:8082/transactions"
 ```

 For receiving statistics about last 60 seconds, you can use below command
 
 ```
 curl -X GET -H "Cache-Control: no-cache" "http://localhost:8082/statistics"
 ```