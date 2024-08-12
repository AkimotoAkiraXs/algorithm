package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷码
 *
 * @author Yuri
 * @see <a href="https://oi-wiki.org/misc/gray-code/">OI Wiki 格雷码</a>
 * @since 2024/8/12 10:55
 */


public class GrayCode {

    /**
     * 正常数 -> 格雷码
     */
    public int g(int n) {
        return n ^ (n >> 1);
    }

    /**
     * 逆转换
     */
    public int rev_g(int g) {
        int n = 0;
        for (; g > 0; g >>= 1) n ^= g;
        return n;
    }
}
