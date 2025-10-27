public class TriangleLoops {

    /*
     * The method returns a String by creating rows of letters. Each row prints a
     * number of letters equal to the row number. The total number of rows printed
     * is determined by numberOfRows.
     * @param numberOfRows the number of rows in the triangle
     * @param letter the letter to be printed
     * @return a String of letters in the shape of a triangle
     */

    // to-do: implement createLetterTriangleUp
    public static String createLetterTriangleUp(int numberOfRows, char letter) {
        String triangle = "";
        int j = 0;
        for (int i = 1; i < numberOfRows + 1; i++) {
            while (j < i) {
                triangle += letter;
                j++;
            }
            triangle += "\n";
            j = 0;
        }
        return triangle;
    }

    /*
     * The method returns a String by creating rows of letters. Each row prints a
     * number of letters equal to the total number of rows, descending downward. The
     * total number of rows printed is determined by numberOfRows.
     * @param numberOfRows the number of rows in the triangle
     * @param letter the letter to be printed
     * @return a String of letters in the shape of a triangle
     */
    // to-do: implement createLetterTriangleDown
    public static String createLetterTriangleDown(int numberOfRows, char letter) {
        String triangle = "";
        int j = 0;
        for (int i = numberOfRows; i > 0; i--) {
            while (j < i) {
                triangle += letter;
                j++;
            }
            triangle += "\n";
            j = 0;
        }
        return triangle;
    }

    /*
     * This method returns a String of a number triangle. The number of rows in the
     * triangle is determined by the numberOfRows, and the number used in each row
     * is determined by the row number.
     * @param numberOfRows the number of rows in the triangle
     * @return a String of numbers in the shape of a triangle
     */
    // to-do: implement createNumbersTriangle
    public static String createNumbersTriangle(int numberOfRows) {
        String triangle = "";
        int j = 0;
        for (int i = 1; i < numberOfRows + 1; i++) {
            while (j < i) {
                triangle = triangle + i + " ";
                j++;
            }
            triangle += "\n";
            j = 0;
        }
        return triangle;
    }

    /*
     * The method returns a String by creating a pyramid pattern using the alphabet.
     * The method determines the height of the pyramid by using the int
     * numberOfRows.
     * @param numberOfRows the number of rows in the triangle
     * @return a String of letters in the shape of a pyramid
     */
    // to-do: implement createAlphabetTriangle
    public static String createAlphabetTriangle(int numberOfRows) {
        if (numberOfRows > 26) {
            numberOfRows = 26;
        }
        /*Total rectangle area is #rows * 2 - 1 */
        String triangle = "";
        int j = 0;
        int m = 1;
        for (int i = 1; i < numberOfRows + 1; i++) {
            int netNumSpaces = (numberOfRows * 2 - (2 * i - 1)) / 2;
            for (int k = 0; k < netNumSpaces; k++) {
                triangle += " ";
            }
            while (j < i) {
                triangle += (char) ('A' + j);
                j++;
            }
            while (m < i) {
                triangle += (char) ('A' + j - m - 1);
                m++;
            }
            triangle += "\n";
            j = 0;
            m = 1;
        }
        return triangle;
    }

}
