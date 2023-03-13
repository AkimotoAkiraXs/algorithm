package nowcoder.hj;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * {@link algorithm.ReversePolishNotation 逆波兰表达式}
 *
 * @author Yuri
 * @since 2023/3/13 10:40
 */

public class Hj54 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        System.out.println(rpn(expression));
    }

    public static int priority(char c) {
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        if (c == '(') return 0;
        return -1;
    }

    public static void eval(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.size() < 2 || ops.size() < 1) return;
        Integer a = nums.removeLast();
        Integer b = nums.removeLast();
        Character op = ops.removeLast();
        switch (op) {
            case '+':
                nums.add(a + b);
                break;
            case '-':
                nums.add(b - a);
                break;
            case '*':
                nums.add(a * b);
                break;
            case '/':
                nums.add(b / a);
        }
    }

    public static int rpn(String s) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();

        // 初始化
        s = s.replace(" ", "");
        s = s.replace("(-", "(0-");
        nums.add(0); // 处理负数开头的表达式

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder(String.valueOf(c));
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) sb.append(s.charAt(++i));
                nums.add(Integer.parseInt(sb.toString()));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && priority(ops.peekLast()) >= priority(c)) eval(nums, ops);
                ops.add(c);
            } else if (c == '(') ops.add(c);
            else if (c == ')') {
                while (!ops.isEmpty() && ops.peekLast() != '(') eval(nums, ops);
                ops.pollLast();
            }
        }
        while (!ops.isEmpty()) eval(nums, ops);
        return nums.removeLast();
    }
}
