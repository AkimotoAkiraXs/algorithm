package tips;

import lombok.Data;

/**
 * 判断整数是否为2的幂
 *
 * @author Yuri
 * @since 2023/2/13 10:52
 */
@Data
public class JudgePowerOf2 {

    public static boolean judge(int num) {
        // 利用计算机二进制
        return (num & (num - 1)) == 0;
    }
}
