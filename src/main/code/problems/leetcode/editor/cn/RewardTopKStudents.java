// You are given two string arrays positive_feedback and negative_feedback,
// containing the words denoting positive and negative feedback, respectively. Note
// that no word is both positive and negative.
//
// Initially every student has 0 points. Each positive word in a feedback 
// report increases the points of a student by 3, whereas each negative word decreases
// the points by 1.
//
// You are given n feedback reports, represented by a 0-indexed string array 
// report and a 0-indexed integer array student_id, where student_id[i] represents
// the ID of the student who has received the feedback report report[i]. The ID of
// each student is unique.
//
// Given an integer k, return the top k students after ranking them in non-
// increasing order by their points. In case more than one student has the same points,
// the one with the lower ID ranks higher.
//
// 
// Example 1: 
//
// 
// Input: positive_feedback = ["smart","brilliant","studious"], negative_
// feedback = ["not"], report = ["this student is studious","the student is smart"],
// student_id = [1,2], k = 2
// Output: [1,2]
// Explanation:
// Both the students have 1 positive feedback and 3 points but since student 1
// has a lower ID he ranks higher.
// 
//
// Example 2: 
//
// 
// Input: positive_feedback = ["smart","brilliant","studious"], negative_
// feedback = ["not"], report = ["this student is not studious","the student is smart"],
// student_id = [1,2], k = 2
// Output: [2,1]
// Explanation:
//- The student with ID 1 has 1 positive feedback and 1 negative feedback, so 
// he has 3-1=2 points.
//- The student with ID 2 has 1 positive feedback, so he has 3 points. 
// Since student 2 has more points, [2,1] is returned.
// 
//
// 
// Constraints: 
//
// 
// 1 <= positive_feedback.length, negative_feedback.length <= 10⁴ 
// 1 <= positive_feedback[i].length, negative_feedback[j].length <= 100 
// Both positive_feedback[i] and negative_feedback[j] consists of lowercase 
// English letters.
// No word is present in both positive_feedback and negative_feedback. 
// n == report.length == student_id.length 
// 1 <= n <= 10⁴ 
// report[i] consists of lowercase English letters and spaces ' '. 
// There is a single space between consecutive words of report[i]. 
// 1 <= report[i].length <= 100 
// 1 <= student_id[i] <= 10⁹ 
// All the values of student_id[i] are unique. 
// 1 <= k <= n 
// 
//
// 👍 38 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Id：&emsp;&emsp;2512
 * <p>
 * Name：Reward Top K Students
 *
 * @author Yuri
 * @since 2023-10-11 15:19:28
 */

public class RewardTopKStudents {

    public static void main(String[] args) {
        Solution solution = new RewardTopKStudents().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report,
            int[] student_id, int k) {
            Set<String> pf = new HashSet<>(List.of(positive_feedback));
            Set<String> nf = new HashSet<>(List.of(negative_feedback));
            Integer[] scores = Arrays.stream(report).map(rt -> {
                int score = 0;
                for (String s : rt.split(" ")) {
                    if (pf.contains(s)) score += 3;
                    else if (nf.contains(s)) score -= 1;
                }
                return score;
            }).toArray(Integer[]::new);
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
                if (Objects.equals(scores[o1], scores[o2])) return student_id[o1] - student_id[o2];
                return scores[o2] - scores[o1];
            });
            for (int i = 0; i < student_id.length; i++) queue.add(i);
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < k; i++) res.add(student_id[queue.remove()]);
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}