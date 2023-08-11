package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * Id：&emsp;&emsp;6472
 * <p>
 * Name：查询后矩阵的和
 *
 * @author Yuri
 * @since 2023/6/4 19:23
 */

public class matrixSumQueries {

    public static void main(String[] args) {

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long matrixSumQueries(int n, int[][] queries) {
            Set<Integer> hashR = new HashSet<>();
            Set<Integer> hashC = new HashSet<>();
            long sum = 0;
            for (int i = queries.length - 1; i >= 0 && hashC.size() < n && hashR.size() < n; i--) {
                int[] query = queries[i];
                boolean flag = query[0] == 0;
                int index = query[1], val = query[2];
                if (flag && hashR.add(index)) sum += (long) (n - hashC.size()) * val;
                else if (!flag && hashC.add(index)) sum += (long) (n - hashR.size()) * val;
            }
            return sum;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
