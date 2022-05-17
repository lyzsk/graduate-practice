package cn.sichu.graduate_practice.dfs;

/**
 * https://leetcode.cn/problems/flood-fill/
 * 
 * @author sichu
 * @date 2022/05/17
 */
public class FloodFill {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if (currentColor != newColor) {
            dfs(image, sr, sc, currentColor, newColor);
        }
        return image;
    }

    private static void dfs(int[][] image, int x, int y, int currentColor, int newColor) {
        if (image[x][y] == currentColor) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, currentColor, newColor);
                }
            }
        }
    }
}
