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
4. Open selenium-app project
5. Add all jar files to the project
- Go to project (selenium-app) > properties > Libraries
- Click Add External JARs
- Navigate to downloaded Selenium Webdriver
- Add all JAR files (include in /lib folder)
6. Install TestNG [Guide](https://www.guru99.com/install-testng-in-eclipse.html)

## Using the project
1. Open project in IDE (Eclipse)
2. Go to `selenium-app` > `src` > `com.storybook_app.login`
3. You should see `login-page.xml` file
4. Run `login-page.xml` file
5. You should see the test result in console.
