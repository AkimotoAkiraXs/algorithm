//给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 
//的整数，并以数组形式返回。 
//
// 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,2]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// nums 中的每个元素出现 一次 或 两次 
// 
//
// Related Topics 数组 哈希表 👍 651 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;442
 * <p>
 * Name：数组中重复的数据
 *
 * @author Yuri
 * @since 2022-08-17 10:59:06
 */
public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllDuplicatesInAnArray().new Solution();
        solution.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
/*
        // 利用treeMap的key自带红黑树排序进行操作，但TreeMap不属于返回值(返回值不计算空间)，所以不满足空间复杂度O(1)
        public List<Integer> findDuplicates(int[] nums) {
            Map<Integer, Integer> map = new TreeMap<>();
            int n = nums.length + 1;
            for (int num : nums) {
                nums[num % n - 1] += n;
            }
            for (int num : nums) {
                int k = num % n;
                if (nums[k - 1] / n >= 2) {
                    map.put(k, 1);
                }
            }
            return new ArrayList<>(map.keySet());
        }
*/

/*

        // 交换数组元素
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != nums[nums[i] - 1])
                    swap(nums, i, nums[i] - 1);
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] - 1 != i) list.add(nums[i]);
            }
            return list;
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
*/

        // 正负号
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                int index = Math.abs(num) - 1;
                if (nums[index] < 0) list.add(index + 1);
                else nums[index] = -nums[index];
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}