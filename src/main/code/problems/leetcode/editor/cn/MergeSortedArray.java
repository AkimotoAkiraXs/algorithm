package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;88 <br/>
 * Name：Merge Sorted Array <br/>
 *
 * @author Yuri
 * @since 2023-08-13 09:33:57
 */

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        solution.merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // O(1)空间复杂度 技巧题：正难则反，倒着插入
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p = m - 1, q = n - 1;
            for (int i = m + n - 1; i >= 0; i--) {
                if (p < 0) nums1[i] = nums2[q--];
                else if (q < 0 || nums1[p] > nums2[q]) nums1[i] = nums1[p--];
                else nums1[i] = nums2[q--];
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
