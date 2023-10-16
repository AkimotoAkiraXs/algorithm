//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2149 👎 0


package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;136
 * <p>
 * Name：只出现一次的数字
 *
 * @author Yuri
 * @see SingleNumberIi
 * @see SingleNumberIii
 * @since 2021-12-14 16:53:28
 */
public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        System.out.println();
    }

    /**
     * 异或运算有以下三个性质：
     * <p>
     * 任何数和 00 做异或运算，结果仍然是原来的数，即 a⊕0=a。<p>
     * 任何数和其自身做异或运算，结果是0,即 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int num = 0;
            for (int i : nums) {
                num ^= i;
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}