package main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
  public static void main() {
    Result result = JUnitCore.runClasses(MyTests.class);
    
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }

    System.out.println("TEST RESULTS");
    System.out.println("Total Test Cases: " + result.getRunCount());
    System.out.print("Successful: " + (result.getRunCount() - result.getFailureCount()));  
    System.out.println("  Failed: " + result.getFailureCount());
  }
}