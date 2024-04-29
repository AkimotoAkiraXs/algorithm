// A teacher is writing a test with n true/false questions, with 'T' denoting
// true and 'F' denoting false. He wants to confuse the students by maximizing the
// number of consecutive questions with the same answer (multiple trues or multiple
// falses in a row).
//
// You are given a string answerKey, where answerKey[i] is the original answer 
// to the iᵗʰ question. In addition, you are given an integer k, the maximum number
// of times you may perform the following operation:
//
// 
// Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] 
// to 'T' or 'F').
// 
//
// Return the maximum number of consecutive 'T's or 'F's in the answer key 
// after performing the operation at most k times.
//
// 
// Example 1: 
//
// 
// Input: answerKey = "TTFF", k = 2
// Output: 4
// Explanation: We can replace both the 'F's with 'T's to make answerKey =
//"TTTT".
// There are four consecutive 'T's.
// 
//
// Example 2: 
//
// 
// Input: answerKey = "TFFT", k = 1
// Output: 3
// Explanation: We can replace the first 'T' with an 'F' to make answerKey =
//"FFFT".
// Alternatively, we can replace the second 'T' with an 'F' to make answerKey =
//"TFFF".
// In both cases, there are three consecutive 'F's.
// 
//
// Example 3: 
//
// 
// Input: answerKey = "TTFTTFTT", k = 1
// Output: 5
// Explanation: We can replace the first 'F' to make answerKey = "TTTTTFTT"
// Alternatively, we can replace the second 'F' to make answerKey = "TTFTTTTT".
// In both cases, there are five consecutive 'T's.
// 
//
// 
// Constraints: 
//
// 
// n == answerKey.length 
// 1 <= n <= 5 * 10⁴ 
// answerKey[i] is either 'T' or 'F' 
// 1 <= k <= n 
// 
//
// 👍 222 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2024
 * <p>
 * Name：Maximize the Confusion of an Exam
 *
 * @author Yuri
 * @since 2024-04-29 18:50:40
 */

public class MaximizeTheConfusionOfAnExam {

    public static void main(String[] args) {
        Solution solution = new MaximizeTheConfusionOfAnExam().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxConsecutiveAnswers(String answerKey, int k) {
            char[] cs = answerKey.toCharArray();
            int n = cs.length;
            int mf = 0, mt = 0, lf = 0, lt = 0, cf = 0, ct = 0;
            for (int r = 0; r < n; r++) {
                if (cs[r] == 'T') cf++;
                else ct++;
                while (ct > k && cs[lt++] == 'F') ct--;
                while (cf > k && cs[lf++] == 'T') cf--;
                mt = Math.max(mt, r - lt + 1);
                mf = Math.max(mf, r - lf + 1);
            }
            return Math.max(mt, mf);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}