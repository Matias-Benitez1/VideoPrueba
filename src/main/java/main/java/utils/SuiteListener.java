package main.java.main.java.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import main.java.main.base.BaseClass;

public class SuiteListener implements ITestListener, IAnnotationTransformer {
	    @Override
	    public void onTestStart(ITestResult result) {
	        ITestListener.super.onTestStart(result);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {

	        String fileName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + "passed" + File.separator + result.getMethod().getMethodName();
	        File f = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);

	        try {
	            FileUtils.copyFile(f, new File(fileName + ".png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        ITestListener.super.onTestSkipped(result);
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	    }

	    @Override
	    public void onTestFailedWithTimeout(ITestResult result) {
	        ITestListener.super.onTestFailedWithTimeout(result);
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        ITestListener.super.onStart(context);
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        ITestListener.super.onFinish(context);
	    }
}
