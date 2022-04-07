package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * 
 * @author sichu
 * @date 2022/04/07
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }
}
