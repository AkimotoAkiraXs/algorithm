// Given an integer array arr, remove a subarray (can be empty) from arr such
// that the remaining elements in arr are non-decreasing.
//
// Return the length of the shortest subarray to remove. 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
// Input: arr = [1,2,3,10,4,2,3,5]
// Output: 3
// Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The
// remaining elements after that will be [1,2,3,3,5] which are sorted.
// Another correct solution is to remove the subarray [3,10,4].
// 
//
// Example 2: 
//
// 
// Input: arr = [5,4,3,2,1]
// Output: 4
// Explanation: Since the array is strictly decreasing, we can only keep a
// single element. Therefore we need to remove a subarray of length 4, either [5,4,3,2]
// or [4,3,2,1].
// 
//
// Example 3: 
//
// 
// Input: arr = [1,2,3]
// Output: 0
// Explanation: The array is already non-decreasing. We do not need to remove
// any elements.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁵ 
// 0 <= arr[i] <= 10⁹ 
// 
//
// 👍 218 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1574
 * <p>
 * Name：Shortest Subarray to be Removed to Make Array Sorted
 *
 * @author Yuri
 * @since 2023-09-15 09:40:00
 */

public class ShortestSubarrayToBeRemovedToMakeArraySorted {

    public static void main(String[] args) {
        Solution solution = new ShortestSubarrayToBeRemovedToMakeArraySorted().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findLengthOfShortestSubarray(int[] arr) {
            int n = arr.length;
            var r = n - 1;
            for (; r > 0; r--) if (arr[r] < arr[r - 1]) break; // 先找到右边非递减
            var ans = r; // ans初始化为r是考虑把左边全部删除的极端情况
            if (r == 0) return 0; // 如果已经到左端点就直接返回答案
            for (int l = 0; l < r; l++) {
                if (l != 0 && arr[l] < arr[l - 1]) break; // 如果左边已经不再非递减就不用再找了
                while (r < n && arr[l] > arr[r]) r++;
                ans = Math.min(ans, r - l - 1);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}