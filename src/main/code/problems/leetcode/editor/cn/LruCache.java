// Design a data structure that follows the constraints of a Least Recently Used
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise 
// return -1.
// void put(int key, int value) Update the value of the key if the key exists. 
// Otherwise, add the key-value pair to the cache. If the number of keys exceeds
// the capacity from this operation, evict the least recently used key.
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
// Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10⁴ 
// 0 <= value <= 10⁵ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// 👍 2984 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;146
 * <p>
 * Name：LRU Cache
 *
 * @author Yuri
 * @since 2023-10-23 17:30:50
 */

public class LruCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LruCache().new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        private final class Node {

            private final int key;
            private int value;
            private Node pre, next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer, Node> map = new HashMap<>();
        Node dummy;
        int capacity;

        public LRUCache(int capacity) {
            // 只需一个哨兵让其前后相连成环状结构
            dummy = new Node(-1, -1);
            dummy.pre = dummy;
            dummy.next = dummy;
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                remove(node); // 抽出
                pushFront(node); // 放在上面
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value; // 修改值
                remove(node); // 抽出
            } else {
                node = new Node(key, value); // 生成新节点
                map.put(key, node);
                if (capacity < map.size()){
                    // 删除多的最后一个节点
                    map.remove(dummy.pre.key);
                    remove(dummy.pre);
                }
            }
            pushFront(node); // 放最上面
        }

        // 放一个
        private void pushFront(Node node) {
            node.next = dummy.next;
            node.pre = dummy;
            dummy.next.pre = node;
            dummy.next = node;
        }

        // 抽一个
        private void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// leetcode submit region end(Prohibit modification and deletion)

}