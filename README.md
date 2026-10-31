# SeleniumTest — Selenium Web UI Automation

A hands-on **Java + Selenium WebDriver + TestNG** project containing browser automation exercises against [DemoQA](https://demoqa.com/) and [The Internet (Heroku)](https://the-internet.herokuapp.com/). The repository demonstrates common UI testing workflows, reusable browser setup, Excel-driven data, logging, screenshots, browser navigation, and Selenium Grid.

> **Project type:** Learning / portfolio automation project. Some scenarios print results to the console rather than using TestNG assertions. Read each scenario's notes below for what it currently verifies.

## At a glance

| Area | Coverage |
|---|---|
| Browser automation | Chrome WebDriver, navigation, scrolling, element interaction |
| Test framework | TestNG (`@Test`, `@BeforeClass`, `@AfterClass`, `@DataProvider`) |
| Test data | Excel `.xlsx` files using Apache POI |
| UI scenarios | Alerts, checkboxes, dropdowns, text boxes, tables, windows/tabs, frames |
| Diagnostics | Log4j2, console/file logs, screenshot capture |
| Remote execution | RemoteWebDriver example for Selenium Grid |

## Test scenarios and code map

The source links below open the corresponding Java files in this repository. The table describes the implemented methods and behavior.

### DemoQA scenarios

| Test / class | What the code does |
|---|---|
| [`HomePageModulesAndSubmodules.titleValidation()`](src/test/java/demoqa/HomePageModulesAndSubmodules.java) | Reads the DemoQA homepage title and compares it with `demosite`; prints pass/fail. |
| `HomePageModulesAndSubmodules.itemsAndSubItems()` | Reads homepage category cards, visits each category, prints its displayed sub-items, and navigates back. |
| [`CheckBoxes.checkboxTest()`](src/test/java/demoqa/CheckBoxes.java) | Opens Elements → Check Box; expands Home/tree items, captures a screenshot, selects checkboxes, prints selected results, deselects Desktop, and checks that `desktop` is absent from the result text. |
| [`Dropdown.selectDropdown()`](src/test/java/demoqa/Dropdown.java) | Opens Widgets → Select Menu, counts and prints options in the standard select element, selects **Green**, and prints the selected value. |
| `Dropdown.hiddenMultiselectDropdown()` | Opens the custom multi-select, lists available options, and selects Green, Red, and Black when present. |
| [`Alerts.alert()`](src/test/java/demoqa/Alerts.java) | Opens the Alerts page, reads and accepts a JavaScript alert, and compares its text with the expected message. |
| `Alerts.timerAlert()` | Clicks the timer-alert button, waits, reads the alert text, and accepts it. |
| `Alerts.confirmationAlert()` | Dismisses the confirmation alert using Cancel and checks the displayed result text. |
| `Alerts.promptAlert()` | Enters text into a JavaScript prompt, accepts it, and prints the resulting page message. |
| `Alerts.handlingAlertWithExplicitWait()` | Uses `WebDriverWait` and `ExpectedConditions.alertIsPresent()` to wait for and accept an alert. |
| [`TextBoxFromExcelFile.readExcel()`](src/test/java/demoqa/TextBoxFromExcelFile.java) | Uses the inherited `LoginData` data provider to fill the Text Box form with name/email data, submits it, and prints the output. Includes Log4j2 messages and exception logging. |
| [`ExcelFile.readExcel()`](src/test/java/demoqa/ExcelFile.java) | Similar Excel-driven Text Box form workflow, using the shared base-class data provider. |
| [`WebTable.staticElements()`](src/test/java/demoqa/WebTable.java) | Reads table row/column counts, headers and cell values; retrieves a specific cell and searches for a row with salary `10000`. |
| `WebTable.dynamicWebTable()` | Adds 21 records using the Add button, fills form fields, submits each record, and reads the pagination text/page count. |
| [`WindowHandles.tabNavigation()`](src/test/java/demoqa/WindowHandles.java) | Handles a child browser window, a child tab, and a message window; switches back to the parent and closes child contexts. The message-window text is copied through the system clipboard with Java `Robot`. |
| [`ExcelFileWithoutInheritance.readExcelFullMethod()`](src/test/java/ExcelFileWithoutInheritance.java) | Standalone example (without the DemoQA base class) that reads name/email rows from Excel, submits the Text Box form for each data row, prints output, and closes the browser. |

### The Internet (Heroku) scenarios

| Test / class | What the code does |
|---|---|
| [`NestedFrames.handleNestedFrames()`](src/test/java/herokuapp/NestedFrames.java) | Opens Nested Frames, switches into the top frame and left frame to read text, moves to the middle frame, then returns to the top-level document. |

### Browser navigation and Grid examples

| Test / class | What the code does |
|---|---|
| [`NavigationMethods.navigate()`](src/test/java/NavigationMethods.java) | Demonstrates `get()`, `navigate().to()`, back, forward, refresh, and quit using Google and Amazon. |
| [`SeleniumGrid.seleniumGridTestGoogle()`](src/test/java/SeleniumGrid.java) | Creates a `RemoteWebDriver` session against a configured Selenium Grid endpoint, opens Google, prints the page title, and quits. |

### Other source file

| File | Purpose |
|---|---|
| [`AuthenticationPopup.java`](AuthenticationPopup.java) | Standalone `main()` entry point for an authentication-popup practice example. |

## Shared setup and framework utilities

### [`DemoqaBaseClass.java`](src/test/java/demoqa/DemoqaBaseClass.java)

DemoQA test classes extend this class to reuse browser setup and common helpers.

- `setup()` — TestNG `@BeforeClass`; initializes ChromeDriver, sets a 10-second implicit wait, opens `https://demoqa.com`, and maximizes the browser.
- `tearDown()` — TestNG `@AfterClass`; quits the driver.
- Scrolling helpers — keyboard Page Down, JavaScript scroll, scroll to element/center, and a document-ready wait.
- `removeAds()` — removes selected ad/footer/iframe elements from the page with JavaScript.
- `clickInterception()` — JavaScript click helper.
- `screenShots()` — captures a browser screenshot to `screenshots/test.png`.
- `getData()` — TestNG `@DataProvider(name="LoginData")`; reads rows and columns from an Excel worksheet using Apache POI and returns an `Object[][]`.

### [`HerokuAppBaseClass.java`](src/test/java/herokuapp/HerokuAppBaseClass.java)

Provides Chrome setup in headless mode, opens The Internet homepage, includes scrolling and JavaScript-click helpers, and closes the browser after a test method.

## Project structure

```text
SeleniumTest/
├── src/
│   └── test/
│       ├── java/
│       │   ├── demoqa/             # DemoQA tests + shared base class
│       │   ├── herokuapp/          # Heroku app tests + base class
│       │   ├── AuthenticationPopup.java
│       │   ├── ExcelFileWithoutInheritance.java
│       │   ├── NavigationMethods.java
│       │   └── SeleniumGrid.java
│       └── resources/
│           ├── log4j2.xml          # Log4j2 console and class-based file routing
│           └── docker-compose.yaml # Grid/container practice configuration
├── logs/                           # Example generated log files
├── screenshots/                    # Captured screenshot(s)
├── testng.xml                      # TestNG suite configuration
├── pom.xml                         # Maven build and dependencies
└── README.md
```

The ZIP also contains Eclipse workspace/project metadata and separate `sample` / `example` practice folders.

## Tech stack and dependencies

The `pom.xml` currently configures:

- Java compiler source/target: **21**
- Selenium Java: **4.40.0**
- TestNG: **7.12.0**
- Apache POI / POI OOXML: **5.2.5**
- Apache Commons IO: **2.15.1**
- Log4j2 API and Core: **2.26.1**

## Setup and run

### Requirements

- JDK 21 (or the Java version configured in `pom.xml`)
- Maven
- Google Chrome
- Eclipse IDE (optional)
- Git

### Clone

```bash
git clone https://github.com/Akhilagouru/SeleniumTest.git
cd SeleniumTest
```

### Import into Eclipse

1. Open Eclipse → **File → Import**.
2. Choose **Maven → Existing Maven Projects**.
3. Select the cloned repository directory and finish the import.
4. Right-click the project → **Maven → Update Project**.

### Run a specific class

In Eclipse, right-click a TestNG class or test method → **Run As → TestNG Test**.

### Run Maven tests

```bash
mvn clean test
```

### TestNG suite note

To execute the suite in Eclipse, right-click `testng.xml` → **Run As → TestNG Suite**. The Maven command runs according to the current Maven Surefire/TestNG configuration; suite selection may need configuration in `pom.xml` if you want Maven to use this XML suite explicitly.

## Excel test data

Excel-driven tests use Apache POI and a TestNG data provider named `LoginData` (or `TextboxSubmit` in the standalone example). The code expects a workbook with a `Sheet1` worksheet and columns for full name and email.

**Local setup note:** the current source contains a machine-specific Windows path to `Test.xlsx`. Update that path to your own workbook location, or refactor it to a repository-relative path before running the data-driven tests on another machine. The workbook currently present in the repository is at [`src/test/java/Test.xlsx`](src/test/java/Test.xlsx).

## Logging and screenshots

- Log4j2 configuration: [`src/test/resources/log4j2.xml`](src/test/resources/log4j2.xml)
- Log files are routed by class name to `logs/<ClassName>.log` when the relevant logger/context is used.
- Screenshot helper writes to `screenshots/test.png`.

Generated logs and screenshots can change after test execution; the committed examples are snapshots from prior runs.

## Selenium Grid

The Grid example uses a hard-coded endpoint in `SeleniumGrid.java`:

```java
new RemoteWebDriver(new URL("http://192.168.1.2:4444"), options);
```

To run it, start a reachable Selenium Grid and replace that URL with your Grid hub/router URL. The sample requests a browser named `MicrosoftEdge` while using `ChromeOptions`; update the options/capabilities to match the browser configured on your Grid.

## Current implementation notes

- Several tests report outcomes using `System.out.println()` and conditional checks; not every scenario uses TestNG `Assert` assertions.
- The Excel data provider currently uses a local absolute file path, which must be made portable for another user.
- Some test methods use fixed `Thread.sleep()` delays. Explicit waits are generally more resilient when the page provides a suitable condition.
- Browser setup in `DemoqaBaseClass` constructs `ChromeDriver` before the configured `ChromeOptions` are passed to it. If headless execution is required, pass the options into the driver constructor.
- The `testng.xml` suite currently selects only `ExcelFile`; it does not list every practice class.

## Author

**Akhila Gouru**

- GitHub: [@Akhilagouru](https://github.com/Akhilagouru)
- Repository: [SeleniumTest](https://github.com/Akhilagouru/SeleniumTest)
