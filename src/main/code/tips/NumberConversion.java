package tips;

/**
 * Java中的进制转换
 * @author Yuri
 * @since 2023/2/17 19:36
 */

public class NumberConversion {

    public static int toDecimal(String str, int system) {
        // 其他进制转十进制直接用下面函数str代表需转换的进制字符串，system代表是几进制
        return Integer.parseInt(str, system);
    }

    public static String decimalToOthers(int dec) {
        // Integer自带了十进制转其他进制的函数
        String bin = Integer.toBinaryString(dec);
        String oct = Integer.toOctalString(dec);
        String hex = Integer.toHexString(dec);
        return null;
    }
}
