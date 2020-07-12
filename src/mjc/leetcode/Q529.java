package mjc.leetcode;

/**
 * @author jianchaomeng
 * @time 2020/7/12 6:46 PM
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minesweeper
 *
 */
public class Q529 {

    public char[][] updateBoard(char[][] board, int[] click) {
        int x_length = board.length;
        int y_length = board[0].length;

        switch (board[click[0]][click[1]]) {
            case 'M' : board[click[0]][click[1]] = 'X'; break;
            case 'E' : int eCount = count(board, click);
                if (eCount == 0) {
                    board[click[0]][click[1]] = 'B';
                    for (int i = click[0]-1; i<= click[0]+1; i++) {
                        if (i>=0 && i < x_length) {
                            for (int j = click[1] - 1; j <= click[1] + 1; j++) {
                                if (j >=0 && j<y_length) {
                                    if (board[i][j] == 'E') {
                                        updateBoard(board, new int[]{i, j});
                                    }
                                }
                            }
                        }
                    }
                } else {
                    board[click[0]][click[1]] = String.valueOf(eCount).toCharArray()[0];
                }
                break;
            default:
                break;
        }

        return board;
    }

    private int count(char[][] board, int[] click) {
        int x_length = board.length;
        int y_length = board[0].length;
        int count = 0;
        for (int i = click[0]-1; i<= click[0]+1; i++) {
            if (i>=0 && i < x_length) {
                for (int j = click[1] - 1; j <= click[1] + 1; j++) {
                    if (j >=0 && j<y_length) {
                        if (board[i][j] == 'M') {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

}
