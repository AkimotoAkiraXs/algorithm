// You are given a sorted integer array arr containing 1 and prime numbers,
// where all the integers of arr are unique. You are also given an integer k.
//
// For every i and j where 0 <= i < j < arr.length, we consider the fraction 
// arr[i] / arr[j].
//
// Return the kᵗʰ smallest fraction considered. Return your answer as an array 
// of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].
//
// 
// Example 1: 
//
// 
// Input: arr = [1,2,3,5], k = 3
// Output: [2,5]
// Explanation: The fractions to be considered in sorted order are:
// 1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
// The third fraction is 2/5.
// 
//
// Example 2: 
//
// 
// Input: arr = [1,7], k = 1
// Output: [1,7]
// 
//
// 
// Constraints: 
//
// 
// 2 <= arr.length <= 1000 
// 1 <= arr[i] <= 3 * 10⁴ 
// arr[0] == 1 
// arr[i] is a prime number for i > 0. 
// All the numbers of arr are unique and sorted in strictly increasing order. 
// 1 <= k <= arr.length * (arr.length - 1) / 2 
// 
//
// 
// Follow up: Can you solve the problem with better than
// O(n²) complexity?
//
// 👍 293 👎 0

package problems.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * Id：&emsp;&emsp;786
 * <p>
 * Name：K-th Smallest Prime Fraction
 *
 * @author Yuri
 * @since 2024-09-24 17:50:31
 */

public class KThSmallestPrimeFraction {

    public static void main(String[] args) {
        Solution solution = new KThSmallestPrimeFraction().new Solution();
        solution.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int n = arr.length;
            PriorityQueue<int[]> queue = new PriorityQueue<>(
                (o1, o2) -> {
                    double a = (double) arr[o1[0]] / arr[o1[1]], b = (double) arr[o2[0]] / arr[o2[1]];
                    if (a == b) return 0;
                    return a > b ? 1 : -1;
                });
            queue.add(new int[]{0, n - 1});
            while (true) {
                int[] q = queue.poll();
                int x = q[0], y = q[1];
                if (--k == 0) return new int[]{arr[x], arr[y]};
                if (y == n - 1 && x + 1 < n) queue.add(new int[]{x + 1, y});
                if (y - 1 >= 0) queue.add(new int[]{x, y - 1});
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}