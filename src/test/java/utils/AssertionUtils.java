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
    softAssert.get().assertAll();
  }
}
