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
        int a = -1;
        System.out.println(Integer.toBinaryString(-3));
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
    private static int lowBit(int k) {
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
    private static int highBit(int k) {
        while ((k & (k - 1)) != 0) k &= k - 1;
        return k;
    }

    /**
     * 获取一个数的二进制长度
     *
     * @param k 需要处理的整数
     * @return num转2进制后的长度
     */
    private static int binaryLen(int k) {
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

    /**
     * 计算整数中二进制1的个数
     * <p>
     * 方法1：i>>1 == 1循环暴力计算
     * <p>
     * 方法2：i & (i-1)
     * <p>
     * 方法3：Integer.bitCount()，以下是源码思路：
     * 整体思想是分治，先统计小范围1的个数，然后整合起来，最后全部整合到最右边8位，然后与0x3f则返回了答案
     *
     */
    private static int bitLen(int i) {
        // return Integer.bitCount(i);
        // 0x55555555   01010101 01010101 01010101 01010101
        // 0x33333333	00110011 00110011 00110011 00110011
        // 0x0f0f0f0f	00001111 00001111 00001111 00001111
        // 0x3f	        00000000 00000000 00000000 00111111
        i = i - ((i >>> 1) & 0x55555555); // 等价于：i = (i & 0x55555555) + ((i >>> 1) & 0x55555555); 2位一组求1的个数，左边求偶数位 + 右边求奇数位
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333); // 同上，4位一组求1的个数
        i = (i + (i >>> 4)) & 0x0f0f0f0f; // 同上，8位一组求1的个数
        i = i + (i >>> 8); // 同上，16位一组
        i = i + (i >>> 16); // 32位一组，最后答案集中在最后8位
        return i & 0x3f; // 最大值32也不会超过0x3f
    }
}
