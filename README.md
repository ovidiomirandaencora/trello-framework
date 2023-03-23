# trello-framework
# Execute tests
### Command line
```shell
gradle clean executeFeatures -Pbrowser="CHROME" -PbaseUrl="https://trello.com" -Puser="myusername@gmail.com" -Ppassword="mypassword" -PapiUrl="https://api.trello.com/1" -PapiKey="c60889565e7519a1123b1eea05a8592e"  -PapiToken="9rc055cf5be4d891eba711d2" 
```
### Short command
You need to put the information of those parameters in 'gradle.properties' because that data will be used to run the scenarios.  
Run a specific scenario:  
"@TC-00001" - Specific test case.
```shell
gradle clean executeFeatures -Dcucumber.filter.tags="@TC-00001"
```
Tags examples:
- Regression
- Smoke
- Acceptance
- Functional
- e2e
- Negative
- Boundary

Example:  
"@Regression" - All test cases.  
```shell
gradle clean executeFeatures -Dcucumber.filter.tags="@Regression"
```
### Full command
You can send all these parameters:
```
Example:  
-Pbrowser="CHROME" 
-PbaseUrl="https://trello.com" 
-Puser="ovidiocbba@hotmail.com" 
-Ppassword="xxxxxxxxxx" 
-PapiUrl="https://api.trello.com/1" 
-PapiKey="c60889565e7519a1123b1eea05a8592e" 
-PapiToken="9rc055cf5be4d891eba711d2"
```
```shell
gradle clean executeFeatures -Dcucumber.filter.tags="@TC-00001" -Pbrowser="CHROME" -PbaseUrl="https://trello.com" -Puser="myusername@gmail.com" -Ppassword="mypassword" -PapiUrl="https://api.trello.com/1" -PapiKey="c60889565e7519a1123b1eea05a8592e"  -PapiToken="9rc055cf5be4d891eba711d2"
```
```shell
gradle clean executeFeatures -Dcucumber.filter.tags="@Regression" -Pbrowser="CHROME" -PbaseUrl="https://trello.com" -Puser="myusername@gmail.com" -Ppassword="mypassword" -PapiUrl="https://api.trello.com/1" -PapiKey="c60889565e7519a1123b1eea05a8592e"  -PapiToken="9rc055cf5be4d891eba711d2"
```
After execution a report is generated.

#### To view the report
It must first be located at the following path:
```
trello-framework\build\allure
```
Press the 'Shift' key on your keyboard and right-click on an empty space in the explorer window. Click on the Open Command Window option from here.
And type the following command:
```
allure open
```
And then the browser will open, and you can view the report.
