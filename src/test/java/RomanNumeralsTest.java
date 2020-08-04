import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {

  @Test
  @DisplayName("Tests parsing the roman numerals into numbers")
  void testParse() {
    assertAll(
      () -> assertEquals(1, RomanNumerals.parse("I")),
      () -> assertEquals(5, RomanNumerals.parse("V")),
      () -> assertEquals(10, RomanNumerals.parse("X")),
      () -> assertEquals(50, RomanNumerals.parse("L")),
      () -> assertEquals(100, RomanNumerals.parse("C")),
      () -> assertEquals(500, RomanNumerals.parse("D")),
      () -> assertEquals(1000, RomanNumerals.parse("M")),
      () -> assertEquals(4, RomanNumerals.parse("IV")),
      () -> assertEquals(9, RomanNumerals.parse("IX")),
      () -> assertEquals(40, RomanNumerals.parse("XL")),
      () -> assertEquals(90, RomanNumerals.parse("XC")),
      () -> assertEquals(400, RomanNumerals.parse("CD")),
      () -> assertEquals(900, RomanNumerals.parse("CM"))
    );
  }
}
