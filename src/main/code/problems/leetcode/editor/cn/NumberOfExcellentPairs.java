// You are given a 0-indexed positive integer array nums and a positive integer
// k.
//
// A pair of numbers (num1, num2) is called excellent if the following 
// conditions are satisfied:
//
// 
// Both the numbers num1 and num2 exist in the array nums. 
// The sum of the number of set bits in num1 OR num2 and num1 AND num2 is 
// greater than or equal to k, where OR is the bitwise OR operation and AND is the
// bitwise AND operation.
// 
//
// Return the number of distinct excellent pairs. 
//
// Two pairs (a, b) and (c, d) are considered distinct if either a != c or b != 
// d. For example, (1, 2) and (2, 1) are distinct.
//
// Note that a pair (num1, num2) such that num1 == num2 can also be excellent 
// if you have at least one occurrence of num1 in the array.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,3,1], k = 3
// Output: 5
// Explanation: The excellent pairs are the following:
//- (3, 3). (3 AND 3) and (3 OR 3) are both equal to (11) in binary. The total 
// number of set bits is 2 + 2 = 4, which is greater than or equal to k = 3.
//- (2, 3) and (3, 2). (2 AND 3) is equal to (10) in binary, and (2 OR 3) is 
// equal to (11) in binary. The total number of set bits is 1 + 2 = 3.
//- (1, 3) and (3, 1). (1 AND 3) is equal to (01) in binary, and (1 OR 3) is 
// equal to (11) in binary. The total number of set bits is 1 + 2 = 3.
// So the number of excellent pairs is 5.
//
// Example 2: 
//
// 
// Input: nums = [5,1,1], k = 10
// Output: 0
// Explanation: There are no excellent pairs for this array.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 60 
// 
//
// 👍 45 👎 0

package problems.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2354
 * <p>
 * Name：Number of Excellent Pairs
 *
 * @author Yuri
 * @since 2024-07-24 17:15:12
 */

public class NumberOfExcellentPairs {

    public static void main(String[] args) {
        Solution solution = new NumberOfExcellentPairs().new Solution();
        solution.countExcellentPairs(new int[]{1, 2, 3, 1}, 3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long countExcellentPairs(int[] nums, int k) {
            final int U = 30;
            int[] cnt = new int[U];
            Arrays.stream(nums).distinct().forEach(num -> cnt[Integer.bitCount(num)]++);
            long res = 0;
            for (int i = 0; i < U; i++) { // 可以用后缀和优化
                for (int j = i; j < U; j++) {
                    if (i + j >= k) {
                        long sum = (long) cnt[i] * cnt[j];
                        res += sum;
                        if (i != j) res += sum;
                    }
                }
            }
            return res;
        }

        // 记录每位数bit+二分，很蠢的做法
        public long countExcellentPairs_(int[] nums, int k) {
            nums = Arrays.stream(nums).distinct().toArray();
            int n = nums.length;
            int[] cnt = new int[n];
            for (int i = 0; i < n; i++) cnt[i] = Integer.bitCount(nums[i]); // cnt
            Arrays.sort(cnt);
            long ans = 0;
            for (int i = 0; i < n; i++) {
                int l = i, r = n;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (cnt[i] + cnt[mid] < k) l = mid + 1;
                    else r = mid;
                }
                ans += (n - l) * 2L;
                if (i == l) ans--; // 自身与自身只能计算一次
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}