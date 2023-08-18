//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1264 👎 0

package problems.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;49
 * <p>
 * Name：字母异位词分组
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // hash
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();

            // Java8炫技
            // str -> intStream -> sort -> collect by StringBuilder.toString()
            List<List<String>> ans1 = new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> str.chars().sorted().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString())).values());

            // str -> split -> stream -> sort -> join
            List<List<String>> ans2 = new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> Stream.of(str.split("")).sorted().collect(Collectors.joining()))).values());

            // str -> array -> sort -> groupingBy -> collections -> list
            List<List<String>> ans3 = new ArrayList<>(Arrays.stream(strs)
                    .collect(Collectors.groupingBy(str -> {
                        // 返回 str 排序后的结果。
                        // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                        char[] array = str.toCharArray();
                        Arrays.sort(array);
                        return new String(array);
                    })).values());



            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String s1 = Arrays.toString(chars);
                List<String> list = map.getOrDefault(s1, new ArrayList<>());
                list.add(s);
                map.put(s1, list);
            }
            Set<Map.Entry<String, List<String>>> entries = map.entrySet();
            List<List<String>> ans4 = entries.stream().map(Map.Entry::getValue).collect(Collectors.toList());

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}