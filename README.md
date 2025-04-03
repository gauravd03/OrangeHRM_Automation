**OrangeHRM Selenium Test Automation Project**

This is an automated testing project for the OrangeHRM application. OrangeHRM is a popular Human Resource Management software used for managing employee data, recruitment, and performance. It helps organizations streamline HR processes and improve workforce efficiency. this project supports cross-browser testing and parallel execution using TestNG's capabilities. The test data is managed via Excel files and Properties file
.....................................................................
**Framework Type  **    -> Hybrid 
  1.Selenium Webdriver :Java library to communicate with browser
  2.TestNG             : To manage test execution & reporting 
  3.POM with Factory   : To acheive reusability & maintanibility of code
  4.Apachi POI         : To manage data in excel file (DDT)
  5.Log4j              : To maintain logs to help in debugging
  6.Maven              : To build , manage project and dependacies
  7.GIt                : Version control system
  8.Jenkins            : CI/CD

.....................................................................
 ** Framework Structure:**
  /OrangeHRM-Test-Automation
    ├── /src
    │   ├── /test
    │   │   ├── /java
    │   │   │   ├── /pageObjects
    │   │   │   ├── /testCases
    │   │   │   ├── /utils
    │   │   ├── /resources
    │   │   │   ├── config.properties
    │   │   │   ├── log4j.properties
    │   │   │   │   ├── testData.xlsx
    ├── /logs
    ├── /target
    |── /Screenshots
    ├── pom.xml
    |──testng.xml
    |──CrossBrowserTest.xml
    └── README.md
...................................................................
**Features:**
  1.Parallel Testing 
  2.Cross Browser Testing 
  3.Data Driver Approach using Apachi POI 
  
**Dependancies Added ** -> Selenium-java, log4j(3), extentreport, apachiPOI(2), commonsIO(2)

Main Factors of Framework:
1.Code reusibility
2.Test Data Management
3.Reporting 
4.Configuration


...............................................................

**Implementation**
**. Implement Log4j for Logging:**
Logging in Log4j records events during test execution, helping to debug defects by providing detailed logs in a text format.

Steps to Implement Log4j:
1.Add Log4j Configuration File    -: Place a log4j.xml or log4j.properties file under src/test/resources/. This configuration file contains appenders (where to generate logs: Console/File) and loggers (which type of logs to generate: Trace, Debug, Info, Warn, Error, Fatal, Off).
2.Update BaseClass                -: In your BaseClass, create a logger object and initialize it by passing the name of the class. This logger will be used throughout the test classes to log events at different levels (e.g., INFO, ERROR).
3.Add Log Statements in Test Class-: In the test class, use the logger object to record logs at different levels (logger.info(), logger.error(), etc.), depending on the event or condition being tested.
......................................................
**Implement Properties File**
1.Create a config.properties file in the src/test folder, which will contain configuration data.
2.Write code to load the file data into a Properties object using three lines of code in the @BeforeClass method.
3.Replace hardcoded values in your test scripts with values retrieved from the config.properties file.
............................................................
** Cross-Browser Testing Setup:**
Steps for Cross-Browser Testing:
1.Create Separate testng.xml for Cross-Browser Setup-: Create a separate testng.xml file to define the browser configuration. Pass the browser name as a parameter (e.g., <parameter name="Browser" value="Chrome"/>), which will then be used to initialize the corresponding WebDriver.
2.Use @Parameters Annotation-: In setup method, use the @Parameters annotation to fetch the browser value from the XML file. Based on the browser parameter, use a switch-case or if-else block to initialize the corresponding browser driver.
3.Add Parallel Execution in testng.xml-: To run tests in parallel across different browsers, configure the parallel="tests" attribute in the <suite> tag in the testng.xml file. This will run each test with different browser configurations simultaneously.
..........................................................
**DDT**
1.Add dependancies 2, POI & POI-OOXMl
2.Create excel utility file under utility package . which contain code to read excel file data
3.Using testng data provider pass parameters to @Test method

............................................................
**Extent Report**
1.Add dependancies 
2.Then use three classes to implement -
 1.ExtentReports       -: Main engine of extent report / handle whole reporting 
                       [  ExtentReports() extent =new ExtentReports();  ]                              -> creating instance for one report
 2.ExtentSpartReporter  -: Use to just specify which type of report we want and we attach it to engine
                       [  ExtentSpartReporter sparkReporter= new ExtentSpartReporter("path/name.html");  ]   -> created spark report type object 
                       [   extent.attachReporter(sparkReporter);    ]                                        -> attaching to main report to specify type of report
                          
 3.ExtentTest          -: use to store each test instance / 
                      [ ExtentTest test=extent.createTest("Test case 1");   ]   -> Creating test to log Testmethod detail in report / this return ExtentTest type  object .
                      [test.pass("test case pass');                         ]   -> using above object login details related to method execution (pass/info)
                      [test.log(Status.PASS,"test pass");                   ]    -> another way to log details/ other levels available -Fail/skip/warning/pass/info


                     test.addScreenCaptureFromPath(path);                      -> To add screenshot for test

Note * always on finish flush the report ->  extent.flush()                   ->  else we will not get report saved 




