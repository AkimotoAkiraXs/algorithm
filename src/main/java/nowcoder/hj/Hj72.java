package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/28 22:07
 */

public class Hj72 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        /*
         * 数学：
         * 鸡翁a只(0≤a≤20) 鸡母b只(0≤b≤33) 鸡雏(100-a-b)只 由5a+3b+(100-a-b)/3=100
         * 得到关系式b=25-7a/4，也就是说鸡翁数量是4的倍数，最少0只 做多20只
         * 设一个变量num(0≤num≤3，≤3是要保证鸡母数不为负)
         * 则鸡翁4num只，鸡母为25-7num只，鸡雏为75+3num只
         * */
        for (int i = 0; i <= 3; i++) System.out.printf("%d %d %d\n", 4 * i, 25 - 7 * i, 75 + 3 * i);
    }
}
