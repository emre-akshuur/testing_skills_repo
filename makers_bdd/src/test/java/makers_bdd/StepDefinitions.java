package makers_bdd;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {

    private final WebDriver driver = new FirefoxDriver();
    //private final WebDriver driver = new ChromeDriver();

    @Given("I am on the Makers FAQ page")
    public void I_visit_faq_page() {
        driver.get("https://faq.makers.tech/en/knowledge");
    }

    @Given("I am on the Makers homepage")
    public void I_visit_makers_homepage() {
        driver.get("https://makers.tech");
    }

    @When("I search for {string}")
    public void search_for(String query) throws InterruptedException {
        WebElement mainSearch = driver.findElement(By.id("hs_kb-search-input-module-input"));
        mainSearch.click();
        mainSearch.sendKeys(query);
        mainSearch.submit();
        Thread.sleep(3000); // We should really use a dynamic wait!
    }

    @When("I click the {string} link")
    public void i_click_the_link(String linkText) throws InterruptedException {
//        Only works on Chrome
//        WebElement faq = driver.findElement(By.linkText("FAQ"));
//        assertEquals("FAQ", faq.getText());
//        new Actions(driver).moveToElement(faq).perform();
//        faq.click();
//        //Once FAQ link is clicked, a new tab opens, we need to navigate to the new tab
//        Object[] windowHandles=driver.getWindowHandles().toArray();
//        driver.switchTo().window((String) windowHandles[1]);

        //Firefox
//        new Actions(driver).scrollByAmount(0, 2500).perform();
//        Thread.sleep(2000);
//        WebElement faq = driver.findElement(By.linkText("FAQ"));
//        faq.click();
//        Object[] windowHandles=driver.getWindowHandles().toArray();
//        driver.switchTo().window((String) windowHandles[1]);

//        Paul's Method
//        driver.manage().window().setPosition(new Point(2000,30));
//        int x = driver.manage().window().getPosition().getX();
//        int y = driver.manage().window().getPosition().getY();
//        System.out.println(x);
//        System.out.println(y);
//        Thread.sleep(2000);
//        driver.manage().window().setSize(new Dimension(400, 400));


//        Main Script
        WebElement faq = driver.findElement(By.linkText("FAQ"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", faq);
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(250,350)");
        Thread.sleep(2000);
        faq.click();
        Thread.sleep(2000);
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
    }

    @Then("the results page should display results for this term")
    public void the_results_page_should_display_results_for_this_term() {
        List<WebElement> noResults = driver.findElements(By.className("hs-search__no-results"));
        assertTrue(noResults.isEmpty(), "The 'no results found' message appeared unexpectedly.");
    }

    @Then("the results body should say no results were found for {string}")
    public void checkNoResultsFoundMessage(String searchString) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchResultHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hs-search__no-results")));
        assertTrue(searchResultHeader.getText().contains("no results for \"" + searchString + "\""));
    }

    @Then("the term {string} should appear in the URL")
    public void termShouldAppearInTheURL(String expectedTerm) {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(expectedTerm));
    }

    @Then("I should be on the FAQ page")
    public void iShouldBeOnTheFAQPage(){
        String currentUrl = driver.getCurrentUrl();
//        System.out.println(currentUrl);
        assertTrue(currentUrl.contains("faq.makers.tech"));
    }

    @After
    public void closeBrowser(Scenario scenario){
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "name");
        }
        driver.quit();
    }
}