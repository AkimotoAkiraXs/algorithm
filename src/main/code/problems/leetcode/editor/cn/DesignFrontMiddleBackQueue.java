// Design a queue that supports push and pop operations in the front, middle,
// and back.
//
// Implement the FrontMiddleBack class: 
//
// 
// FrontMiddleBack() Initializes the queue. 
// void pushFront(int val) Adds val to the front of the queue. 
// void pushMiddle(int val) Adds val to the middle of the queue. 
// void pushBack(int val) Adds val to the back of the queue. 
// int popFront() Removes the front element of the queue and returns it. If the 
// queue is empty, return -1.
// int popMiddle() Removes the middle element of the queue and returns it. If 
// the queue is empty, return -1.
// int popBack() Removes the back element of the queue and returns it. If the 
// queue is empty, return -1.
// 
//
// Notice that when there are two middle position choices, the operation is 
// performed on the frontmost middle position choice. For example:
//
// 
// Pushing 6 into the middle of [1, 2, 3, 4, 5] results in [1, 2, 6, 3, 4, 5]. 
// Popping the middle from [1, 2, 3, 4, 5, 6] returns 3 and results in [1, 2, 4,
// 5, 6]. 
// 
//
// 
// Example 1: 
//
// 
// Input:
//["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", 
//"popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
//[[], [1], [2], [3], [4], [], [], [], [], []]
// Output:
//[null, null, null, null, null, 1, 3, 4, 2, -1]
//
// Explanation:
// FrontMiddleBackQueue q = new FrontMiddleBackQueue();
// q.pushFront(1);   // [1]
// q.pushBack(2);    // [1, 2]
// q.pushMiddle(3);  // [1, 3, 2]
// q.pushMiddle(4);  // [1, 4, 3, 2]
// q.popFront();     // return 1 -> [4, 3, 2]
// q.popMiddle();    // return 3 -> [4, 2]
// q.popMiddle();    // return 4 -> [2]
// q.popBack();      // return 2 -> []
// q.popFront();     // return -1 -> [] (The queue is empty)
// 
//
// 
// Constraints: 
//
// 
// 1 <= val <= 10⁹ 
// At most 1000 calls will be made to pushFront, pushMiddle, pushBack, popFront,
// popMiddle, and popBack. 
// 
//
// 👍 78 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Id：&emsp;&emsp;1670
 * <p>
 * Name：Design Front Middle Back Queue
 *
 * @author Yuri
 * @since 2023-11-28 18:48:23
 */

public class DesignFrontMiddleBackQueue {

    public static void main(String[] args) {
        FrontMiddleBackQueue frontMiddleBackQueue = new DesignFrontMiddleBackQueue().new FrontMiddleBackQueue();
        frontMiddleBackQueue.pushMiddle(371447);
        frontMiddleBackQueue.popMiddle();
        frontMiddleBackQueue.popMiddle();
        frontMiddleBackQueue.pushFront(154898);
        frontMiddleBackQueue.popMiddle();
        frontMiddleBackQueue.pushMiddle(498468);
        frontMiddleBackQueue.pushMiddle(725851);
        frontMiddleBackQueue.pushBack(20315);
        frontMiddleBackQueue.pushFront(384279);
        frontMiddleBackQueue.pushMiddle(816477);
        frontMiddleBackQueue.popFront();
        frontMiddleBackQueue.pushMiddle(934190);
        frontMiddleBackQueue.popMiddle();
        frontMiddleBackQueue.pushFront(255188);
        frontMiddleBackQueue.pushBack(186484);
        frontMiddleBackQueue.popFront();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class FrontMiddleBackQueue {

        Deque<Integer> front = new ArrayDeque<>();
        Deque<Integer> back = new ArrayDeque<>();

        public FrontMiddleBackQueue() {

        }

        public void pushFront(int val) {
            front.addFirst(val);
            if (front.size() > back.size()) back.addFirst(front.removeLast());
        }

        public void pushMiddle(int val) {
            if (back.size() > front.size()) front.addLast(val);
            else back.addFirst(val);
        }

        public void pushBack(int val) {
            if (back.size() > front.size()) front.addLast(back.removeFirst());
            back.addLast(val);
        }

        public int popFront() {
            if (front.isEmpty() && back.isEmpty()) return -1;
            if (front.size() < back.size()) front.addLast(back.removeFirst());
            return front.removeFirst();
        }

        public int popMiddle() {
            if (front.isEmpty() && back.isEmpty()) return -1;
            if (back.size() > front.size()) return back.removeFirst();
            return front.removeLast();
        }

        public int popBack() {
            if (back.isEmpty()) return -1;
            if (front.size() > back.size() - 1) back.addFirst(front.removeLast());
            return back.removeLast();
        }
    }

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
// leetcode submit region end(Prohibit modification and deletion)

}