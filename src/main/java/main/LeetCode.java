package main;

import java.util.*;

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

class Id1738{

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
    public List recursion(TreeNode root, int parentNum, int num, int degree) {
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

    public boolean isCousins(TreeNode root, int x, int y) {
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


