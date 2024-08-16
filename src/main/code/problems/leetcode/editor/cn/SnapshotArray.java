// Implement a SnapshotArray that supports the following interface:
//
// 
// SnapshotArray(int length) initializes an array-like data structure with the 
// given length. Initially, each element equals 0.
// void set(index, val) sets the element at the given index to be equal to val. 
//
// int snap() takes a snapshot of the array and returns the snap_id: the total 
// number of times we called snap() minus 1.
// int get(index, snap_id) returns the value at the given index, at the time we 
// took the snapshot with the given snap_id
// 
//
// 
// Example 1: 
//
// 
// Input: ["SnapshotArray","set","snap","set","get"]
//[[3],[0,5],[],[0,6],[0,0]]
// Output: [null,null,0,null,5]
// Explanation:
// SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
// snapshotArr.set(0,5);  // Set array[0] = 5
// snapshotArr.snap();  // Take a snapshot, return snap_id = 0
// snapshotArr.set(0,6);
// snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
// 
//
// 
// Constraints: 
//
// 
// 1 <= length <= 5 * 10⁴ 
// 0 <= index < length 
// 0 <= val <= 10⁹ 
// 0 <= snap_id < (the total number of times we call snap()) 
// At most 5 * 10⁴ calls will be made to set, snap, and get. 
// 
//
// 👍 176 👎 0

package problems.leetcode.editor.cn;

import cn.hutool.core.lang.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;1146
 * <p>
 * Name：Snapshot Array
 *
 * @author Yuri
 * @since 2024-08-15 16:55:38
 */
// leetcode submit region begin(Prohibit modification and deletion)

public class SnapshotArray {

    Pair<List<Integer>, List<Integer>>[] data;
    int length;
    int snap = 0;

    public SnapshotArray(int length) {
        this.data = new Pair[length];
        this.length = length;
    }

    public void set(int index, int val) {
        if (data[index] == null) {
            data[index] = new Pair<>(
                Stream.of(0).collect(Collectors.toList()),
                Stream.of(0).collect(Collectors.toList()));
        }
        data[index].getKey().add(val);
        data[index].getValue().add(snap);
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snap_id) {
        Pair<List<Integer>, List<Integer>> pair = data[index];
        if (pair == null) return 0;
        int p = dichotomy(pair.getValue(), snap_id) - 1;
        return pair.getKey().get(p);
    }

    private int dichotomy(List<Integer> nums, int t) {
        int l = 0, r = nums.size();
        while (l < r) {
            int mid = l + r >> 1;
            if (nums.get(mid) <= t) l = mid + 1;
            else r = mid;
        }
        return l;
    }

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

}
// leetcode submit region end(Prohibit modification and deletion)
