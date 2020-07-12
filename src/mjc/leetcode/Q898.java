package mjc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jianchaomeng
 * @time 2020/6/27 6:31 PM
 */
public class Q898 {
    public static void main(String[] args) {

    }


    /**
     * 暴力法，超时了
     * @param A
     * @return
     */
    public int subarrayBitwiseORs1(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i < A.length; i++) {
            int res = A[i];
            set.add(res);
            for (int j=i+1; j<A.length; j++) {
                res = res | A[j];
                set.add(res);
            }
        }
        return set.size();
    }

    /**
     *
     * @param A
     * @return
     */
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> cur = new HashSet<Integer>();
        cur.add(0);
        for (int i=0; i < A.length; i++) {
            Set<Integer> cur2 = new HashSet<Integer>();
            int res = A[i];
            cur2.add(res);
            for (int curI : cur) {
                cur2.add(res | curI);
            }
            set.addAll(cur2);
            cur = cur2;
        }
        return set.size();
    }
}
