package cn.sichu.graduate.practice.leetcode;

/**
 * 规则：
 * <ol>
 * <li>如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'</li>
 * <li>如果一个 没有相邻地雷 的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的 未挖出 方块都应该被递归地揭露。</li>
 * <li>如果一个 至少与一个地雷相邻 的空方块（'E'）被挖出，修改它为数字（'1' 到 '8' ），表示相邻地雷的数量。</li>
 * <li>如果在此次点击中，若无更多方块可被揭露，则返回盘面。</li>
 * </ol>
 * 'M'： 未挖出的地雷;
 * <p>
 * 'E': 未挖出的空方快;
 * <p>
 * 'B': 已挖出的空白方块;
 * <p>
 * '1'到'8': 多少地雷与已挖出的方块相邻;
 * <p>
 * 'X': 已挖出的地雷 类似的题： Leetcode0046， Leetcode0047, Leetcode0039, Leetcode0040, <b>Leetcode0077</b>, Leetcode0078,
 * Leetcode0090, <b>Leetcode0060</b>, Leetcode0093, Leetcode0733, Leetcode0200, Leetcode0130, Leetcode0079,
 * Leetcode0017, <b>Leetcode0784</b>, Leetcode0022, Leetcode0051, Leetcode0037, Leetcode0488, Leetcode0529
 * 
 * @author sichu
 * @date 2022/06/01
 */
public class Leetcode0529 {
    private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    private static void dfs(char[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || my < 0 || mx > board.length - 1 || my > board[0].length - 1) {
                continue;
            }
            if (board[mx][my] == 'M') {
                ++count;
            }
        }
        if (count > 0) {
            board[x][y] = (char)(count + '0');
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx < 0 || my < 0 || mx > board.length - 1 || my > board[0].length - 1 || board[mx][my] != 'E') {
                    continue;
                }
                dfs(board, mx, my);
            }
        }
    }
}
