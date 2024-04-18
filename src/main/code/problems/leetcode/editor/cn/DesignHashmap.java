//Design a HashMap without using any built-in hash table libraries. 
//
// Implement the MyHashMap class: 
//
// 
// MyHashMap() initializes the object with an empty map. 
// void put(int key, int value) inserts a (key, value) pair into the HashMap. 
//If the key already exists in the map, update the corresponding value. 
// int get(int key) returns the value to which the specified key is mapped, or -
//1 if this map contains no mapping for the key. 
// void remove(key) removes the key and its corresponding value if the map 
//contains the mapping for the key. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//Output
//[null, null, null, 1, -1, null, 1, null, -1]
//
//Explanation
//MyHashMap myHashMap = new MyHashMap();
//myHashMap.put(1, 1); // The map is now [[1,1]]
//myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
//myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
//myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2
//,2]]
//myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the 
//existing value)
//myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
//myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
//myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
// 
//
// 
// Constraints: 
//
// 
// 0 <= key, value <= 10⁶ 
// At most 10⁴ calls will be made to put, get, and remove. 
// 
//
// 👍 416 👎 0

package problems.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;706
 * <p>
 * Name：Design HashMap
 *
 * @author Yuri
 * @since 2024-04-15 18:21:15
 */

public class DesignHashmap {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {

        class Pair {
            int val;
            int key;

            public Pair(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private final static int n = 798;
        LinkedList[] data = new LinkedList[n];

        public MyHashMap() {
            for (int i = 0; i < n; i++) {
                data[i] = new LinkedList();
            }
        }

        public void put(int key, int value) {
            LinkedList datum = data[key % n];
            for (Pair pair : (Iterable<Pair>) datum) {
                if (pair.key == key){
                    pair.val = value;
                    return;
                }
            }
            datum.add(new Pair(key, value));
        }

        public int get(int key) {
            LinkedList datum = data[key % n];
            for (Pair pair : (Iterable<Pair>) datum) {
                if (pair.key == key){
                    return pair.val;
                }
            }
            return -1;
        }

        public void remove(int key) {
            LinkedList datum = data[key % n];
            for (Pair pair : (Iterable<Pair>) datum) {
                if (pair.key == key){
                    datum.remove(pair);
                    break;
                }
            }
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}