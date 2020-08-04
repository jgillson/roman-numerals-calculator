class RomanNumerals {

  /**
   * The parse method parses a Roman Numeral to a number
   * @param romanNumeral The Roman Numeral input line string
   * @return The value of the Roman Numeral or -1 if invalid
   */
  static int parse(String romanNumeral) {
    int value = 0;
    for (int i = romanNumeral.length() - 1; i >= 0; i--) {
      switch (romanNumeral.charAt(i)) {
        case 'I':
          value += (value >= 5 ? -1 : 1); // subtract 1 if value is V (IV) or X (IX)
          break;
        case 'V':
          value += 5;
          break;
        case 'X':
          value += 10 * (value >= 50 ? -1 : 1); // subtract 10 if value is L (XL) or C (XC)
          break;
        case 'L':
          value += 50;
          break;
        case 'C':
          value += 100 * (value >= 500 ? -1 : 1); // subtract 100 if value is D (CD) or M (CM)
          break;
        case 'D':
          value += 500;
          break;
        case 'M':
          value += 1000;
          break;
        default:
          System.err.println("Not a valid Roman Numeral: " + value);
          return -1;
      }
    }
    return value;
  }

  static boolean isValid(char ch) {
    return (ch == 'I' || ch == 'V' || ch == 'X' || ch == 'L' ||
      ch == 'C' || ch == 'D' || ch == 'M');
  }
}
