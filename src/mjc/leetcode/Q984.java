package mjc.leetcode;

/**
 * @author jianchaomeng
 * @time 2020/6/27 4:30 PM
 */
public class Q984 {
    public static void main(String[] args) {

        System.out.println(new Q984().strWithout3a3b(1,3));
    }

    public String strWithout3a3b(int A, int B) {
        StringBuilder sbuilder = new StringBuilder();
        if (A>=B) {
            while (A > B && B > 0) {
                sbuilder.append("aab");
                A -= 2;
                B -= 1;
            }
            if (A == B) {
                while (A > 0) {
                    sbuilder.append("ab");
                    A--;
                    B--;
                }
            } else {
                while (A > 0) {
                    sbuilder.append("a");
                    A--;
                }
            }
        } else {
            while (A < B && A > 0) {
                sbuilder.append("bba");
                A -= 1;
                B -= 2;
            }
            if (A == B) {
                while (A > 0) {
                    sbuilder.append("ba");
                    A--;
                    B--;
                }
            } else {
                while (B > 0) {
                    sbuilder.append("b");
                    B--;
                }
            }
        }

        return sbuilder.toString();
    }
}
