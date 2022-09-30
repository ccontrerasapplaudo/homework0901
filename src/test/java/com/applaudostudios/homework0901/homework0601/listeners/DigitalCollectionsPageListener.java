package com.applaudostudios.homework0901.homework0601.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class DigitalCollectionsPageListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Listener before invocation of " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Listener after invocation of " + method.getTestMethod().getMethodName());
    }
}
