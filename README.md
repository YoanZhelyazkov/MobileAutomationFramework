# Accelerator Framework Guide (Serenity BDD):

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.

### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
	+ docker
		docker-compose.yml             docker compose file for selenim hub configuration
	+ resources
		+webdriver
			+ windows
				chromedriver.exe          OS-specific Webdriver binaries
  + test
    + java                          Test runners and supporting code
		+ db
			(DB specific steps and suites files)
		+ rest
			(Rest API specific steps and suites files)
        + ui
			(Selenium WebDriver specific steps and suites files)
    + resources
      + features                    Feature files
        + db                    Feature file subdirectories 
			example_database_request.feature
		+ rest
			users_management.feature
        + ui
			search_for_Companies.feature
			search_for_Industry.feature
			search_for_Region.feature

```


## The Cucumber 4 sample scenario
Both variations of the sample project uses the sample Cucumber scenario. In this scenario, Sergey (who likes to search for stuff) is performing a search on the DuckDuckGo search engine:

```Gherkin
Feature: As a user I want to be able to search for Industries
  Acceptance Criteria:
  1. Search functionality is available in the site
  2. Searching is private

  Scenario Outline: Searching for Industries
    Given I go to the DuckDuckGo home page
    When I search for '<Industry>'
    Then all the results should contain the word '<Industry>'
    Examples:
      | Industry |
      | Banking  |
      | IT       |
```

The glue code for this scenario uses both regular expressions and cucumber expressions. The glue code looks this this:

```java
    @Given("^(?:.*) go to the DuckDuckGo home page")
    public void goToHomePage() {
        home.openHomePage();
    }

    @When("I search for {string}")
    public void searchFor(String term) {
        searchBar.searchForTerm(term);
    }

    @Then("all the results should contain the word {string}")
    public void verifyAllResultsContainTheWord(String term) {
        assertThat(searchResult.getTitles())
                .matches(results -> results.size() > 0)
                .allMatch(title -> TextMatcher.textOf(title).containsIgnoringCase(term));
    }
```

The `@Given` step uses a regular expression; the action class approach we use here is action-centric, not actor-centric, so we ignore the name of the actor.

The `@When` and `@Then` steps uses Cucumber expressions, and highlights two useful features. Rather than using a regular expression to match the search term, we use the more readable Cucumber expression _{string}_. This matches a single or double-quoted string (the quotes themselves are dropped). Cucumber 4 also supports other typed expressions, such as _{int}_, _{word}_, and _ {float}_.
.
### Page Objects and Action Classes
The glue code shown above uses Serenity step libraries as _action classes_ to make the tests easier to read, and to improve maintainability.

These classes are declared using the Serenity `@Steps` annotation, shown below:
```java
    @Steps
    Home home;

    @Steps
    SearchBar searchBar;

    @Steps
    SearchResult searchResult;
```

The `@Steps`annotation tells Serenity to create a new instance of the class, and inject any other steps or page objects that this instance might need.

Each action class models a particular facet of user behaviour: navigating to a particular page, performing a search, or retrieving the results of a search. These classes are designed to be small and self-contained, which makes them more stable and easier to maintain.

The `Home` class is an example of a very simple action class. In a larger application, it might have some other methods related to high level navigation, but in our sample project, it just needs to open the DuckDuckGo home page:
```java
public class Home extends PageObject {
    @Step("Open the home page")
    public void openHomePage() {
        this.open();
    }
}
```
## Executing the tests
How to execute test in parallel (local without docker and selenium grid)
 - Execute 'mvn clean verify -PParallel -f pom.xml'
How to execute test in parallel on docker with selenium grid
 - Install docker on the executor
 - Open terminal and navigate to <AutoTestProject>src\main\resources\docker
 - Execute "docker-compose up"
 - Execute 'mvn clean verify -Dwebdriver.remote.url=http://localhost:4444/wd/hub -Dwebdriver.remote.driver=chrome
     -PParallel -f pom.xml'
How to execute tests on different environments
 - Types of environments are specified in serenity.conf file
 - E.g. Execute 'mvn clean verify -Denvironment=dev -f pom.xml'  to execute the testa against the dev environment
How to execute tests in headless mode
 - Headless property is specified in serenity.conf file
 - E.g. Execute 'mvn clean verify -Dheadless.mode=true -f pom.xml'  to execute the tests in headless mode

## Simplified WebDriver configuration and other Serenity extras
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.
### Webdriver configuration
The WebDriver configuration is managed entirely from this file, as illustrated below:
```java
webdriver {
    driver = chrome
}
headless.mode = true

chrome.switches="""--start-maximized;--test-type;--no-sandbox;--ignore-certificate-errors;
                   --disable-popup-blocking;--disable-default-apps;--disable-extensions-file-access-check;
                   --incognito;--disable-infobars,--disable-gpu"""

```

The project also bundles some of the WebDriver binaries that you need to run Selenium tests in the `src/test/resources/webdriver` directories. These binaries are configured in the `drivers` section of the `serenity.conf` config file:
```json
drivers {
  windows {
    webdriver.chrome.driver = "src/test/resources/webdriver/windows/chromedriver.exe"
  }
}
```
This configuration means that development machines and build servers do not need to have a particular version of the WebDriver drivers installed for the tests to run correctly.

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _staging_ and _prod_, with different starting URLs for each:
```json
environments {
  default {
    webdriver.base.url = "https://duckduckgo.com"
    database.postgres.package.name = "org.postgresql.Driver"
    database.postgres.local.url = "jdbc:postgresql://localhost:5432"
    database.postgres.local.username = "postgres"
    database.postgres.local.password = "admin"
  }
  dev {
    webdriver.base.url = "https://duckduckgo.com/dev"
    database.postgres.package.name = "org.postgresql.Driver"
    database.postgres.local.url = "jdbc:postgresql://localhost:5432"
    database.postgres.local.username = "postgres"
    database.postgres.local.password = "admin"
  }
  staging {
    webdriver.base.url = "https://duckduckgo.com/staging"
    database.postgres.package.name = "org.postgresql.Driver"
    database.postgres.local.url = "jdbc:postgresql://localhost:5432"
    database.postgres.local.username = "postgres"
    database.postgres.local.password = "admin"
  }
  prod {
    webdriver.base.url = "https://duckduckgo.com/prod"
    database.postgres.package.name = "org.postgresql.Driver"
    database.postgres.local.url = "jdbc:postgresql://localhost:5432"
    database.postgres.local.username = "postgres"
    database.postgres.local.password = "admin"
  }
}
```

### Reports
    The report is located in the target→ site→ index.html file

### Azure DevOps Integration

In order to integrate Serenity BDD project in Azure DevOps and to present Serenity's Results report, a static website should be created and Azure DevOps pipeline configured.

Steps to create static website
Create new resource - "Storate Account" in Azure portal
Account kind: StorageV2 (general purpose v2)
Replication: Read-access geo-redundant storage (RA-GRS)
Performance/Access tier: Standard/Hot
Enable 'Static Website' in the storage account
Set index document name to - index.html
An Azure storage container is created to host your static website - $web
Save the static website primary endpoint:(Example: https://testreportsite.z6.web.core.windows.net/ )
Steps to configure Azure DevOps pipeline:
Create new pipeline

Select source(<your automation project repository>)

Add 'ScreenResolutionUtility' (Optional):

displaySettings: 'specific'
width: '1920'
height: '1080'
Add 'Maven' task:

condition: always()
vmimage: "windows latest"
publishJUnitResults: true (Optional)
testResultsFiles: '**/cucumber-reports/<aggregated junit result file>.xml' (If there are several junit result files generated, add a file mask to match them all)
goals: 'clean verify'
options: '-Dtags=UI -Dfailsafe.rerunFailingTestsCount=2 -Dwebdriver.chrome.driver=$(ChromeWebDriver)/chromedriver.exe' (This is optional configuration)
Add 'Azure file copy' task:

condition: always()
SourcePath: '$(System.DefaultWorkingDirectory)\target\site\serenity'
azureSubscription: '<your subscribtion>'
Destination: 'AzureBlob'
storage: '<your storage account>'
ContainerName: '$web'
Additional project configuration (Serenty + Cucumber)

Add junit plugin to Cucumber suites configuration. Example:
@CucumberOptions(plugin = {"junit:target/cucumber-reports/<aggregated junit result file>.xml"})
Run created pipeline - After execution, test results can be found in <pipeline run>/Tests tab. And Serenity report is published at the static website (Example: https://testreportsite.z6.web.core.windows.net/ )
azure-pipelines.yml file example

trigger:
- master

pool:
  vmImage: 'windows-latest'

steps:
- task: ScreenResolutionUtility@1
  inputs:
    displaySettings: 'specific'
    width: '1920'
    height: '1080'

- task: Maven@3
  inputs:
    mavenPomFile: 'pom.xml'
    mavenOptions: '-Xmx3072m'
    javaHomeOption: 'JDKVersion'
    jdkVersionOption: '1.8'
    jdkArchitectureOption: 'x64'
    testRunTitle: 'EY Breta Automation'
    publishJUnitResults: true
    testResultsFiles: '**/cucumber-reports/Cucumber*.xml'
    goals: 'clean verify'
    options: '-Dtags=UI -Dfailsafe.rerunFailingTestsCount=2 -Dwebdriver.chrome.driver=$(ChromeWebDriver)/chromedriver.exe'

- task: CmdLine@2
  condition: always()
  inputs:
    script: 'dir $(System.DefaultWorkingDirectory)\target\'

- task: AzureFileCopy@3
  condition: always()
  inputs:
    SourcePath: '$(System.DefaultWorkingDirectory)\target\site\serenity\'
    azureSubscription: 'BRETA-NEW-SC'
    Destination: 'AzureBlob'
    storage: 'testreportsite'
    ContainerName: '$web'

