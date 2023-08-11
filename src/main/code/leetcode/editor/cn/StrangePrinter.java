//有台奇怪的打印机有以下两个特殊要求： 
//
// 
// 打印机每次只能打印由 同一个字符 组成的序列。 
// 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。 
// 
//
// 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabbb"
//输出：2
//解释：首先打印 "aaa" 然后打印 "bbb"。
// 
//
// 示例 2： 
//
// 
//输入：s = "aba"
//输出：2
//解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 209 👎 0


/*
 * Id：664
 * Name：奇怪的打印机
 * Date：2021-06-22 15:07:55
 */
package leetcode.editor.cn;

public class StrangePrinter {
    public static void main(String[] args) {
        Solution solution = new StrangePrinter().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 简单dp 因为是从头开始 所ary[j][i]表示区间j-i的最小打印数
         */
        public int strangePrinter(String s) {
            int size = s.length();
            int[][] ary = new int[size + 1][size + 1];
            for (int i = 0; i < size; i++) {
                ary[i][i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    int minn = Integer.MAX_VALUE;
                    if (s.charAt(i) == s.charAt(j)) {
                        ary[j][i] = ary[j + 1][i];
                    } else {
                        for (int k = i; k > j; k--) {
                            minn = Math.min(minn, ary[j][k - 1] + ary[k][i]);
                        }
                        ary[j][i] = minn;
                    }
                }
            }
            return ary[0][size - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 