// In a warehouse, there is a row of barcodes, where the iᵗʰ barcode is barcodes[
// i].
//
// Rearrange the barcodes so that no two adjacent barcodes are equal. You may 
// return any answer, and it is guaranteed an answer exists.
//
// 
// Example 1: 
// Input: barcodes = [1,1,1,2,2,2]
// Output: [2,1,2,1,2,1]
// 
// Example 2: 
// Input: barcodes = [1,1,1,1,2,2,3,3]
// Output: [1,3,1,3,1,2,1,2]
// 
// 
// Constraints: 
//
// 
// 1 <= barcodes.length <= 10000 
// 1 <= barcodes[i] <= 10000 
// 
//
// 👍 192 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;1054
 * <p>
 * Name：Distant Barcodes
 *
 * @author Yuri
 * @since 2024-05-21 18:13:36
 */

public class DistantBarcodes {

    public static void main(String[] args) {
        Solution solution = new DistantBarcodes().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 计数+排序+最大堆，可以手动维护以节省掉最大堆的时间（此处忽略）
        public int[] rearrangeBarcodes(int[] barcodes) {
            Map<Integer, Long> counting = Arrays.stream(barcodes).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            TreeSet<Integer> q = new TreeSet<>((a, b) -> {
                int dis = (int) (counting.get(b) - counting.get(a));
                if (dis == 0) return b - a;
                return dis;
            });
            q.addAll(counting.keySet());
            for (int i = 0; i < barcodes.length; i++) {
                Integer first = q.pollFirst();
                if (i > 0 && barcodes[i - 1] == first) {
                    Integer second = q.pollFirst();
                    q.add(first);
                    first = second;
                }
                barcodes[i] = first;
                counting.merge(first, -1L, Long::sum);
                q.add(first);
            }
            return barcodes;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}