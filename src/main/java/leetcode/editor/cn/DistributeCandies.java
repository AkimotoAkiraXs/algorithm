// Alice has n candies, where the iᵗʰ candy is of type candyType[i]. Alice
// noticed that she started to gain weight, so she visited a doctor.
//
// The doctor advised Alice to only eat n / 2 of the candies she has (n is 
// always even). Alice likes her candies very much, and she wants to eat the maximum
// number of different types of candies while still following the doctor's advice.
//
// Given the integer array candyType of length n, return the maximum number of 
// different types of candies she can eat if she only eats n / 2 of them.
//
// 
// Example 1: 
//
// 
// Input: candyType = [1,1,2,2,3,3]
// Output: 3
// Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3
// types, she can eat one of each type.
// 
//
// Example 2: 
//
// 
// Input: candyType = [1,1,2,3]
// Output: 2
// Explanation: Alice can only eat 4 / 2 = 2 candies. Whether she eats types [1,2
//], [1,3], or [2,3], she still can only eat 2 different types.
// 
//
// Example 3: 
//
// 
// Input: candyType = [6,6,6,6]
// Output: 1
// Explanation: Alice can only eat 4 / 2 = 2 candies. Even though she can eat 2
// candies, she only has 1 type.
// 
//
// 
// Constraints: 
//
// 
// n == candyType.length 
// 2 <= n <= 10⁴ 
// n is even. 
// -10⁵ <= candyType[i] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 👍 238 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * Id：&emsp;&emsp;575
 * <p>
 * Name：Distribute Candies
 *
 * @author Yuri
 * @since 2023-04-26 17:30:46
 */


public class DistributeCandies {
    public static void main(String[] args) {
        Solution solution = new DistributeCandies().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distributeCandies(int[] candyType) {
            // Set<Integer> set = Arrays.stream(candyType).boxed().collect(Collectors.toSet()); // Java8虽然优雅但是慢
            Set<Integer> eat = new HashSet<>();
            for (int type : candyType) {
                if (eat.size() >= candyType.length/2) break;
                eat.add(type);
            }
            return eat.size();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
