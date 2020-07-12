package mjc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jianchaomeng
 * @time 2020/6/25 10:58 PM
 */
public class Q539 {
    public static void main(String[] args) {
        Q539 q539 = new Q539();
        String[] t = {"23:59","00:00","00:02"};
        List<String> timePoints = Arrays.asList(t);
        System.out.println(q539.findMinDifference(timePoints));
    }
    public int findMinDifference(List<String> timePoints) {
        List<Long> times = new ArrayList<Long>();
        for (String timePoint : timePoints) {
            String[] hm = timePoint.split(":");
            times.add(Long.valueOf(hm[0]) * 60 + Long.valueOf(hm[1]));
        }
        Collections.sort(times);
        List<Long> times1 = new ArrayList<Long>();
        for (int i = 0; i < times.size()-1; i++) {
            times1.add(times.get(i+1)-times.get(i));
        }
        times1.add(times.get(0) - times.get(times.size()-1) + 24 * 60);
        Collections.sort(times1);
        return times1.get(0).intValue();
    }
}
