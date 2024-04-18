package algorithm;

import java.util.LinkedList;

/**
 * 链地址法
 * <p>
 * 一种常用的解决hash冲突的方法，用于手搓hash表
 * <p>
 * 思路：选取一个合适的质数n，对应新建n个链表，以key%k将对应的key放入对应链表中
 *
 * @author Yuri
 * @since 2024/4/17 18:22
 */


public class ChainAddress {

    /**
     * 手搓HashSet
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
     * 手搓hashMap
     */
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
                if (pair.key == key) {
                    pair.val = value;
                    return;
                }
            }
            datum.add(new Pair(key, value));
        }

        public int get(int key) {
            LinkedList datum = data[key % n];
            for (Pair pair : (Iterable<Pair>) datum) {
                if (pair.key == key) {
                    return pair.val;
                }
            }
            return -1;
        }

        public void remove(int key) {
            LinkedList datum = data[key % n];
            for (Pair pair : (Iterable<Pair>) datum) {
                if (pair.key == key) {
                    datum.remove(pair);
                    break;
                }
            }
        }
    }
}
