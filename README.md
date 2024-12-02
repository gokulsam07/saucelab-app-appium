# appium-framework

This is a sample mobile automation framework designed using Java, Selenium/Selenide, Appium 2.0 & some of appium plugins

### Prerequisites

* Java
* Selenium/Selenide
* Appium
* TestNG

### Installation

1. Clone the repository: `git clone https://github.com/gokulsam07/saucelab-selenide-appium.git`

### Project Structue

```
saucelab-app-appium/                                  # root dir
├── src/main/java                                              
     ├── appiumutils/                                 # utils to start the appium server                    
     ├── drivers/                                     # driver setup
     ├── elementutils/                                # utility methods for element finding
     └── screens/                                     # screen objects & actions                 
├── src/test/java
     ├── base/BaseTest.java                           # Base tese method for extension                 
     └── tests/**                                     # test files                       
├── pom.xml                                           # dependency management
├── apps/                                             # apps used for test 
└── testng.xml                                        # test distribution using testng.xml

```
