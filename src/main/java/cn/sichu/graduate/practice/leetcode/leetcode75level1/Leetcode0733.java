package cn.sichu.graduate.practice.leetcode.leetcode75level1;

/**
 * @author sichu
 * @date 2022/07/12
 */
public class Leetcode0733 {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currentColor = image[sr][sc];
        if (currentColor != color) {
            dfs(image, sr, sc, currentColor, color);
        }
        return image;
    }

    private static void dfs(int[][] image, int x, int y, int currentColor, int color) {
        if (image[x][y] == currentColor) {
            image[x][y] = color;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && my >= 0 && mx < image.length && my < image[0].length) {
                    dfs(image, mx, my, currentColor, color);
                }
            }
        }
    }
}
