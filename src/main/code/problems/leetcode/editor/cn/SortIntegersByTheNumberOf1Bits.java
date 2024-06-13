// You are given an integer array arr. Sort the integers in the array in
// ascending order by the number of 1's in their binary representation and in case of two
// or more integers have the same number of 1's you have to sort them in ascending
// order.
//
// Return the array after sorting it. 
//
// 
// Example 1: 
//
// 
// Input: arr = [0,1,2,3,4,5,6,7,8]
// Output: [0,1,2,4,8,3,5,6,7]
// Explantion: [0] is the only integer with 0 bits.
//[1,2,4,8] all have 1 bit.
//[3,5,6] have 2 bits.
//[7] has 3 bits.
// The sorted array by bits is [0,1,2,4,8,3,5,6,7]
// 
//
// Example 2: 
//
// 
// Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
// Output: [1,2,4,8,16,32,64,128,256,512,1024]
// Explantion: All integers have 1 bit in the binary representation, you should
// just sort them in ascending order.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 500 
// 0 <= arr[i] <= 10⁴ 
// 
//
// 👍 188 👎 0

package problems.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Id：&emsp;&emsp;1356
 * <p>
 * Name：Sort Integers by The Number of 1 Bits
 *
 * @author Yuri
 * @since 2024-06-12 11:53:10
 */

public class SortIntegersByTheNumberOf1Bits {

    public static void main(String[] args) {
        Solution solution = new SortIntegersByTheNumberOf1Bits().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 也可以用dp对0~k进行统计，其中k是最大的数
        public int[] sortByBits(int[] arr) {
            return Arrays.stream(arr).boxed().sorted((a, b) -> {
                int x = Integer.bitCount(a), y = Integer.bitCount(b);
                if (x == y) return a - b;
                return x - y;
            }).mapToInt(i -> i).toArray();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}