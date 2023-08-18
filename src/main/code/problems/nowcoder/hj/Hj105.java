package problems.nowcoder.hj;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/7 16:04
 */
public class Hj105 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = 0;
        int pos = 0;
        double sum = 0;
        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n < 0) cnt++;
            else {
                sum += n;
                pos++;
            }
        }
        DecimalFormat format = new DecimalFormat("0.0");
        System.out.println(cnt);
        System.out.println(format.format(sum / pos));
    }
}
