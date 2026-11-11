package com.demowebshop.reporting;

import java.io.File;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.demowebshop.driver.DriverFactory;
import com.demowebshop.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Initialize Report
    @Override
    public void onStart(ITestContext context) {

        ExtentReportManager.initReports();
    }

    // Test Execution Started
    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        String testDetails = testName;

        if (result.getParameters().length > 0) {
            testDetails += " " + java.util.Arrays.toString(result.getParameters());
        }

        ExtentTest test = ExtentReportManager.createTest(testDetails);

        extentTest.set(test);

        extentTest.get().info("Test execution started");
    }

    // Test Execution Passed
    @Override
    public void onTestSuccess(ITestResult result) {

        String screenshotPath = getScreenshotPath(result, "PASS");

        try {

            ScreenshotUtils.captureScreenshot(
                    DriverFactory.getDriver(), screenshotPath);

            extentTest.get().pass("Test Passed");

            extentTest.get().addScreenCaptureFromPath(
                    new File(screenshotPath).getAbsolutePath());

        } catch (Exception e) {

            extentTest.get().warning(
                    "PASS screenshot could not be captured: " + e.getMessage());

        }

        extentTest.remove();
    }

    // Test Execution Failed
    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().fail(result.getThrowable());

        String screenshotPath = getScreenshotPath(result, "FAIL");

        try {

            ScreenshotUtils.captureScreenshot(
                    DriverFactory.getDriver(), screenshotPath);

            extentTest.get().addScreenCaptureFromPath(
                    new File(screenshotPath).getAbsolutePath());

        } catch (Exception e) {

            extentTest.get().warning(
                    "FAIL screenshot could not be captured: " + e.getMessage());

        }

        extentTest.remove();
    }

    // Test Execution Skipped
    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get().skip("Test Skipped");

        extentTest.remove();
    }

    // Generate Screenshot Path
    private String getScreenshotPath(ITestResult result, String status) {

        String testName = result.getMethod().getMethodName();

        String parameters = java.util.Arrays.toString(result.getParameters())
                .replaceAll("[^a-zA-Z0-9_-]", "_");

        String fileName = testName + "_" + parameters + "_"
                + System.currentTimeMillis() + ".png";

        String folderPath = "reports/screenshots/" + status;

        new File(folderPath).mkdirs();

        return folderPath + "/" + fileName;
    }

    // Finish Report
    @Override
    public void onFinish(ITestContext context) {

        ExtentReportManager.flushReports();
    }
}