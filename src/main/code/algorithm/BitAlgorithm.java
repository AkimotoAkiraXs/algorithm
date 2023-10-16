package algorithm;

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
     * @param k 需要判断的整数
     * @return 整数是否为2的幂
     */
    private static boolean isPowerOfTwo(int k) {
        // 利用计算机二进制
        return (k & (k - 1)) == 0;
    }

    /**
     * 获取整数2进制最低位（右位）
     *
     * @param k 需要处理的整数
     * @return 整数2进制下的最低位
     */
    private static int getLowerBitOfTwo(int k) {
        return k - (k & (k - 1));
        // return k & -k;
        // return k & (k-1) ^ k
    }

    /**
     * 获取整数2进制最高位（左位）
     *
     * @param k 需要处理的整数
     * @return 整数2进制下的最高位
     */
    private static int getHigherBitOfTwo(int k) {
        while ((k & (k - 1)) != 0) k &= k - 1;
        return k;
    }

    /**
     * 获取一个数的二进制长度
     *
     * @param k 需要处理的整数
     * @return num转2进制后的长度
     */
    private static int getLenOfBit(int k) {
        int len = 0;
        for (int i = 31; i > 0; i--) {
            if (k >> i == 1) {
                len = i;
                break;
            }
        }
        return len;
        // return Integer.toBinaryString(k).length();
    }
}
