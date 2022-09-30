package com.applaudostudios.homework0901.homework0601.retries;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class HomePageRetry implements IRetryAnalyzer {

    private int retryCount=0;
    private static final int maxRetryCount=5;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount <maxRetryCount){
            retryCount++;
            System.out.println(retryCount);
            return true;
        }
        return false;
    }
}
