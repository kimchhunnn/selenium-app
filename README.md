# selenium-app

## Prerequisite
1. Run a demo Vue 3 app in port 8080 [Application Repo](https://github.com/kimchhunnn/storybook-app)

#### Notice
If you are not open this project in MacOs you may skip `safaridriver` in project setup and remove `<test>` dom name `Login Page - Safari` in `login-page.xml` file.

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
6. Download chromedriver `https://chromedriver.chromium.org/downloads` match with your Google Chrome version
7. Find SafariDriver in MacOS (Big Sur) 
- Finder: `Go to Folder` > `'/usr/bin'`
- You may see `safaridriver` alias file
- Right click on `safaridriver` alias file > Show Original
- Copy `safaridriver`
8. Place driver
- Finder: `Go to Folder` > `'/usr/local/bin'`
- Place `chromedriver` and `safaridriver` files in this folder
9. Install TestNG [Guide](https://www.guru99.com/install-testng-in-eclipse.html)

## Using the project
1. Open project in IDE (Eclipse)
2. Go to `selenium-app` > `src` > `com.storybook_app.login`
3. You should see `login-page.xml` file
4. Run `login-page.xml` file
5. You should see the test result in console. 
