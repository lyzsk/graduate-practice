package cn.sichu.graduate.practice.leetcode;

/**
 * maxArea代表最大的感染区,res代表需要修的墙的数量,
 * <p>
 * targetX、targetY表示此区域的DFS开始的坐标
 * <p>
 * state表示当前区域要修建墙的状态,如果没有修过,需要给maxArea+1,修过的话，只加墙的数量,不加maxArea
 * <p>
 * 并且每个区域的state都是不一样的，互相不能影响 DFS完给state-1
 * 
 * @see https://leetcode.cn/problems/contain-virus/solution/ge-chi-bing-du-by-jiang-hui-4-21s8/
 * @author sichu
 * @date 2022/07/18
 */
public class Leetcode0749 {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int curWall = 0;
    private int rows;
    private int cols;

    public int containVirus(int[][] isInfected) {
        this.rows = isInfected.length;
        this.cols = isInfected[0].length;
        int res = 0;
        while (true) {
            int walls = getMaxAreaNeedWalls(isInfected);
            if (walls == 0) {
                break;
            }
            res += walls;
        }
        return res;
    }

    private int getMaxAreaNeedWalls(int[][] isInfected) {
        int maxArea = 0;
        int res = 0;
        int targetX = -1;
        int targetY = -1;
        int state = -3;
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isInfected[i][j] == 1 && visited[i][j] == 0) {
                    // 当前区域需要的防火墙数量
                    curWall = 0;
                    // 当前区域能感染的数量
                    int curMaxArea = dfs(isInfected, visited, i, j, state);
                    if (curMaxArea > maxArea) {
                        maxArea = curMaxArea;
                        res = curWall;
                        targetX = i;
                        targetY = j;
                    }
                    state--;
                }
            }
        }
        if (targetX == -1) {
            return 0;
        }
        modifyDead(isInfected, targetX, targetY);
        visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isInfected[i][j] == 1 && visited[i][j] == 0) {
                    spread(isInfected, visited, i, j);
                }
            }
        }
        return res;
    }

    private void spread(int[][] isInfected, int[][] visited, int x, int y) {
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && visited[newX][newY] == 0) {
                if (isInfected[newX][newY] == 0) {
                    isInfected[newX][newY] = 1;
                    visited[newX][newY] = 1;
                } else if (isInfected[newX][newY] == 1) {
                    spread(isInfected, visited, newX, newY);
                }
            }
        }
    }

    private void modifyDead(int[][] isInfected, int x, int y) {
        isInfected[x][y] = -2;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && isInfected[newX][newY] == 1) {
                modifyDead(isInfected, newX, newY);
            }
        }
    }

    private int dfs(int[][] isInfected, int[][] visited, int x, int y, int state) {
        int curArea = 0;
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && visited[newX][newY] != 1) {
                if (isInfected[newX][newY] == 0) {
                    curWall++;
                    if (visited[newX][newY] != state) {
                        curArea++;
                        visited[newX][newY] = state;
                    }
                } else if (isInfected[newX][newY] == 1) {
                    curArea += dfs(isInfected, visited, newX, newY, state);
                }
            }
        }
        return curArea;
    }
}
