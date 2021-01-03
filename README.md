# spring-selenium-seavus

Navigate to the root of project:

``~/{path}/selenium-demoqa``

Run tests locally with command in chrome:

``mvn clean test -Dbrowser=chrome``

Run tests locally with command in firefox:

``mvn clean test -Dbrowser=firefox``

To start Selenium Grid, first go to the location where docker-compose.yaml file is located,
 then run the file in terminal with command:

``docker-compose up``

Run tests remote (Selenium Grid) with command in chrome:

``mvn clean test -Dbrowser=chrome -Dspring.profiles.active=remote``

Run tests remote (Selenium Grid) with command in firefox:

``mvn clean test -Dbrowser=firefox -Dspring.profiles.active=remote``

Reports are generated within ``target/surefire-reports/index.html``

We can also run the tests using Cucumber runner, follow the next steps:

Do the packaging first:

``mvn clean package -DskipTests``

Navigate to target directory:

``cd target/``

Parallel running tests, Cucumber runner, with command (use ``-Dspring.profiles.active=remote`` if you want to run tests in Selenium Grid using Docker-compose file):

``java -cp spring-boot-selenium.jar:spring-boot-selenium-tests.jar:libs/* -Dbrowser=chrome -Dspring.profiles.active=remote io.cucumber.core.cli.Main classpath:features --glue com.seavus.qa.seleniumdemoqa.bdd --tags "@dev" --add-plugin html:test-output/ --threads 2``

Report this time is generated within folder ``target/test-output/``

This project can be extended with implementing BDD framework (Cucumber)
and running on AWS machine using Jenkins CI.
# selenium-demoqa
