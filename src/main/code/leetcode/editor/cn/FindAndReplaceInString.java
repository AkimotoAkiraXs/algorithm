// You are given a 0-indexed string s that you must perform k replacement
// operations on. The replacement operations are given as three 0-indexed parallel arrays,
// indices, sources, and targets, all of length k. 
//
// To complete the iᵗʰ replacement operation: 
//
// 
// Check if the substring sources[i] occurs at index indices[i] in the original 
// string s.
// If it does not occur, do nothing. 
// Otherwise if it does occur, replace that substring with targets[i]. 
// 
//
// For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i]
// = "eee", then the result of this replacement will be "eeecd". 
//
// All replacement operations must occur simultaneously, meaning the 
// replacement operations should not affect the indexing of each other. The testcases will be
// generated such that the replacements will not overlap.
//
// 
// For example, a testcase with s = "abc", indices = [0, 1], and sources = [
//"ab","bc"] will not be generated because the "ab" and "bc" replacements overlap. 
// 
//
// Return the resulting string after performing all replacement operations on s.
// 
//
// A substring is a contiguous sequence of characters in a string. 
//
// 
// Example 1: 
// 
// 
// Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee",
//"ffff"]
// Output: "eeebffff"
// Explanation:
//"a" occurs at index 0 in s, so we replace it with "eee".
//"cd" occurs at index 2 in s, so we replace it with "ffff".
// 
//
// Example 2: 
// 
// 
// Input: s = "abcd", indices = [0, 2], sources = ["ab","ec"], targets = ["eee",
//"ffff"]
// Output: "eeecd"
// Explanation:
//"ab" occurs at index 0 in s, so we replace it with "eee".
//"ec" does not occur at index 2 in s, so we do nothing.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// k == indices.length == sources.length == targets.length 
// 1 <= k <= 100 
// 0 <= indexes[i] < s.length 
// 1 <= sources[i].length, targets[i].length <= 50 
// s consists of only lowercase English letters. 
// sources[i] and targets[i] consist of only lowercase English letters. 
// 
//
// 👍 142 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Id：&emsp;&emsp;833
 * <p>
 * Name：Find And Replace in String
 *
 * @author Yuri
 * @since 2023-08-15 18:51:33
 */


public class FindAndReplaceInString {
    public static void main(String[] args) {
        Solution solution = new FindAndReplaceInString().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    // 排序+暴力模拟
    class Solution {
        class Obj {
            public Obj(int index, String source, String target) {
                this.index = index;
                this.source = source;
                this.target = target;
            }

            int index;
            String source;
            String target;


        }

        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
            PriorityQueue<Obj> objs = new PriorityQueue<>(Comparator.comparingInt(o -> o.index));
            int n = indices.length;
            for (int i = 0; i < n; i++) objs.add(new Obj(indices[i], sources[i], targets[i]));
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while (!objs.isEmpty()) {
                Obj obj = objs.poll();
                int len = obj.source.length();
                if (obj.index + len > s.length()) break;
                sb.append(s, i, obj.index);
                String str = s.substring(obj.index, obj.index + len);
                if (str.equals(obj.source)) sb.append(obj.target);
                else sb.append(str);
                i = obj.index + len;
            }
            sb.append(s, i, s.length());
            return sb.toString();
        }


    }
// leetcode submit region end(Prohibit modification and deletion)

} 
