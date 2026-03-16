package utils;

import org.testng.asserts.SoftAssert;

public class AssertionUtils {
  private static ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();
  public static void initAssertions() {
    softAssert.set(new SoftAssert());
  }
  public static SoftAssert getAssert() {
    return softAssert.get();
  }
  public static void assertAll() {

    if (softAssert.get() != null) {

      try {
        softAssert.get().assertAll();
      } catch (AssertionError e) {

        String screenshotPath = ScreenshotUtils.captureScreenshot("AssertionFailure");

        try {
          ExtentTestManager.getTest().fail("Assertion Failed");
          ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception ex) {
          ex.printStackTrace();
        }

        throw e;
      }
    }
  }
}
