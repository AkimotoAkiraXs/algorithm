//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 351 👎 0


/*
 * Id：692
 * Name：前K个高频单词
 * Date：2021-06-22 15:08:58
 */
package problems.leetcode.editor.cn;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //Map排序
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String word :
                    words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return o2.getValue() - o1.getValue();
                }
            });
            List<String> res = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                res.add(list.get(i).getKey());
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 