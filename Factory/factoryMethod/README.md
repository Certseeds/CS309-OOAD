# Task 3
Refactoring the code to factory method design pattern by following steps.

## Step 1 

Create a package named **factoryMethod**, then copy your source code here.

## Step 2

Modify it to factory method design pattern.

**Hints**: Create an interface named **ITStaffFactoryInterface**, and then created three concretefactory classes to implements the interface.

Those three factory can be named as follows:`ITManagerFactory` `DeveloperFactory` `TesterFactory`

## Step 3 

Adding an concrete class named **ArtDesigner** and we can describe it as follows:  
+ Attributes:
  - level: the value is from 1 to 5
  - Starting Salary: 7000
  - name: userID+" "+"ArtDesigner"
  For other attributes are similar to Developer or Tester classes.

+ Method:
  - Constructor and toString method are similar to which in Developer or Tester classes.
  - working: It needs to return "Art Design"
  - getSalary: startSalary+ level*1500

## Step 4

Input type for clientInput 1 means an instance of ITManager has been created.
Input 2 means an instance of Developer has been created.
Input 3 means an instance of Tester has been created.
Input 4 means an instance of ArtDesigner has been created.
Input 5 means print out all user information by order of salary.
Input 6 means print out all user information by order of working.
Input 0 can stop the program

```
1 2 3 4 5 6 0
All information:
Testing     name: 10003 Tester   , salary: 12500
Coding      name: 10002 Developer, salary: 14000
Art Design  name: 10004 ArtDesigner, salary: 14500
IT Manager  name: 10001 ITManager, salary: 30000, bonus in the end of year 27000
All name:
IT Manager  name: 10001 ITManager, salary: 30000, bonus in the end of year 27000
Coding      name: 10002 Developer, salary: 14000
Testing     name: 10003 Tester   , salary: 12500
Art Design  name: 10004 ArtDesigner, salary: 14500
```