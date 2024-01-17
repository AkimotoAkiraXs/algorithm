// Design and implement a data structure for a Least Frequently Used (LFU) cache.
// 
//
// Implement the LFUCache class: 
//
// 
// LFUCache(int capacity) Initializes the object with the capacity of the data 
// structure.
// int get(int key) Gets the value of the key if the key exists in the cache. 
// Otherwise, returns -1.
// void put(int key, int value) Update the value of the key if present, or 
// inserts the key if not already present. When the cache reaches its capacity, it
// should invalidate and remove the least frequently used key before inserting a new
// item. For this problem, when there is a tie (i.e., two or more keys with the same
// frequency), the least recently used key would be invalidated.
// 
//
// To determine the least frequently used key, a use counter is maintained for 
// each key in the cache. The key with the smallest use counter is the least
// frequently used key.
//
// When a key is first inserted into the cache, its use counter is set to 1 (
// due to the put operation). The use counter for a key in the cache is incremented
// either a get or put operation is called on it.
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
// Input
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", 
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
// Output
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
// Explanation
//// cnt(x) = the use counter for key x
//// cache=[] will show the last used order for tiebreakers (leftmost element 
// is  most recent)
// LFUCache lfu = new LFUCache(2);
// lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
// lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
// lfu.get(1);      // return 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
// lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest,
// invalidate 2.
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
// lfu.get(2);      // return -1 (not found)
// lfu.get(3);      // return 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
// lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1
//.
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
// lfu.get(1);      // return -1 (not found)
// lfu.get(3);      // return 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
// lfu.get(4);      // return 4
//                 // cache=[4,3], cnt(4)=2, cnt(3)=3
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 10⁴ 
// 0 <= key <= 10⁵ 
// 0 <= value <= 10⁹ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// 
// 
//
// 👍 809 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;460
 * <p>
 * Name：LFU Cache
 *
 * @author Yuri
 * @since 2024-01-16 18:04:10
 */

public class LfuCache {

    public static void main(String[] args) {

        LFUCache lfuCache = new LfuCache().new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.get(1);
        lfuCache.put(3, 3);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.put(4, 4);
        lfuCache.get(1);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {

        private class Node {

            protected Node(int key, int val, int floor) {
                this.key = key;
                this.val = val;
                this.floor = floor;
            }

            Node pre;
            Node next;
            int key;
            int val;
            int floor;
        }

        int capacity;
        int n;
        int min;
        Map<Integer, Node> fmap;
        Map<Integer, Node> map;

        public LFUCache(int capacity) {
            n = 0;
            this.capacity = capacity;
            fmap = new HashMap<>();
            map = new HashMap<>();
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            upgrade(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {
                if (++n > capacity) remove();
                node = new Node(key, value, 0);
                map.put(key, node);
                insert(node);
                min = 0;
            } else {
                node.val = value;
                upgrade(node);
            }
        }

        private void remove() {
            while (true) {
                Node root = fmap.get(min);
                if (root.pre == root) {
                    min++;
                    continue;
                }
                Node node = root.pre;
                root.pre = node.pre;
                root.pre.next = root;
                map.remove(node.key);
                break;
            }
            n--;
        }

        private void upgrade(Node node) {
            node.floor++;
            extract(node);
            insert(node);
        }

        private void extract(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void insert(Node node) {
            Node root = fmap.get(node.floor);
            if (root == null) {
                root = new Node(-1, -1, node.floor);
                root.next = root;
                root.pre = root;
                fmap.put(node.floor, root);
            }
            node.next = root.next;
            node.pre = root;
            root.next.pre = node;
            root.next = node;
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// leetcode submit region end(Prohibit modification and deletion)

}