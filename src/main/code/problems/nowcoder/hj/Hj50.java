package problems.nowcoder.hj;

import java.util.*;

/**
 * <p>表达式求值使用通用解法：{@link algorithm.ReversePolishNotation 逆波兰表达式}
 *
 * @author Yuri
 * @since 2023/3/12 0:53
 */

public class Hj50 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(evalExpression(in.nextLine()));

    }

    private static String init(String s) {
        // 去空格，对于infixToRpn()中对一元运算符的处理逻辑来说，提前去空格是有必要的
        s = s.replace(" ", "");

        // 大括号、中括号统一转为小括号
        s = s.replace("[", "(");
        s = s.replace("]", ")");
        s = s.replace("{", "(");
        s = s.replace("}", ")");

        // 一元运算符处理，对于不用求出显示逆波兰表达式的题目是比较好用的避免边界问题的方法，
//        s = s.replace("(-", "(0-");

        // 对于以'-'开始的表达式，也可以通过对rpn栈初始填充0的方式进行边界处理

        return s;
    }

    // 获取优先级
    private static int priority(String s) {
        if (Objects.equals(s, "*") || Objects.equals(s, "/")) return 2;
        else if (Objects.equals(s, "+") || Objects.equals(s, "-")) return 1;
        else return 0; //'('返回3
    }

    private static void eval(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.size() < 2 || ops.size() < 1) return;
        int a = nums.removeLast();
        int b = nums.removeLast();
        char op = ops.removeLast();
        switch (op) {
            case '+':
                nums.add(b + a);
                break;
            case '-':
                nums.add(b - a);
                break;
            case '*':
                nums.add(b * a);
                break;
            case '/':
                nums.add(b / a);
        }
    }

    public static int evalExpression(String s) {
        s = init(s); // 初始化
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || (c == '-' && (i == 0 || s.charAt(i - 1) == '('))) {
                // 如果是数字或者判断为一元负号
                StringBuilder str = new StringBuilder(String.valueOf(c));
                while (i + 1 < s.length() && Character.isDigit(c = s.charAt(i + 1))) {
                    str.append(c);
                    i++;
                }
                nums.add(Integer.parseInt(str.toString()));
            } else if (c == '(') ops.add(c);
            else if (c == '-' || c == '+' || c == '*' || c == '/') {
                while (!ops.isEmpty() && priority(String.valueOf(c)) <= priority(String.valueOf(ops.peekLast()))) {
                    eval(nums, ops);
                }
                ops.add(c);
            } else if (c == ')') {
                // 如果遇到右括号 ')'，则要把ops中的符号压入rpn中，直到遇到左括号 '('
                while (ops.getLast() != '(') eval(nums, ops);
                ops.removeLast(); // 去掉栈顶的'('
            }
        }
        while (!ops.isEmpty()) {
            eval(nums, ops);
        }
        return nums.removeLast();
    }
}
