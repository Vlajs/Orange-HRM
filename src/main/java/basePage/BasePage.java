package basePage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait driverWait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));/*
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverWait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));*/
        /*driverWait.until(webDriver -> {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            boolean documentReady = js.executeScript("return document.readyState").equals("complete");
            boolean noNetworkActivity = (Long) js.executeScript(
                    "return window.performance.getEntriesByType('resource').filter(e => e.initiatorType === 'xmlhttprequest' || e.initiatorType === 'fetch').length") == 0;

            return documentReady && noNetworkActivity;
        });*/
    }

    public void waitForPageToLoad() {
        driverWait.until(webDriver -> {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            boolean documentReady = js.executeScript("return document.readyState").equals("complete");
            boolean noNetworkActivity = (Long) js.executeScript(
                    "return window.performance.getEntriesByType('resource').filter(e => e.initiatorType === 'xmlhttprequest' || e.initiatorType === 'fetch').length") == 0;

            return documentReady && noNetworkActivity;
        });
    }

    public void wait (By elementBy){
        driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
        scrollToAnElement(elementBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(elementBy)).perform();
    }
    public void wait (WebElement element){
        driverWait.until(ExpectedConditions.visibilityOfAllElements(element));
        scrollToAnElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void clickElement(By elementBy, String logElement){
        wait(elementBy);
        driverWait.until(ExpectedConditions.elementToBeClickable(elementBy));
        driver.findElement(elementBy).click();
        System.out.println("Clicked on " + logElement);
    }
    public void clickElement(WebElement element, String logElement){
        wait(element);
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        System.out.println("Clicked on " + logElement);
    }

    public void writeText(By elementBy, String text, String logElement){
        wait(elementBy);
        clickElement(elementBy, logElement);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
        System.out.println("Typed " + text + " in " + logElement);

        /*wait(elementBy);
        WebElement element = driver.findElement(elementBy);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", element);
        element.sendKeys(text);*/
    }
    public void writeText(WebElement elementBy, String text, String logElement){
        wait(elementBy);
        clickElement(elementBy, logElement);
        elementBy.clear();
        elementBy.sendKeys(text);
        System.out.println("Typed " + text + " in " + logElement);
    }

    public String readText(By elementBy, String logElement){
        wait(elementBy);
        System.out.println("The read text from " + logElement + ": " + driver.findElement(elementBy).getText());
        return driver.findElement(elementBy).getText();
    }
    public String readText(WebElement elementBy, String logElement){
        wait(elementBy);
        System.out.println("The read text from " + logElement + ": " + elementBy.getText());
        return elementBy.getText();
    }

    public String readAttribute(By elementBy, String attribute, String logElement){
        wait(elementBy);
        System.out.println("The read attribute from " + logElement + ": " + driver.findElement(elementBy).getAttribute(attribute));
        return driver.findElement(elementBy).getAttribute(attribute);
    }
    public String readAttribute(WebElement elementBy, String attribute, String logElement){
        wait(elementBy);
        System.out.println("The read attribute from " + logElement + ": " + elementBy.getAttribute(attribute));
        return elementBy.getAttribute(attribute);
    }

    public void scrollToAnElement(By elementBy){
        JavascriptExecutor js = (JavascriptExecutor) driver;/*
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(elementBy));
        js.executeScript("window.scrollBy(0, -200);");*/

        WebElement element = driver.findElement(elementBy);
        int elementPosition = element.getLocation().getY();

// Calculate the vertical position needed to bring the element to the middle
        int windowHeight = ((Long) js.executeScript("return window.innerHeight")).intValue();
        int scrollToPosition = elementPosition - (windowHeight / 2);

// Scroll to bring the element in the center
        js.executeScript("window.scrollTo(0, " + scrollToPosition + ");");
    }
    public void scrollToAnElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollBy(0, -200);");
    }

    public void assertUrl(String url){
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    public void assertText(By element, String text){
        Assert.assertEquals(driver.findElement(element).getText(), text);
    }

    public void performRightClick (By elementBy, String url, String logElement){/*
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(elementBy)).perform();*/
        String linkUrl = readAttribute(elementBy, "href", logElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open(arguments[0], '_blank');", linkUrl);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    public void performRightClick (WebElement elementBy, String url, String logElement){/*
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(elementBy)).perform();*/
        String linkUrl = readAttribute(elementBy, "href", logElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open(arguments[0], '_blank');", linkUrl);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    public void changeAttribute(String regulation, By element){
        wait(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('data-lcreg', '" + regulation + "');", driver.findElement(element));
        System.out.println("Changed attribute in " + element + " into " + regulation);
    }
    public void changeAttribute(String regulation, WebElement element){
        wait(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('data-lcreg', '" + regulation + "');", element);
        System.out.println("Changed attribute in " + element + " into " + regulation);
    }
    public WebElement returnDisplayedElement(By element) {
        int retries = 5;
        int delay = 1000; // 2 seconds

        for (int i = 0; i < retries; i++) {
            try {
                // Check for element visibility
                List<WebElement> elements = driver.findElements(element);
                for (WebElement displayedElement : elements) {
                    if (displayedElement.isDisplayed()) {
                        return displayedElement;
                    }
                }
                // If element not found, pause briefly and try again
                Thread.sleep(delay);
            } catch (Exception e) {
                System.out.println("Retrying to find element: " + e.getMessage());
            }
        }
        return null; // Return null if not found after retries
    }
    public boolean returnIsItElementDisplayed(By element) throws InterruptedException {/*
        Thread.sleep(5000);*/
        // Extract the XPath string from the By locator
        String xpath = element.toString().substring(element.toString().indexOf(": ") + 2);

        // Set up a FluentWait with a custom timeout and polling interval
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) // Max wait time
                .pollingEvery(Duration.ofMillis(500)) // Polling interval
                .ignoring(NoSuchElementException.class);

        // Wait until the page is fully loaded
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

        // Check if the element (using XPath) is visible using JavaScript
        Boolean isFormVisible = (Boolean) ((JavascriptExecutor) driver).executeScript(
                "var xpath = arguments[0]; " +
                        "var element = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; " +
                        "return element !== null && " +
                        "window.getComputedStyle(element).display !== 'none' && " +
                        "window.getComputedStyle(element).visibility !== 'hidden';",
                xpath);
        System.out.println("This is in the method for checking before everything: " + isFormVisible);

        // Check if the element is initially displayed using Selenium's ExpectedConditions
        try {
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
            System.out.println("This is the size of an elements: " + elements.size());
            if (elements.isEmpty()) {
                System.out.println("Element not found or not displayed initially.");
                return false;
            }

            // Element is found and displayed; wait until it becomes invisible
            System.out.println("Element initially displayed. Waiting for it to disappear...");
            Boolean isFormVisible1 = (Boolean) ((JavascriptExecutor) driver).executeScript(
                    "var xpath = arguments[0]; " +
                            "var element = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; " +
                            "return element !== null && " +
                            "window.getComputedStyle(element).display !== 'none' && " +
                            "window.getComputedStyle(element).visibility !== 'hidden';",
                    xpath);
            System.out.println("This is in the method for checking waiting an element to disappear: " + isFormVisible1);
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

        } catch (TimeoutException e) {
            System.out.println("Test failed: Element remained visible after 10 seconds!");
            Boolean isFormVisible2 = (Boolean) ((JavascriptExecutor) driver).executeScript(
                    "var xpath = arguments[0]; " +
                            "var element = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; " +
                            "return element !== null && " +
                            "window.getComputedStyle(element).display !== 'none' && " +
                            "window.getComputedStyle(element).visibility !== 'hidden';",
                    xpath);
            System.out.println("This is in the method for checking when element is visible: " + isFormVisible2);
            return false; // Returns false if the element remains visible
        }
    }
}
