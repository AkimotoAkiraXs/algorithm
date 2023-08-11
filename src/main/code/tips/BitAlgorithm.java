package tips;

import lombok.Data;

/**
 * 判断整数是否为2的幂
 *
 * @author Yuri
 * @since 2023/2/13 10:52
 */
@Data
public class BitAlgorithm {

    public static void main(String[] args) {
        int higherBitOfTwo = getHigherBitOfTwo(Integer.parseInt("000000101010100", 2));
        System.out.println(higherBitOfTwo);
    }

    /**
     * 判断整数是否为2的幂
     *
     * @param num 需要判断的整数
     * @return 整数是否为2的幂
     */
    private static boolean isPowerOfTwo(int num) {
        // 利用计算机二进制
        return (num & (num - 1)) == 0;
    }

    /**
     * 获取整数2进制最低位（右位）
     *
     * @param num 需要处理的整数
     * @return 整数2进制下的最低位
     */
    private static int getLowerBitOfTwo(int num) {
        return num - (num & (num - 1));
    }

    /**
     * 获取整数2进制最高位（左位）
     *
     * @param num 需要处理的整数
     * @return 整数2进制下的最高位
     */
    private static int getHigherBitOfTwo(int num) {
        while ((num & (num - 1)) != 0) num &= num - 1;
        return num;
    }

    /**
     * 获取一个数的二进制长度
     *
     * @param num 需要处理的整数
     * @return num转2进制后的长度
     */
    private static int getLenOfBit(int num) {
        int len = 0;
        for (int i = 31; i > 0; i--) {
            if (num >> i == 1) {
                len = i;
                break;
            }
        }
        return len;
        // return Integer.toBinaryString(num).length();
    }
}
