package mjc.leetcode;

/**
 * @author jianchaomeng
 * @time 2020/6/26 11:12 AM
 */
public class Q537 {
    public static void main(String[] args) {

    }

    public String complexNumberMultiply(String a, String b) {
        String[] as = a.split("\\+");
        int a0 = Integer.valueOf(as[0]);
        int a1 = Integer.valueOf(as[1].substring(0, as[1].length()-1));
        String[] bs = b.split("\\+");
        int b0 = Integer.valueOf(bs[0]);
        int b1 = Integer.valueOf(bs[1].substring(0, bs[1].length()-1));
        int c0 = a0 * b0 - a1 * b1;
        int c1 = a0 * b1 + a1 * b0;
        return c0 + "+" + c1 + "i";
    }
}
