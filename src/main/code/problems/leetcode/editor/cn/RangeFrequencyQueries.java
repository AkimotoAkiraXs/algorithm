// Design a data structure to find the frequency of a given value in a given
// subarray.
//
// The frequency of a value in a subarray is the number of occurrences of that 
// value in the subarray.
//
// Implement the RangeFreqQuery class: 
//
// 
// RangeFreqQuery(int[] arr) Constructs an instance of the class with the given 
// 0-indexed integer array arr.
// int query(int left, int right, int value) Returns the frequency of value in 
// the subarray arr[left...right].
// 
//
// A subarray is a contiguous sequence of elements within an array. arr[left...
// right] denotes the subarray that contains the elements of nums between indices
// left and right (inclusive).
//
// 
// Example 1: 
//
// 
// Input
//["RangeFreqQuery", "query", "query"]
//[[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
// Output
//[null, 1, 2]
//
// Explanation
// RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34,
// 33, 22, 12, 34, 56]);
// rangeFreqQuery.query(1, 2, 4); // return 1. The value 4 occurs 1 time in the
// subarray [33, 4]
// rangeFreqQuery.query(0, 11, 33); // return 2. The value 33 occurs 2 times in
// the whole array.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁵ 
// 1 <= arr[i], value <= 10⁴ 
// 0 <= left <= right < arr.length 
// At most 10⁵ calls will be made to query 
// 
//
// 👍 62 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;2080
 * <p>
 * Name：Range Frequency Queries
 *
 * @author Yuri
 * @since 2024-08-14 17:41:26
 */

public class RangeFrequencyQueries {

    public static void main(String[] args) {
        RangeFreqQuery rangeFreqQuery = new RangeFrequencyQueries().new RangeFreqQuery(
            new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        rangeFreqQuery.query(1, 2, 4);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 需要转变一下思维，不要那么死板
     */
    class RangeFreqQuery {

        Map<Integer, List<Integer>> map = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                if (!map.containsKey(num)) map.put(num, new ArrayList<>());
                map.get(num).add(i);
            }
        }

        public int query(int left, int right, int value) {
            if (!map.containsKey(value)) return 0;
            List<Integer> nums = map.get(value);
            return dichotomy(nums, right + 1) - dichotomy(nums, left);
        }

        private int dichotomy(List<Integer> arr, int t) {
            int l = 0, r = arr.size();
            while (l < r) {
                int mid = l + r >> 1;
                if (arr.get(mid) < t) l = mid + 1;
                else r = mid;
            }
            return l;
        }
    }

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
// leetcode submit region end(Prohibit modification and deletion)

}