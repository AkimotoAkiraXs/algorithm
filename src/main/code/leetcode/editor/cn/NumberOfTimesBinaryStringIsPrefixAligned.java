// You have a 1-indexed binary string of length n where all the bits are 0
// initially. We will flip all the bits of this binary string (i.e., change them from 0
// to 1) one by one. You are given a 1-indexed integer array flips where flips[i]
// indicates that the bit at index i will be flipped in the iᵗʰ step.
//
// A binary string is prefix-aligned if, after the iᵗʰ step, all the bits in 
// the inclusive range [1, i] are ones and all the other bits are zeros.
//
// Return the number of times the binary string is prefix-aligned during the 
// flipping process.
//
// 
// Example 1: 
//
// 
// Input: flips = [3,2,4,1,5]
// Output: 2
// Explanation: The binary string is initially "00000".
// After applying step 1: The string becomes "00100", which is not prefix-
// aligned.
// After applying step 2: The string becomes "01100", which is not prefix-
// aligned.
// After applying step 3: The string becomes "01110", which is not prefix-
// aligned.
// After applying step 4: The string becomes "11110", which is prefix-aligned.
// After applying step 5: The string becomes "11111", which is prefix-aligned.
// We can see that the string was prefix-aligned 2 times, so we return 2.
// 
//
// Example 2: 
//
// 
// Input: flips = [4,1,2,3]
// Output: 1
// Explanation: The binary string is initially "0000".
// After applying step 1: The string becomes "0001", which is not prefix-aligned.
//
// After applying step 2: The string becomes "1001", which is not prefix-aligned.
//
// After applying step 3: The string becomes "1101", which is not prefix-aligned.
//
// After applying step 4: The string becomes "1111", which is prefix-aligned.
// We can see that the string was prefix-aligned 1 time, so we return 1.
// 
//
// 
// Constraints: 
//
// 
// n == flips.length 
// 1 <= n <= 5 * 10⁴ 
// flips is a permutation of the integers in the range [1, n]. 
// 
//
// Related Topics 数组 👍 80 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1375
 * <p>
 * Name：Number of Times Binary String Is Prefix-Aligned
 *
 * @author Yuri
 * @since 2023-06-14 09:42:55
 */


public class NumberOfTimesBinaryStringIsPrefixAligned {
    public static void main(String[] args) {
        Solution solution = new NumberOfTimesBinaryStringIsPrefixAligned().new Solution();
        solution.numTimesAllBlue(new int[]{4, 1, 2, 3});

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTimesAllBlue(int[] flips) {
            int n = flips.length;
            int max = Integer.MIN_VALUE;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int k = flips[i];
                max = Math.max(max, k);
                if (max == i + 1) cnt++;
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
