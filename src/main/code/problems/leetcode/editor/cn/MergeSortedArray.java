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
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // O(1)空间复杂度 技巧题：正难则反，倒着插入
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index = m + n - 1;
            m--;
            n--;
            while (m >= 0 && n >= 0) {
                if (nums1[m] > nums2[n]) nums1[index--] = nums1[m--];
                else nums1[index--] = nums2[n--];
            }
            while (m >= 0) nums1[index--] = nums1[m--];
            while (n >= 0) nums1[index--] = nums2[n--];

        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
