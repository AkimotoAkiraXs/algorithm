// You are given a 0-indexed integer array nums. A pair of indices i, j where 0 <
//= i < j < nums.length is called beautiful if the first digit of nums[i] and the 
// last digit of nums[j] are coprime.
//
// Return the total number of beautiful pairs in nums. 
//
// Two integers x and y are coprime if there is no integer greater than 1 that 
// divides both of them. In other words, x and y are coprime if gcd(x, y) == 1,
// where gcd(x, y) is the greatest common divisor of x and y.
//
// 
// Example 1: 
//
// 
// Input: nums = [2,5,1,4]
// Output: 5
// Explanation: There are 5 beautiful pairs in nums:
// When i = 0 and j = 1: the first digit of nums[0] is 2, and the last digit of
// nums[1] is 5. We can confirm that 2 and 5 are coprime, since gcd(2,5) == 1.
// When i = 0 and j = 2: the first digit of nums[0] is 2, and the last digit of
// nums[2] is 1. Indeed, gcd(2,1) == 1.
// When i = 1 and j = 2: the first digit of nums[1] is 5, and the last digit of
// nums[2] is 1. Indeed, gcd(5,1) == 1.
// When i = 1 and j = 3: the first digit of nums[1] is 5, and the last digit of
// nums[3] is 4. Indeed, gcd(5,4) == 1.
// When i = 2 and j = 3: the first digit of nums[2] is 1, and the last digit of
// nums[3] is 4. Indeed, gcd(1,4) == 1.
// Thus, we return 5.
// 
//
// Example 2: 
//
// 
// Input: nums = [11,21,12]
// Output: 2
// Explanation: There are 2 beautiful pairs:
// When i = 0 and j = 1: the first digit of nums[0] is 1, and the last digit of
// nums[1] is 1. Indeed, gcd(1,1) == 1.
// When i = 0 and j = 2: the first digit of nums[0] is 1, and the last digit of
// nums[2] is 2. Indeed, gcd(1,2) == 1.
// Thus, we return 2.
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 100 
// 1 <= nums[i] <= 9999 
// nums[i] % 10 != 0 
// 
//
// 👍 1 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2748
 * <p>
 * Name：Number of Beautiful Pairs
 * <p>
 * 单周赛351 Q1
 *
 * @author Yuri
 * @since 2023-06-26 17:23:24
 */


public class NumberOfBeautifulPairs {
    public static void main(String[] args) {
        Solution solution = new NumberOfBeautifulPairs().new Solution();
        solution.countBeautifulPairs(new int[]{756, 1324, 2419, 495, 106, 111, 1649, 1474, 2001, 1633, 273, 1804, 2102, 1782, 705, 1529, 1761, 1613, 111, 186, 412});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBeautifulPairs(int[] nums) {
            int[] cnt = new int[10];
            int res = 0;
            for (int num : nums) {
                int l = num % 10;
                for (int i = 1; i < 10; i++) {
                    if (gcd(i, l) == 1) res += cnt[i];
                }
                while (num >= 10) num /= 10;
                cnt[num]++;
            }
            return res;
        }

        int gcd(int a, int b) {
            if (b > a) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
