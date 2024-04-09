//The k-beauty of an integer num is defined as the number of substrings of num 
//when it is read as a string that meet the following conditions: 
//
// 
// It has a length of k. 
// It is a divisor of num. 
// 
//
// Given integers num and k, return the k-beauty of num. 
//
// Note: 
//
// 
// Leading zeros are allowed. 
// 0 is not a divisor of any value. 
// 
//
// A substring is a contiguous sequence of characters in a string. 
//
// 
// Example 1: 
//
// 
//Input: num = 240, k = 2
//Output: 2
//Explanation: The following are the substrings of num of length k:
//- "24" from "240": 24 is a divisor of 240.
//- "40" from "240": 40 is a divisor of 240.
//Therefore, the k-beauty is 2.
// 
//
// Example 2: 
//
// 
//Input: num = 430043, k = 2
//Output: 2
//Explanation: The following are the substrings of num of length k:
//- "43" from "430043": 43 is a divisor of 430043.
//- "30" from "430043": 30 is not a divisor of 430043.
//- "00" from "430043": 0 is not a divisor of 430043.
//- "04" from "430043": 4 is not a divisor of 430043.
//- "43" from "430043": 43 is a divisor of 430043.
//Therefore, the k-beauty is 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num <= 10⁹ 
// 1 <= k <= num.length (taking num as a string) 
// 
//
// 👍 22 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2269
 * <p>
 * Name：Find the K-Beauty of a Number
 *
 * @author Yuri
 * @since 2024-04-09 18:48:06
 */

public class FindTheKBeautyOfANumber {
    public static void main(String[] args) {
        Solution solution = new FindTheKBeautyOfANumber().new Solution();
        solution.divisorSubstrings(276013000, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divisorSubstrings(int num, int k) {
            long p = (long) Math.pow(10, k);
            int q = 1;
            int cnt = 0;
            while (num / (p / 10) > 0) {
                int x = (int) (num % p / q);
                if (x != 0 && num % x == 0) cnt++;
                p *= 10;
                q *= 10;
            }
            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}