//Design a HashSet without using any built-in hash table libraries. 
//
// Implement MyHashSet class: 
//
// 
// void add(key) Inserts the value key into the HashSet. 
// bool contains(key) Returns whether the value key exists in the HashSet or 
//not. 
// void remove(key) Removes the value key in the HashSet. If key does not exist 
//in the HashSet, do nothing. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", 
//"remove", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//Output
//[null, null, null, true, false, null, true, null, false]
//
//Explanation
//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // return True
//myHashSet.contains(3); // return False, (not found)
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // return True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // return False, (already removed) 
//
// 
// Constraints: 
//
// 
// 0 <= key <= 10⁶ 
// At most 10⁴ calls will be made to add, remove, and contains. 
// 
//
// 👍 348 👎 0

package problems.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;705
 * <p>
 * Name：Design HashSet
 *
 * @author Yuri
 * @since 2024-04-15 18:36:04
 */

public class DesignHashset {
    public static void main(String[] args) {
        MyHashSet myHashSet = new DesignHashset().new MyHashSet();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 链地址法，手搓哈希表
     */
    class MyHashSet {
        private final static int n = 798;

        LinkedList[] data = new LinkedList[n];
        public MyHashSet() {
            for (int i = 0; i < n; i++) {
                data[i] = new LinkedList();
            }
        }

        public void add(int key) {
            LinkedList datum = data[key % n];
            for (Integer integer : (Iterable<Integer>) datum) {
                if (integer == key) return;
            }
            datum.add(key);
        }

        public void remove(int key) {
            LinkedList datum = data[key % n];
            datum.remove((Object) key);
        }

        public boolean contains(int key) {
            LinkedList datum = data[key % n];
            for (Integer integer : (Iterable<Integer>) datum) {
                if (integer == key) return true;
            }
            return false;
        }
    }

    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}