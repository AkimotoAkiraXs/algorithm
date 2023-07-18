package leetcode.editor.cn;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Id：&emsp;&emsp;2781 <br/>
 * Name：Length of the Longest Valid Substring <br/>
 *
 * @author Yuri
 * @since 2023-07-18 21:56:07
 */

public class LengthOfTheLongestValidSubstring {
    public static void main(String[] args) {
        Solution solution = new LengthOfTheLongestValidSubstring().new Solution();
        System.out.println(solution.longestValidSubstring("cbaaaabc", Lists.newArrayList(
                "aaa", "cb"
        )));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 双指针：因为forbidden中字符串<=10，所以直接暴力
         */
        public int longestValidSubstring(String word, List<String> forbidden) {
            Set<String> hash = new HashSet<>(forbidden);
            int max = 0, n = word.length();
            for (int r = 1, l = 0; r <= n; r++) {
                for (int i = r - 1; i >= Math.max(r - 10, l); i--) { // 从右开始，找到直接更新，如果从左开始找到也不一定是答案
                    if (hash.contains(word.substring(i, r))) {
                        l = i + 1;
                        break;
                    }
                }
                max = Math.max(max, r - l); // 第二层循环出来的字符串一定是合法的，可能有空串
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
