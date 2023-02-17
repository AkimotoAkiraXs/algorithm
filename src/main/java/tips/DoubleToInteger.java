package tips;

/**
 * @author Yuri
 * @since 2023/2/17 20:56
 */

public class DoubleToInteger {

    public static void main(String[] args) {
        double d = 0.1;

        double ceil = Math.ceil(d);// 向上取整

        double floor = Math.floor(d);// 向下取整

        long round = Math.round(d);// 四舍五入

        double rint = Math.rint(d);// 最近取整，如果有2个数同样接近，则返回偶数的那个，比如0.5返回0

    }
}
