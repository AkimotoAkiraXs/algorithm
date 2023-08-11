package leetcode.editor.cn;

import cn.hutool.core.lang.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;1090 <br/>
 * Name：Largest Values From Labels <br/>
 *
 * @author Yuri
 * @since 2023-05-23 22:31:01
 */

public class LargestValuesFromLabels {
    public static void main(String[] args) {
        Solution solution = new LargestValuesFromLabels().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 贪心：排序+哈希表
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            int n = values.length;
            List<Pair<Integer, Integer>> pairs = new ArrayList<>();
            for (int i = 0; i < n; i++) pairs.add(new Pair<>(values[i], labels[i]));
            pairs = pairs.stream().sorted(((o1, o2) -> o2.getKey() - o1.getKey())).collect(Collectors.toList());
            Map<Integer, Integer> countMap = new HashMap<>();
            int res = 0, cnt = 0;
            for (int i = 0; i < n && cnt < numWanted; i++) {
                Pair<Integer, Integer> pair = pairs.get(i);
                Integer key = pair.getKey();
                Integer value = pair.getValue();
                Integer num = countMap.getOrDefault(value, 0);
                if (num < useLimit) {
                    cnt++;
                    res += key;
                    countMap.put(value, num + 1);
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
