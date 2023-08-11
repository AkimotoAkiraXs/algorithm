package tips;

/**
 * @author Yuri
 * @since 2023/5/17 16:45
 */


public class MathTips {


    /**
     * 模运算
     * <p>
     * 当动态规划转移方程含有减法且需要取模时，此时不能对状态转移方程直接取模 <br>
     * 设状态转移方程为x=(2*dp[i-1]-dp[i-2])，此时取模公式为：<br>
     * dp[i] = ( x % mod + mod) % mod
     * <p>
     * refer：{@link leetcode.editor.cn.StudentAttendanceRecordIi 学生出勤记录II}
     */
    private static void modCalculate() {
        final double mod = 107;
        double[] dp = new double[100];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 100; i++) dp[i] = ((dp[i - 1] * 2 - dp[i - 2]) % mod + mod) % mod;
    }
}
