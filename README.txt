how to install and run the Trainer API
0- JDK15 must be in the classpath
1- clone into intellij from url: https://github.com/hjbarbieri/trainerApi.git
2- run mvn clean package
3- go to com.gladiator.trainer.TrainerApplication and run the main method
4- In the browser go to http://localhost:8081/swagger-ui/index.html?configUrl=/api-docs/swagger-config#/trainer-controller/saveTrainer
-- Because It is using a H2 in memory DB, we can save and read Trainer BO.

5- go to POST method under: POST /api/v1/trainers
6- press into try it out button
7- copy json body
{
"trainerId" : "trainer-id-000001",
"email" : "trainer@campgladiator.com",
"phone" : "5125125120",
"firstName": "Javier",
"lastName": "Barbieri"
}
8- go to GET method under GET /api/v1/trainers/{id}
and add the id = 1

--Run with JAR
1- mvn clean install
2 to run with the jar into the terminal: java -jar trainer-0.0.1-SNAPSHOT.jar

--Next steps
1- Create endpoint for DELETE
2- Create endpoint for UPDATE
3- Create tests
4- Add logs into all the Api
5- Set up a DB not In memory like Postgres


