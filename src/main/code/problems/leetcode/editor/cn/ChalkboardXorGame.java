// You are given an array of integers nums represents the numbers written on a
// chalkboard.
//
// Alice and Bob take turns erasing exactly one number from the chalkboard, 
// with Alice starting first. If erasing a number causes the bitwise XOR of all the
// elements of the chalkboard to become 0, then that player loses. The bitwise XOR of
// one element is that element itself, and the bitwise XOR of no elements is 0.
//
// Also, if any player starts their turn with the bitwise XOR of all the 
// elements of the chalkboard equal to 0, then that player wins.
//
// Return true if and only if Alice wins the game, assuming both players play 
// optimally.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,1,2]
// Output: false
// Explanation:
// Alice has two choices: erase 1 or erase 2.
// If she erases 1, the nums array becomes [1, 2]. The bitwise XOR of all the
// elements of the chalkboard is 1 XOR 2 = 3. Now Bob can remove any element he wants,
// because Alice will be the one to erase the last element and she will lose. 
// If Alice erases 2 first, now nums become [1, 1]. The bitwise XOR of all the
// elements of the chalkboard is 1 XOR 1 = 0. Alice will lose.
// 
//
// Example 2: 
//
// 
// Input: nums = [0,1]
// Output: true
// 
//
// Example 3: 
//
// 
// Input: nums = [1,2,3]
// Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] < 2¹⁶ 
// 
//
// 👍 157 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;810
 * <p>
 * Name：Chalkboard XOR Game
 *
 * @author Yuri
 * @since 2024-08-01 18:52:10
 */

public class ChalkboardXorGame {

    public static void main(String[] args) {
        Solution solution = new ChalkboardXorGame().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 博弈论：当开始所有数异或为0时，先手赢。
         * 当开始所有数不为0时，考虑如果nums数量大于1时，抽掉某个数可以使剩下数为0，那么也一定可以抽掉另一个数使剩下数不为零。
         * 所以在双方选择都最优的情况下，最后一定是抽最后一个数的人输，所以偶数先手赢，奇数后手赢。
         */
        public boolean xorGame(int[] nums) {
            if (nums.length % 2 == 0) return true;
            int k = 0;
            for (int num : nums) k ^= num;
            return k == 0;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}