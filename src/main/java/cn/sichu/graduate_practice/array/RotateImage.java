package cn.sichu.graduate_practice.array;

/**
 * @see <a href = "https://leetcode-cn.com/problems/rotate-image/">48. 旋转图像</a>
 * @see <a href = "https://leetcode.com/problems/rotate-image/">48. Rotate Image</a>
 * @author sichu
 * @date 2022/03/20
 */
public class RotateImage {
    /**
     * 1. 顺时针旋转90° 规律： 矩阵第i行第j列元素 -> 矩阵 倒数第i列 的第j行位置
     * <p>
     * 2. 用tmp完成4项原地交换:
     * <ul>
     * <li><code>tmp = matrix[row][col]</code>
     * <li><code>matrix[row][col] = matrix[n-1-col][row]</code></li>
     * <li><code>matrix[n-1-col][row] = matrix[n-1-row][n-1-col]</code></li>
     * <li><code>matrix[n-1-row][n-1-col] = matrix[col][n-1-row]</code></li>
     * <li><code>matrix[col][n-1-row] = //原矩阵的matrix[row][col]// = tmp</code></li>
     * </ul>
     * 3. 由于每次枚举，在原地进行了4次交换，因此
     * <ul>
     * <li>当 n 为偶数时，需要枚举 n<sup>2</sup>/4 = (n/2) * (n/2) 个位置，</li>
     * <li>当 n 为奇数时，因为矩阵中心位置旋转后不变，需要枚举 (n<sup>2</sup>-1)/4 = ((n-1)/2) * ((n+1)/2) 个位置</li>
     * </ul>
     * <p>
     * Time: O(n<sup>2</sup>) = O(n/2 * ((n+1)/2))
     * <p>
     * Space: O(1)
     * 
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }

    }
}
