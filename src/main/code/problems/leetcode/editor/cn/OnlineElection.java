// You are given two integer arrays persons and times. In an election, the iᵗʰ
// vote was cast for persons[i] at time times[i].
//
// For each query at a time t, find the person that was leading the election at 
// time t. Votes cast at time t will count towards our query. In the case of a tie,
// the most recent vote (among tied candidates) wins. 
//
// Implement the TopVotedCandidate class: 
//
// 
// TopVotedCandidate(int[] persons, int[] times) Initializes the object with 
// the persons and times arrays.
// int q(int t) Returns the number of the person that was leading the election 
// at time t according to the mentioned rules.
// 
//
// 
// Example 1: 
//
// 
// Input
//["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
//[[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [
// 24], [8]]
// Output
//[null, 0, 1, 1, 0, 0, 1]
//
// Explanation
// TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1,
// 0], [0, 5, 10, 15, 20, 25, 30]);
// topVotedCandidate.q(3); // return 0, At time 3, the votes are [0], and 0 is
// leading.
// topVotedCandidate.q(12); // return 1, At time 12, the votes are [0,1,1], and 1
// is leading.
// topVotedCandidate.q(25); // return 1, At time 25, the votes are [0,1,1,0,0,1],
// and 1 is leading (as ties go to the most recent vote.)
// topVotedCandidate.q(15); // return 0
// topVotedCandidate.q(24); // return 0
// topVotedCandidate.q(8); // return 1
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= persons.length <= 5000 
// times.length == persons.length 
// 0 <= persons[i] < persons.length 
// 0 <= times[i] <= 10⁹ 
// times is sorted in a strictly increasing order. 
// times[0] <= t <= 10⁹ 
// At most 10⁴ calls will be made to q. 
// 
//
// 👍 165 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;911
 * <p>
 * Name：Online Election
 *
 * @author Yuri
 * @since 2024-08-19 11:54:04
 */

public class OnlineElection {

    public static void main(String[] args) {

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class TopVotedCandidate {


        /**
         * 按时间顺序给人做排名，只记录可能发生改变时的时间和人，然后q中做二分查找。
         */
        List<int[]> ts = new ArrayList<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            int n = persons.length;
            int[] count = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                int p = persons[i];
                count[p]++;
                if (max <= count[p]) {
                    max = count[p];
                    ts.add(new int[]{times[i], p});
                }
            }
        }

        public int q(int t) {
            int l = 0, r = ts.size();
            while (l < r) {
                int mid = l + r >> 1;
                if (ts.get(mid)[0] <= t) l = mid + 1;
                else r = mid;
            }
            return ts.get(l - 1)[1];
        }
    }

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
// leetcode submit region end(Prohibit modification and deletion)

}