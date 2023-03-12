package nowcoder.hj;

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
        Deque<String> rpn = infixToRpn(in.nextLine());
        int res = evalRPN(rpn);
        System.out.println(res);

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
        else return 3; //'('返回3
    }

    private static Deque<String> infixToRpn(String s) {
        s = init(s); // 初始化
        Deque<String> rpn = new LinkedList<>();
        Deque<String> ops = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || (c == '-' && (i == 0 || s.charAt(i - 1) == '('))) {
                // 如果是数字或者判断为一元负号
                StringBuilder str = new StringBuilder(String.valueOf(c));
                while (i + 1 < s.length() && Character.isDigit(c = s.charAt(i + 1))) {
                    str.append(c);
                    i++;
                }
                rpn.add(str.toString());
            } else if (c == '-' || c == '+' || c == '*' || c == '/' || c == '(') {
                while (!ops.isEmpty() && c != '(' && !Objects.equals(ops.peekLast(), "(") && priority(String.valueOf(c)) <= priority(ops.peekLast())) {
                    rpn.add(ops.pollLast());
                }
                ops.add(String.valueOf(c));
            } else if (c == ')') {
                // 如果遇到右括号 ')'，则要把ops中的符号压入rpn中，直到遇到左括号 '('
                String op;
                while (!Objects.equals(op = ops.pollLast(), "(")) rpn.add(op);
            }
        }
        while (!ops.isEmpty()) {
            rpn.add(ops.pollLast()); // 最后ops中剩余符号需要倒序压入rpn
        }
        return rpn;
    }

    // 逆波兰表达式求值
    private static int evalRPN(Deque<String> tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (Objects.equals(token, "+")) {
                Integer a = stack.pollLast();
                Integer b = stack.pollLast();
                stack.add(a + b);
            } else if (Objects.equals(token, "-")) {
                Integer a = stack.pollLast();
                Integer b = stack.pollLast();
                stack.add(b - a);
            } else if (Objects.equals(token, "/")) {
                Integer a = stack.pollLast();
                Integer b = stack.pollLast();
                stack.add(b / a);
            } else if (Objects.equals(token, "*")) {
                Integer a = stack.pollLast();
                Integer b = stack.pollLast();
                stack.add(a * b);
            } else stack.add(Integer.valueOf(token));
        }
        return stack.pollLast();
    }
}
