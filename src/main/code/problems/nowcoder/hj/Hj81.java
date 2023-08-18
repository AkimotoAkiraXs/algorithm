package problems.nowcoder.hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Hj81 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String ss = in.nextLine();
        Set<Integer> set = ss.codePoints().collect(HashSet::new, HashSet::add, HashSet::addAll);
        boolean res = s.codePoints().allMatch(set::contains);
        System.out.println(res);
    }
}
