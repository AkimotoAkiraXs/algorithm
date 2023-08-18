package problems.nowcoder.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/9 14:53
 */

public class Hj42 {

    static final String[] unit = new String[]{"", "thousand", "million", "billion"};
    static final String[] number = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static final String[] ten = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (Objects.equals(s, "0")) {
            System.out.println("zero");
            return;
        }
        StringBuilder res = new StringBuilder();
        int k = 0;
        for (int i = s.length(); i > 0; i -= 3) {
            String sub;
            if (i - 3 > 0) {
                sub = s.substring(i - 3, i);
            } else sub = s.substring(0, i);
            String str = func(Integer.parseInt(sub));
            res.insert(0, str + " " + unit[k++] + " ");
        }
        System.out.println(res);
    }

    public static String func(int n) {
        List<String> res = new ArrayList<>();
        if (n >= 100) {
            int h = n / 100;
            res.add(number[h]);
            res.add("hundred");
            n %= 100;
        }
        if (n > 0) {
            if (res.size() > 0) res.add("and");
            if (n > 19) {
                int t = n / 10;
                res.add(ten[t]);
                n %= 10;
            }
            if (n > 0) res.add(number[n]);
        }
        return String.join(" ", res);
    }
}
