// Given an integer array arr, return the number of distinct bitwise ORs of all
// the non-empty subarrays of arr.
//
// The bitwise OR of a subarray is the bitwise OR of each integer in the 
// subarray. The bitwise OR of a subarray of one integer is that integer.
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
// Input: arr = [0]
// Output: 1
// Explanation: There is only one possible result: 0.
// 
//
// Example 2: 
//
// 
// Input: arr = [1,1,2]
// Output: 3
// Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1,
// 2].
// These yield the results 1, 1, 2, 1, 3, 3.
// There are 3 unique values, so the answer is 3.
// 
//
// Example 3: 
//
// 
// Input: arr = [1,2,4]
// Output: 6
// Explanation: The possible results are 1, 2, 3, 4, 6, and 7.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 5 * 10⁴ 
// 0 <= arr[i] <= 10⁹ 
// 
//
// 👍 153 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Id：&emsp;&emsp;898
 * <p>
 * Name：Bitwise ORs of Subarrays
 *
 * @author Yuri
 * @since 2024-07-04 16:02:42
 */

public class BitwiseOrsOfSubarrays {

    public static void main(String[] args) {
        Solution solution = new BitwiseOrsOfSubarrays().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 模板题
        public int subarrayBitwiseORs(int[] arr) {
            Set<Integer> hash = new HashSet<>();
            List<int[]> ors = new ArrayList<>();
            for (int num : arr) {
                ors.add(new int[]{0});
                int k = 0;
                for (int[] or : ors) {
                    or[0] |= num;
                    hash.add(or[0]);
                    if (ors.get(k)[0] != or[0]) ors.set(++k, or);
                }
                ors.subList(k + 1, ors.size()).clear();
            }
            return hash.size();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}