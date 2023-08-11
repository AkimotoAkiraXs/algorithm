package tips;

import lombok.Data;

/**
 * 判断浮点数是否有小数位
 *
 * @author Yuri
 * @since 2023/2/12 5:35
 */
@Data
public class JudgesDoubleHasDecimal {

    public static void main(String[] args) {
        System.out.println(judge(1.1));
    }

    public static boolean judge(double num) {

/*
        // 不考虑精度
        return num - (int) num == 0;
*/

        // 精度保证
        double eps = 1e-10; //设置精度，因为计算机中double存在精度丢失，比如：1.000000000000000012
        return num - Math.floor(num) < eps; //存在精度丢失所以不直接判断num-Math.floor(num) > 0

        // 不考虑精度可以直接 return num - (int)num
    }
}
