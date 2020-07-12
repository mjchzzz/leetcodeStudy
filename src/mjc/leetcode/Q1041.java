package mjc.leetcode;

/**
 * @author jianchaomeng
 * @time 2020/6/26 10:34 PM
 */
public class Q1041 {
    public static void main(String[] args) {

    }

    public boolean isRobotBounded(String instructions) {
        int[] point = {0, 0};
        int[][] direction = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;

        for (int i = 0; i < 4; i++) {
            for (char c : instructions.toCharArray()) {
                if (c == 'G') {
                    point[0] += direction[directionIndex][0];
                    point[1] += direction[directionIndex][1];
                } else if (c == 'L') {
                    directionIndex -= 1;
                    if (directionIndex < 0) {
                        directionIndex += 4;
                    }
                } else {
                    directionIndex = (directionIndex + 1) % 4;
                }
            }
            if (point[0] == 0 && point[1] == 0) {
                return true;
            }
        }
        return false;

    }
}
