# AutoTool-Transcy

1. Install:
   - Install JDK: https://www.oracle.com/java/technologies/downloads/#jdk20-windows
   - Install IntelliJ IDEA: https://www.jetbrains.com/idea/download/#section=windows
   - Setting in file pom.xml(Search and copy dependency code to file pom.xml follow title below): https://mvnrepository.com/
     + Selenium Java
     + TestNG
     + WebDriverManager
     + ....

2. Run:

   2.1 TRANSCY:
      - Run by file: Right click on "src/test/java/transcy/createStoreAndInstallApp.java
        + Can run all file or run follow @Test(TestNG)
      - Run by XML file: Right click on "src/test/java/resources/runTranscyTool.xml
        + Can run all classes or run follow method

   2.2 SWIFT (Install Store Test):
       2.1.1 Config Data:  
          - Config in file: "src/main/java/configs/swiftConfig: Account & Password Partner - Recovery Code - Store name
          - Config Store name: Get Store name in file Config + Count in For loop. Example: 
            + Store name in file Config: storeName = "store-test-swift-staging-"
            + Count in For loop: Count = 1; Count<=100; Count++ 
            + Store name full: store-test-swift-staging-1
       2.1.2 Run Test:  
          - Config Number of store create in file: "src/test/java/swift/createStoreTestInSwiftPartner
            + Change number of Count in For loop. Example: Change Count = 1; Count<=100 -> Will create store from 1 -> 100
          - Run by file: Right click on "src/test/java/swift/createStoreTestInSwiftPartner.java
            + Can run all file or run follow @Test(TestNG)
          - Run by XML file: Right click on "src/test/java/resources/createStoreTestInSwiftPartner.java 


   

