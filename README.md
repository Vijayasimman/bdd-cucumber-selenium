# bdd-cucumber-selenium
A test project built based on behavior driven development framework with cucumber, selenium, java
This project can be used to automate high quality UI, functional and acceptance tests, with reporting features.

### The project directory structure
The project follows the standard directory structure used in most bdd projects:
```Gherkin
src
  + main
  + test
    + java                        Test runners and stepdefinitions
    + resources
      + features                  Feature files
```
## Executing the tests
To run the project, you can navigate to src/test/java/testrunner pakage and right click file 'UpdateUserDetailsTest.java' > Run As > JUnit Test.
By default, the tests will run using Firefox. You can run them in Chrome by overriding the tags value in 'UpdateUserDetailsTest.java' file, e.g.
```json
@CucumberOptions(features = "src/test/resources/features", glue = "stepdefinitions", tags = "@firefox")
```
Or
```json
@CucumberOptions(features = "src/test/resources/features", glue = "stepdefinitions", tags = "@chrome")
```

The test results will be recorded in the `target\site\reports` directory.
