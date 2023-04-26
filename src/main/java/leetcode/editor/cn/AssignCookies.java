// Assume you are an awesome parent and want to give your children some cookies.
// But, you should give each child at most one cookie.
//
// Each child i has a greed factor g[i], which is the minimum size of a cookie 
// that the child will be content with; and each cookie j has a size s[j]. If s[j] >
//= g[i], we can assign the cookie j to the child i, and the child i will be 
// content. Your goal is to maximize the number of your content children and output the
// maximum number.
//
// 
// Example 1: 
//
// 
// Input: g = [1,2,3], s = [1,1]
// Output: 1
// Explanation: You have 3 children and 2 cookies. The greed factors of 3
// children are 1, 2, 3.
// And even though you have 2 cookies, since their size is both 1, you could
// only make the child whose greed factor is 1 content.
// You need to output 1.
// 
//
// Example 2: 
//
// 
// Input: g = [1,2], s = [1,2,3]
// Output: 2
// Explanation: You have 2 children and 3 cookies. The greed factors of 2
// children are 1, 2.
// You have 3 cookies and their sizes are big enough to gratify all of the
// children,
// You need to output 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= g.length <= 3 * 10⁴ 
// 0 <= s.length <= 3 * 10⁴ 
// 1 <= g[i], s[j] <= 2³¹ - 1 
// 
//
// Related Topics 贪心 数组 双指针 排序 👍 701 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;455
 * <p>
 * Name：Assign Cookies
 *
 * @author Yuri
 * @since 2023-04-26 17:14:16
 */


public class AssignCookies {
    public static void main(String[] args) {
        Solution solution = new AssignCookies().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int cnt = 0;
            int ss = s.length;
            for (int i = g.length - 1; i >= 0 && ss > 0; i--) {
                if (g[i] <= s[--ss]) cnt++;
                else ss++;
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
