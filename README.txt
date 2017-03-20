The test suite has been created to be used with a Jenkins server and the cucumber pluggins.

The test suite has been created to be executed on a Windows OS.

It has been created with Selenium WebDriver, Cucumber and Junit. All tests are located in the Regression.feature file in plain text. The corresponding glue code is in the CommonSteps class.

In an ideal world there would be multipe .feature files and multiple Steps classes for each .feature file.

In an ideal world all tests would be included within the automated regression suite and the cucumber tags would be used to limit the tests run at runtime.

In an ideal world multiple OS & browsers would be supported and passed in as an arguements.

To run the test suite via the command line use: mvn clean test (if issues with privileges to delete files are present use: mvn test)