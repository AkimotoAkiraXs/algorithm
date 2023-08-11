//给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
// 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 注意: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: words = ["This", "is", "an", "example", "of", "text", "justification."], 
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 
//输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 
//输入:words = ["Science","is","what","we","understand","well","enough","to",
//"explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 2
//0
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= words.length <= 300 
// 1 <= words[i].length <= 20 
// words[i] 由小写英文字母和符号组成 
// 1 <= maxWidth <= 100 
// words[i].length <= maxWidth 
// 
//
// Related Topics 数组 字符串 模拟 👍 309 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Id：&emsp;&emsp;68
 * <p>
 * Name：文本左右对齐
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class TextJustification {
    public static void main(String[] args) {
        Solution solution = new TextJustification().new Solution();
//        solution.init();
        solution.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
        System.out.println(Arrays.toString(solution.emptyStrs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int i = 0;
        int len = 0;
        String[] emptyStrs = new String[100];
        List<String> line = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int max;

        private void init() {
            StringBuilder empty = new StringBuilder();
            for (int i = 0; i < emptyStrs.length; i++) {
                emptyStrs[i] = empty.toString();
                empty.append(" ");
            }
        }

        public List<String> fullJustify(String[] words, int maxWidth) {
            this.init();
            this.max = maxWidth;
            while (i < words.length) {
                String word = words[i];
                int size = line.size();
                if (len + word.length() + size > maxWidth) {
                    this.add(size);
                    len = 0;
                    line.clear();
                } else {
                    len += word.length();
                    line.add(word);
                    i++;
                }
            }
            StringBuilder last = new StringBuilder();
            last.append(line.get(0));
            for (int j = 1; j < line.size(); j++) {
                last.append(" ").append(line.get(j));
            }
            last.append(emptyStrs[maxWidth - last.length()]);
            res.add(last.toString());

            return res;
        }

        private void add(int size) {
            if (size == 1) {
                res.add(line.get(0) + emptyStrs[max - len]);
            } else {
                int remain = max - len;
                int aver = remain / (size - 1);
                int pre = remain % (size - 1);
                StringBuilder builder = new StringBuilder();
                builder.append(line.get(0));
                for (int j = 1; j < size; j++) {
                    builder.append(j <= pre ? emptyStrs[aver + 1] : emptyStrs[aver])
                            .append(line.get(j));
                }
                res.add(builder.toString());
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}