package main;

/**
 * @Author Yuri
 * @Date 2021/5/14 14:59
 * @Version 1.0
 * @Description:
 */

public class LiKou {
    public static void main(String[] args) {
        String ans = Id12.run(1988);
        System.out.println(ans);
    }
}

class Id12 {
    public static String run(int num) {
        String[] rChar = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String ans = "";
        int k = 0;
        while (num != 0) {
            int j = num / n[k];
            num %= n[k];
            for (int i = 0; i < j; i++) {
                ans += rChar[k];
            }
            k++;
        }
        return ans;
    }
}


