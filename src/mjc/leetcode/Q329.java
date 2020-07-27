package mjc.leetcode;

/**
 * @author jianchaomeng
 * @time 2020/7/26 026 11:31
 */
public class Q329 {

    public static void main(String[] args) {
        Q329 q329 = new Q329();
        int[][] matrix = {{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};
        printMatrix(matrix);
        q329.longestIncreasingPath(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        int xSize = matrix.length;
        int ySize = matrix[0].length;
        for (int i = 0; i < xSize; i++) {
            System.out.print("[");
            for (int j = 0; j < ySize; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    public int longestIncreasingPath(int[][] matrix) {
        int xSize = matrix.length;
        int ySize = matrix[0].length;
        int[][] count = new int[xSize][ySize];
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                count = hitMatrix(matrix, count, i, j, xSize, ySize);
                System.out.println("hit(" + i + "," + j + ")=" + matrix[i][j]);
                printMatrix(count);
            }
        }
        int max = 0;
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                if (count[i][j] > max) {
                    max = count[i][j];
                }
            }
        }
        return max+1;
    }

    public int[][] hitMatrix(int[][] matrix, int[][] count, int x, int y, int xSize, int ySize) {
        System.out.println("hitMatrix(" + x + "," + y + ")=" + matrix[x][y]);
        boolean hit = false;
        if (x > 0 && matrix[x][y] > matrix[x-1][y]) {
            if (count[x][y] < count[x-1][y] + 1) {
                count[x][y] = count[x-1][y] + 1;
                hit = true;
            }
        }
        if (x < xSize - 1 && matrix[x][y] > matrix[x+1][y]) {
            if (count[x][y] < count[x+1][y] + 1) {
                count[x][y] = count[x+1][y] + 1;
                hit = true;
            }
        }
        if (y >0 && matrix[x][y] > matrix[x][y-1]) {
            if (count[x][y] < count[x][y-1] + 1) {
                count[x][y] = count[x][y-1] + 1;
                hit = true;
            }
        }
        if (y < ySize - 1 && matrix[x][y] > matrix[x][y+1]) {
            count[x][y] = count[x][y] > count[x][y+1] + 1 ? count[x][y] : count[x][y+1] + 1;
        }


        if (x > 0 && matrix[x][y] < matrix[x-1][y]) {
            count = hitMatrix(matrix, count, x-1, y, xSize, ySize);
        }
        if (x < xSize - 1 && matrix[x][y] < matrix[x+1][y]) {
            count = hitMatrix(matrix, count, x+1, y, xSize, ySize);
        }
        if (y > 0 && matrix[x][y] < matrix[x][y-1]) {
            count = hitMatrix(matrix, count, x, y-1, xSize, ySize);
        }
        if (y < ySize - 1 && matrix[x][y] < matrix[x][y+1]) {
            count = hitMatrix(matrix, count, x, y+1, xSize, ySize);
        }
        return count;
    }
}
