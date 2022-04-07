package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 * 
 * @author sichu
 * @date 2022/04/07
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            --columnNumber;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
