package cn.sichu.graduate_practice.array;

/**
 * @see <a href = "https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/">1232. 缀点成线</a>
 * @see <a href = "https://leetcode.com/problems/check-if-it-is-a-straight-line/">1232. Check If It Is a Straight
 *      Line</a>
 * @author sichu
 * @date 2022/03/20
 */
public class CheckIfItIsStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        /**
         * y2 - y1 / x2 - x1 = y - y1 / x - x1 = y - y2 / x - x2
         * <p>
         * Ax + By = 0
         */

        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            if ((y2 - y1) * (x - x1) != (x2 - x1) * (y - y1)) {
                return false;
            }
        }
        return true;
    }
}
