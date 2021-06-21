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
//        int[] candiesCount = new int[]{7, 4, 5, 3, 8};
//        int[][] queries = new int[][]{{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}};
//        Id1744 id1744 = new Id1744();
//        id1744.canEat(candiesCount, queries);



    }
}

class Id483 {



    //二分法
    public long pow(long mid, int j) {
        long res = mid;
        for (int i = 1; i < j; i++) {
            if (Long.MAX_VALUE / mid < res) { //防止超出long上限
                return -1;
            }
            res *= mid;
        }
        return res;
    }

    public long calculate(long mid, int i) {
        long sum = 1;
        for (int j = i - 1; j > 0; j--) {
            long p ;
            if ((p = pow(mid, j)) == -1) {
                return -1;
            }
            sum += p;
        }
        return sum;
    }

    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n), mid;
        for (int i = 63; i >= 2; i--) {
            long l = num, r = 2;
            while (r < l) {
                mid = l + r >>> 1;
                long sum = calculate(mid, i);
                if (sum == num) {
                    return String.valueOf(mid);
                } else if (sum > num || sum == -1) {
                    l = mid;
                } else {
                    r = mid + 1;
                }
            }
        }
        return String.valueOf(0);
    }
}

class Id877 {
    //博弈论 先手必然可以选择奇偶序列
    public boolean stoneGame(int[] piles) {
        return true;
    }

}

class Id374 {
    //guess为系统内置函数
    int guess(int num) {
        int pick = 1702766719;
        return Integer.compare(pick, num);
    }

    //二分法 log(n)
    public int guessNumber(int n) {
        int mid = 0, ans = 1, a = 0, b = n;
        while (ans != 0) {
            mid = a + b >>> 1;
            ans = guess(mid);
            if (ans == 1) {
                a = mid + 1;
            } else if (ans == -1) {
                b = mid - 1;
            }
        }
        return mid;
    }
}

class Id852 {
    //枚举 n
    public int peakIndexInMountainArray(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return list.indexOf(Collections.max(list));
    }
    //二分法 log(n)
}

class Id1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        boolean[] res = new boolean[queries.length];
        long[] sum = new long[n + 1];
        sum[0] = 0; //在吃第几类前，需要吃的糖数（前面几类总和）
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + candiesCount[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            //ft最爱的糖 fd最爱的天数 dc一天最多吃几个
            int ft = queries[i][0], fd = queries[i][1], dc = queries[i][2];
            long x1 = fd + 1;
            long y1 = (long) dc * fd + dc;
            long x2 = sum[ft] + 1;
            long y2 = sum[ft + 1];
            res[i] = y2 > x1 && y1 > x2;
        }
        return res;
    }
}

class Id461 {
    /**
     * 异或运算
     */
    public int hammingDistance(int x, int y) {
        int n = x ^ y, res = 0;
        String s = Integer.toBinaryString(n);
        int k;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }

    //官方 内置位计数功能
    public int hammingDistanceOfficially(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    //官方2 开始想出来没实现的思路 移位实现位计数
    public int hammingDistanceOfficially2(int x, int y) {
        int z = x ^ y;
        int sum = 0;
        while (z != 0) {
            sum += z & 1;
            z = z >> 1;
        }
        return sum;
    }

    //官方3 Brian Kernighan算法 每次s &= s - 1 就删除了s二进制最右边的1
    public int hammingDistanceOfficially3(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }
}

class Id1190 {
    /**
     * 字符串处理
     * 模拟
     */
    //官方题解 预处理括号
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] num = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0, j; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                j = stack.pop();
                num[i] = j;
                num[j] = i;
            }
        }
        int index = 0, k = 1;
        StringBuilder sb = new StringBuilder();
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = num[index];
                k = -k;
            } else {
                sb.append(s.charAt(index));
            }
            index += k;
        }
        return sb.toString();
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
                    for (int k = i; k > j; k--) {
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


