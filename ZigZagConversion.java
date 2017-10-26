
/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * <p>P A H N A P L S I I G Y I R
 *
 * <p>And then read line by line: "PAHNAPLSIIGYIR" Write the code that will take a string and make
 * this conversion given a number of rows:
 *
 * <p>string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should return
 * "PAHNAPLSIIGYIR".
 */
class ZigZagConversion {
  public String convert(String s, int numRows) {
    if (numRows <= 1) {
      return s;
    }
    // Row index of each char in ZigZag form
    int[] rowIndex = new int[s.length()];
    int row = -1;
    // Simlate the movement of ZigZag, up or down
    boolean down = true;
    for (int i = 0; i < rowIndex.length; i++) {
      if (down) {
        row += 1;
        rowIndex[i] = row;
        if (row == numRows - 1) {
          down = false;
        }
      } else {
        row -= 1;
        rowIndex[i] = row;
        if (row == 0) {
          down = true;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int c = 0; c < numRows; c++) {
      for (int i = 0; i < rowIndex.length; i++) {
        if (rowIndex[i] == c) {
          sb.append(s.charAt(i));
        }
      }
    }
    return sb.toString();
  }
}
