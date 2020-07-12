package mjc.leetcode;

import java.util.Arrays;

/**
 * @author jianchaomeng
 * @time 2020/6/26 4:08 PM
 */
public class Q744 {
    public static void main(String[] args) {
        Q744 q744 = new Q744();
        char[] letters = {'a', 'b'};
        System.out.println(q744.nextGreatestLetter(letters, 'z'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        for (char letter : letters) {
            if (target < letter) {
                return letter;
            }
        }
        return letters[0];
    }
}
