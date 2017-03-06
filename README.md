# Instant Bank Stat [![Build Status](https://travis-ci.org/sinanselimoglu/instantbank.svg?branch=master)](https://travis-ci.org/sinanselimoglu/instantbank)

##Description
Stats service designed for receiving transaction notification via rest call and return statistics about last 60 seconds.

##Assumptions

Timestamp data accepted as unique variable.

##Solution

All of the transactions are stored in sorted tree map. Map's key field
used as transaction's timestamp value and value field is transaction itself
so getting sub map of tree map could be more efficient.

After receiving transactions, avg, min, max, sum and count calculated with the help 
of java 8's new stream api. There are ready to use jdk methods for those calculations
however it forces you to do same thing multiple times. Rather than finding those
variables in 5 independent function, java 8's reduce method used and find all of them
in one traversal.

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