package main;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Yuri
 * @Date 2021/5/14 14:59
 * @Version 1.0
 * @Description:
 */

public class LeetCode {
    public static void main(String[] args) {

    }
}


class Id664 {
    /**
     * 简单dp 因为是从头开始 所ary[j][i]表示区间j-i的最小打印数
     */
    public int strangePrinter(String s) {
        int size = s.length();
        int[][] ary = new int[size + 1][size + 1];
        for (int i = 0; i < size; i++) {
            ary[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                int minn = Integer.MAX_VALUE;
                if (s.charAt(i) == s.charAt(j)) {
                    ary[j][i] = ary[j + 1][i];
                } else {
                    for (int k = i; k > j ; k--) {
                        minn = Math.min(minn, ary[j][k - 1] + ary[k][i]);
                    }
                    ary[j][i] = minn;
                }
            }
        }
        return ary[0][size - 1];
    }
}

class Id692 {
    //Map排序
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word :
                words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }
}

class Id1 {
    //暴力
    public int[] twoSum(int[] nums, int target) {
        List<Integer> ary = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < ary.size(); i++) {
            int n = ary.get(i);
            int j = 0;
            j = ary.lastIndexOf(target - n);
            if (j != i && j != -1) {
                return new int[]{j, i};
            }
        }
        return new int[0];
    }

    //哈希表 O(1)
    public int[] twoSumHashTable(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                return new int[]{hash.get(target - nums[i]), i};
            }
            hash.put(nums[i], i);
        }
        return new int[0];
    }
}

class Id1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        List<Integer> num = new ArrayList<>();
        int[][] cmp = new int[1005][1005];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[i - 1].length; j++) {
                cmp[i][j] = cmp[i - 1][j - 1] ^ cmp[i - 1][j] ^ cmp[i][j - 1] ^ matrix[i - 1][j - 1];
                num.add(cmp[i][j]);
            }
        }
        num.sort(Comparator.reverseOrder());
        return num.get(k - 1);
    }
}

class Id55 {

    int[] s;
    int length;

    public boolean jump(int index, boolean res) {
        if (res || s[index] == -1) {
            return res;
        }
        int k = s[index];
        s[index] = -1; //标记位置
        if (k + index + 1 >= length) {
            return true;
        }
        for (int i = 1; i <= k; i++) {
            if (jump(index + i, res)) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        s = nums;
        length = nums.length;
        return jump(0, false);
    }

    //标准题解
    public boolean canJumpAC(int[] nums) {
        int r = 0;  //能跳到最右边的点
        for (int i = 0; i < nums.length; ++i) {
            if (i <= r) {   //如果i小于等于r代表能到达i这个点
                r = Math.max(r, i + nums[i]);   //更新能达到的最右边的点
                if (r >= nums.length - 1) {
                    return true;//如果最右边的点超过了数组大小，返回true
                }
            }
        }
        return false;   //说明达不到最右边，返回false
    }
}

class Id993 {
    public List recursion(TreeNode993 root, int parentNum, int num, int degree) {
        if (num == root.val) {
            List<Integer> res = new ArrayList<>();
            res.add(degree);
            res.add(parentNum);
            return res;
        }
        if (root.left != null) {
            List listLeft = recursion(root.left, root.val, num, degree + 1);
            if (listLeft != null) {
                return listLeft;
            }
        }
        if (root.right != null) {
            List rightList = recursion(root.right, root.val, num, degree + 1);
            if (rightList != null) {
                return rightList;
            }
        }
        return null;
    }

    public boolean isCousins(TreeNode993 root, int x, int y) {
        List listX = recursion(root, root.val, x, 0);
        List listY = recursion(root, root.val, y, 0);
        if (listX.size() == 0 || listY.size() == 0 || listX.get(0) != listY.get(0) || listX.get(1) == listY.get(1)) {
            return false;
        } else {
            return true;
        }
    }
}

class Id1647 {
    public static int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 'a'; i <= 'z'; i++) {
            map.put((char) i, 0);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c) + 1);
        }
        List<Integer> n = new ArrayList<>(map.values());
        for (int i = 0; i < 26; i++) {
            n.remove((Object) 0);
        }
        n.sort((o1, o2) -> o2 - o1);
        int ans = 0;
        for (int i = 1; i < n.size(); i++) {
            while (n.get(i) >= n.get(i - 1) && n.get(i) > 0) {
                ans++;
                n.set(i, n.get(i) - 1);
            }
        }
        return ans;
    }
}

class Id12 {
    public static String intToRoman(int num) {
        String[] rChar = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String ans = "";
        int k = 0;
        while (num != 0) {
            int j = num / n[k];
            num %= n[k];
            for (int i = 0; i < j; i++) {
                ans += rChar[k];
            }
            k++;
        }
        return ans;
    }
}


