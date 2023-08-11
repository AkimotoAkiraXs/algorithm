//猜数字游戏的规则如下： 
//
// 
// 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。 
// 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。 
// 
//
// 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）： 
//
// 
// -1：我选出的数字比你猜的数字小 pick < num 
// 1：我选出的数字比你猜的数字大 pick > num 
// 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num 
// 
//
// 返回我选出的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10, pick = 6
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 1, pick = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：n = 2, pick = 1
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：n = 2, pick = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 1 <= pick <= n 
// 
// Related Topics 二分查找 
// 👍 154 👎 0


/*
 * Id：374
 * Name：猜数字大小
 * Date：2021-06-22 14:53:46
 */
package leetcode.editor.cn;


public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        Solution solution = new GuessNumberHigherOrLower().new Solution();
        System.out.println("Hello world");
    }

    //模拟GuessGame类
    class GuessGame {
        /**
         * Forward declaration of guess API.
         *
         * @param num your guess
         * @return -1 if num is lower than the guess number
         * 1 if num is higher than the guess number
         * otherwise return 0
         * int guess(int num);
         */
        int guess(int num) {
            int pick = 1702766719;
            return Integer.compare(pick, num);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int mid = 0, ans = 1, a = 0, b = n;
            while (ans != 0) {
                mid = a + b >>> 1;
                ans = guess(mid);
                if (ans == 1) {
                    a = mid + 1;
                } else if (ans == -1) {
                    b = mid - 1;
                }
            }
            return mid;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 