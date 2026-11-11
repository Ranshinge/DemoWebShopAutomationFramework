package com.demowebshop.reporting;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentSparkReporter sparkReporter;

    // Initialize Extent Reports
    public static void initReports() {

        new File("reports").mkdirs();

        sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");

        extentReports = new ExtentReports();

        sparkReporter.config().setDocumentTitle("DemoWebShop Automation Report");
        sparkReporter.config().setReportName("Automation Test Execution Report");

        extentReports.attachReporter(sparkReporter);
    }

    // Create Test Entry
    public static ExtentTest createTest(String testName) {

        return extentReports.createTest(testName);
    }

    // Flush Reports
    public static void flushReports() {

        extentReports.flush();
    }
}