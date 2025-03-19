# ESW_TEST
Test framework for the ESW interview task
# Tools & Dependencies:
- Java JDK 21
- Maven (Build & Dependency Management)
- TestNG 7.7.1 (Test Framework)
- Selenium 4.9.1 (UI automation-Testing Library)
- webdrivermanager 5.6.2 (to handle browser drivers)
# how to Run tests:
## 1 Clone repository 
`git clone https://github.com/your-username/selenium-test-framework.git`

Open a terminal or command prompt.
Navigate to the project root directory.
`cd selenium-test-framework`
## 2 Install Dependencies
`mvn clean install`

## 3 Running Tests
`mvn test`

This will execute the tests as per the pom.xml configuration.
## Or Run with TestNG Suite

`mvn test -Dsurefire.suiteXmlFiles=testng.xml`

###  Alternativly Running TestNG Suite in an IDE

Open the project in any Java IDE (such as IntelliJ IDEA, Eclipse, or VS Code).

Locate the testng.xml file in the project’s root folder.

Right-click on testng.xml and select Run as TestNG Suite.

The test results will be displayed in the TestNG report section.
