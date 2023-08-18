package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Id：&emsp;&emsp;1253 <br/>
 * Name：Reconstruct a 2-Row Binary Matrix <br/>
 *
 * @author Yuri
 * @since 2023-06-29 22:50:48
 */

public class ReconstructA2RowBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new ReconstructA2RowBinaryMatrix().new Solution();
        solution.reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1});
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            int two = (int) Arrays.stream(colsum).filter(o -> o == 2).count();
            for (int num : colsum) {
                if (num > 2) return new ArrayList<>();
                if (num == 2) {
                    a.add(1);
                    b.add(1);
                    two--;
                    upper--;
                    lower--;
                } else if (num == 0) {
                    a.add(0);
                    b.add(0);
                } else if (num == 1) {
                    if (lower > two && lower > 0) {
                        b.add(1);
                        a.add(0);
                        lower--;
                    } else if (upper> two && upper > 0) {
                        a.add(1);
                        b.add(0);
                        upper--;
                    } else return new ArrayList<>();
                }
            }
            if (lower != 0 || upper != 0) return new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(a);
            ans.add(b);
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
