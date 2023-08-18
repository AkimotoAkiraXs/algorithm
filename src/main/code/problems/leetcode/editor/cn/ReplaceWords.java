//在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词
//根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。 
//
// 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继
//承词有许多可以形成它的词根，则用最短的词根替换它。 
//
// 你需要输出替换之后的句子。 
//
// 
//
// 示例 1： 
//
// 
//输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by 
//the battery"
//输出："the cat was rat by the bat"
// 
//
// 示例 2： 
//
// 
//输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//输出："a a b c"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写字母组成。 
// 1 <= sentence.length <= 10^6 
// sentence 仅由小写字母和空格组成。 
// sentence 中单词的总量在范围 [1, 1000] 内。 
// sentence 中每个单词的长度在范围 [1, 1000] 内。 
// sentence 中单词之间由一个空格隔开。 
// sentence 没有前导或尾随空格。 
// 
//
// 
// Related Topics 字典树 数组 哈希表 字符串 👍 218 👎 0


package problems.leetcode.editor.cn;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Id：&emsp;&emsp;648
 * <p>
 * Name：单词替换
 *
 * @author Yuri
 * @since 2022-07-07 17:31:43
 */
public class ReplaceWords {
    public static void main(String[] args) {
        Solution solution = new ReplaceWords().new Solution();
        String s = solution.replaceWords(Lists.newArrayList("sa", "fsd"), "sav da");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
    class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            Set<String> hash = new HashSet<>(dictionary);
            String[] strings = sentence.split(" ");
            for (int i = 0; i < strings.length; i++) {
                String string = strings[i];
                for (int j = 0; j < string.length(); j++) {
                    String substring = string.substring(0, j);
                    if (hash.contains(substring)) {
                        strings[i] = substring;
                        break;
                    }
                }
            }
            return String.join(" ", strings);
        }
    }
*/

/*
    // 字典树 二维数组（可以把所用外部成员命名为Static，时间缩短十倍。OJ能过，但本地报错---内部类不能使用静态声明）
    class Solution {
        int N = 100000, M = 26;
        int[][] tr = new int[N][M];
        boolean[] isEnd = new boolean[N * M];
        int idx;

        void add(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (tr[p][u] == 0) tr[p][u] = ++idx;
                p = tr[p][u];
            }
            isEnd[p] = true;
        }

        String query(String s) {
            for (int i = 0, p = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (tr[p][u] == 0) break;
                if (isEnd[tr[p][u]]) return s.substring(0, i + 1);
                p = tr[p][u];
            }
            return s;
        }

        public String replaceWords(List<String> ds, String s) {
            for (String d : ds) add(d);
            StringBuilder sb = new StringBuilder();
            for (String str : s.split(" ")) sb.append(query(str)).append(" ");
            return sb.substring(0, sb.length() - 1);
        }
    }
*/

    // 字典树 动态线段树
    class Solution {
        class Node {
            boolean isEnd;
            Node[] nodes = new Node[26];
        }

        Node root = new Node();

        void add(String str) {
            Node p = root;
            for (int i = 0; i < str.length(); i++) {
                int u = str.charAt(i) - 'a';
                if (p.nodes[u] == null) p.nodes[u] = new Node();
                p = p.nodes[u];
            }
            p.isEnd = true;
        }

        String query(String str) {
            Node p = root;
            for (int i = 0; i < str.length(); i++) {
                int u = str.charAt(i) - 'a';
                if (p.nodes[u] == null) break; // 字典树中未记录，则表示未匹配上，退出匹配，返回原字符串
                if (p.nodes[u].isEnd) return str.substring(0, i + 1); // 返回0~i的字符串（不包含i+1）
                p = p.nodes[u];
            }
            return str;
        }

        public String replaceWords(List<String> ds, String s) {
            for (String d : ds) add(d);
            StringBuilder sb = new StringBuilder();
            for (String str : s.split(" ")) sb.append(query(str)).append(" ");
            return sb.substring(0, sb.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}