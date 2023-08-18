package problems.leetcode.editor.cn;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;2785 <br/>
 * Name：Sort Vowels in a String <br/>
 *
 * @author Yuri
 * @since 2023-07-25 23:47:25
 */

public class SortVowelsInAString {
    public static void main(String[] args) {
        Solution solution = new SortVowelsInAString().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 也可以用位运算标记元音字母
        public String sortVowels(String s) {
            StringBuilder sb = new StringBuilder();
            Set<Integer> hash = Stream.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').map(o -> (int) o).collect(Collectors.toSet());
            int[] ints = s.codePoints().filter(hash::contains).sorted().toArray();
            int k = 0;
            for (Character c : s.toCharArray()) {
                if (hash.contains((int) c)) sb.append((char) ints[k++]);
                else sb.append(c);
            }
            return sb.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
