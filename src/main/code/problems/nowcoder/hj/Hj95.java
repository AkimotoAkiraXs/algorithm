package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/6 16:03
 */
public class Hj95 {
    static final String[] cse = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    static final String[] unit = new String[]{"拾", "佰", "仟", "万", "亿"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整


        String[] split = in.nextLine().split("\\.");
        int integer = Integer.parseInt(split[0]);
        int dec = Integer.parseInt(split[1]);
        String res = func(integer);
        while (res.contains("零零")) res = res.replace("零零", "零");
        if (res.startsWith("零")) {
            StringBuilder sb = new StringBuilder(res);
            sb.deleteCharAt(0);
            res = sb.toString();
        }
        if (integer > 0) res += "元";
        if (dec == 0) {
            res += "整";
        } else {
            if (dec / 10 > 0) {
                res += cse[dec / 10] + "角";
            }
            if (dec % 10 > 0) {
                res += cse[dec % 10] + "分";
            }
        }
        System.out.println("人民币" + res);
    }

    private static String func(int num) {
        String res = "";
        final int oku = 100000000, mnn = 10000, ths = 1000, hun = 100, ten = 10;
        int k;
        if (num >= oku) {
            k = num / oku;
            res += func(k) + unit[4];
            num %= oku;
        }
        if (num >= mnn) {
            k = num / mnn;
            res += func(k) + unit[3];
            num %= mnn;
        }
        k = num / ths;
        if (k > 0) {
            res += cse[k] + unit[2];
            num %= ths;
        } else res += cse[0];

        k = num / hun;
        if (k > 0) {
            res += cse[k] + unit[1];
            num %= hun;
        } else res += cse[0];

        k = num / ten;
        if (k > 0) {
            if (k > 1) res += cse[k];
            res += unit[0];
            num %= ten;
        }
        res += cse[num];
        return res;
    }
}
