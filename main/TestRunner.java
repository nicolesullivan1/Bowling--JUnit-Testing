package main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author nicolesullivan
 * TestRunner class to run JUnit Tests
 * @since   2020-04-02 
 */
public class TestRunner {
  public static void main() {
    Result result = JUnitCore.runClasses(MyTests.class);
    
    //Print out failures
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }

    //Prints out total test cases, the # of sucessfull cases,
    //and the # of failed cases
    System.out.println("TEST RESULTS");
    System.out.println("Total Test Cases: " + result.getRunCount());
    System.out.print("Successful: " + (result.getRunCount() - result.getFailureCount()));  
    System.out.println("  Failed: " + result.getFailureCount());
  }
}