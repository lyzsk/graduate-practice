package cn.sichu.graduate_practice.dp;

/**
 * @see <a href = "https://leetcode-cn.com/problems/regular-expression-matching/">10. 正则表达式匹配</a>
 * @see <a href = "https://leetcode.com/problems/regular-expression-matching/">10. Regular Expression Matching</a>
 * @author sichu
 * @date 2022/03/21
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean table[][] = new boolean[s.length() + 1][p.length() + 1];

        table[0][0] = true;

        for (int col = 1; col < table[0].length; col++) {
            char ch = p.charAt(col - 1);
            if (col == 1) {
                if (ch == '*') {
                    table[0][col] = true;
                }
            } else {
                if (ch == '*') {
                    table[0][col] = table[0][col - 2];
                } else {
                    table[0][col] = false;
                }
            }
        }

        for (int row = 1; row < table.length; row++) {
            char ch1 = s.charAt(row - 1);
            for (int col = 1; col < table[row].length; col++) {
                char ch2 = p.charAt(col - 1);
                if (ch1 == ch2 || ch2 == '.') {
                    table[row][col] = table[row - 1][col - 1];
                } else if (ch2 == '*') {
                    if (col > 1) {
                        if (table[row][col - 2]) {
                            table[row][col] = true;
                        } else {
                            if (p.charAt(col - 2) == '.' || p.charAt(col - 2) == ch1) {
                                table[row][col] = table[row - 1][col];
                            }
                        }
                    }
                }

            }
        }

        boolean lastRow[] = table[table.length - 1];
        return lastRow[lastRow.length - 1];
    }
}
