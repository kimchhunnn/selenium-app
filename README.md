# selenium-app

## Prerequisite
1. Run a demo Vue 3 app in port 8080 [Application Repo](https://github.com/kimchhunnn/storybook-app)

## Setup Selenium Grid
1. Install Docker Desktop (if you have not)
2. Run docker compose
```
docker compose up -d
```
3. You should open `http://127.0.0.1:4444/` in your browser to confirm that your docker hub and node is up.
-  You should be redirected to Selenium Grid page
-  You should see two nodes: Firefox and Chrome; listed in Overview section.

## Project setup
1. Install Java JDK (based on your OS)
2. Install IDE (Eclipse)
3. Download [Selenium Webdriver v4.0.0](https://www.selenium.dev/downloads/) (Java)
4. Download [TestNG v7.4.0](https://jar-download.com/artifacts/org.testng/testng)
5. Open selenium-app project
6. Add all jar files to the project
- Copy all JAR files in just download selenium webdriver (include in /lib folder) and TestNG Jar file
- Paste all JAR files in root directory, folder called /lib (if not any, create one)
- Go to project (selenium-app) > properties > Libraries
- Click `Add JARs`
- Add all JAR files in `/lib` directory

## Using the project
1. Open project in IDE (Eclipse)
2. Go to `selenium-app` > `src` > `com.storybook_app.login`
3. You should see `login-page.xml` file
4. Run `login-page.xml` file
5. You should see the test result in console.

## To Run TestNG file from Terminal (MacOS)
1. Prerequisite
- Build .java file (by default Eclipse will build automatically when run the project save in `/bin` folder)
- All require JAR files must present (in this case `/lib` folder)
2. Command
- Full command
```
java -cp "<full_path_to_class_file>:<full_path_to_jar_file>/*" org.testng.TestNG <full_path_to_testng_xml>/<test_ng_xml_name>.xml
```
- Example: run directly from root directory of selenium-app project
```
java -cp "./bin:./lib/*" org.testng.TestNG ./suites/login-page.xml
```

