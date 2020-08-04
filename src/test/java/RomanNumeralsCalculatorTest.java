import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsCalculatorTest {

  @Test
  @DisplayName("Tests calculations on roman numerals operations to return the correct result")
  void testParse() {
    assertAll(
      () -> assertEquals("1", RomanNumeralsCalculator.calculate("I")),
      () -> assertEquals("5", RomanNumeralsCalculator.calculate("V")),
      () -> assertEquals("10", RomanNumeralsCalculator.calculate("X")),
      () -> assertEquals("6", RomanNumeralsCalculator.calculate("VI")),
      () -> assertEquals("4", RomanNumeralsCalculator.calculate("IV")),
      () -> assertEquals("3", RomanNumeralsCalculator.calculate("I + II")),
      () -> assertEquals("-1", RomanNumeralsCalculator.calculate("I - II")),
      () -> assertEquals("2", RomanNumeralsCalculator.calculate("I * II")),
      () -> assertEquals("0.5", RomanNumeralsCalculator.calculate("I / II")),
      () -> assertEquals("6", RomanNumeralsCalculator.calculate("I + II + III")),
      () -> assertEquals("-4", RomanNumeralsCalculator.calculate("I - II - III")),
      () -> assertEquals("6", RomanNumeralsCalculator.calculate("I * II * III")),
      () -> assertEquals("0.166", RomanNumeralsCalculator.calculate("I / II / III")),
      () -> assertEquals("7", RomanNumeralsCalculator.calculate("I + II * III")),
      () -> assertEquals("5", RomanNumeralsCalculator.calculate("I * II + III")),
      () -> assertEquals("9", RomanNumeralsCalculator.calculate("( I + II ) * III")),
      () -> assertEquals("5", RomanNumeralsCalculator.calculate("I * ( II + III )")),
      () -> assertEquals("5", RomanNumeralsCalculator.calculate("I * ( II + III )")),
      () -> assertEquals("1", RomanNumeralsCalculator.calculate("III + IV * II / ( I - V )"))
    );
  }
}
