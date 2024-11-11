package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import baseTest.BaseTest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){
        Object currentClas = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClas).getDriver();
        try {
            takeScreenshot(result);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSuccess(ITestResult result){
        Object currentClas = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClas).getDriver();
        try {
            takeScreenshot(result);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void screenshotTest(WebDriver driver, ITestResult result) {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File newFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            Date date = new Date();
            String screenshotName = result.getName() + "_" + date.toString().replace(":", "_")
                    .replace(" ", "_");
            String location = "./Screenshot/" + screenshotName + ".png";
            FileUtils.copyFile(newFile, new File(location));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public void takeScreenshot(ITestResult result) throws AWTException, IOException {

        // Using java.awt.Robot and java.awt.Dimension for full screen capture
        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRect = new Rectangle(screenSize);
        BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

        // Saving the full screen image
        Date date = new Date();
        String screenshotName = result.getName() + "_" + date.toString().replace(":", "_")
                .replace(" ", "_");
        String location = "./Screenshot/" + screenshotName + ".png";
        ImageIO.write(screenFullImage, "PNG", new File(location));
    }
}
