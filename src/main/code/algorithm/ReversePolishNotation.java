package algorithm;

import java.util.*;

/**
 * <p>逆波兰表达式（RPN-ReversePolishNotation）也就是四则运算中的后缀表达式，
 * 不同于我们熟知的中缀表达式，后缀表达式是计算机容易理解的方式
 *
 * <p>对于表达式求值类问题的通用解法就是：中缀表达式 → 逆波兰表达式 → 栈辅助求值，
 *
 * <p>即通过{@link algorithm.ReversePolishNotation#infixToRpn(String)  infixToRpn()}将中缀表达式转为逆波兰表达式，
 * 方法为：<br/>
 * <b>1.</b>维护两个栈，一个rpn（最后逆波兰表达式成型后的栈），一个ops用于存储符号的辅助栈 <br/>
 * <b>2.</b>遇到数字或一元'-'（出现位置只有表达式开头或者'('之后），循环获取完整的数，压入rpn <br/>
 * <b>3.</b>遇到‘('直接压入ops，遇到')'则循环取ops，将遇到'('前的符号压入rpn <br/>
 * <b>4.</b>遇到'+'、’-‘、’*‘、‘/'等二元运算符，需要与ops中的运算符号比较优先级压入ops
 * 其逻辑为：设'*'、'/'优先级为 2，'+'、'-'优先级为 1，'('优先级为0（虽然表达式中'('优先级最高，但因为其不为运算符，所以设置其优先级最低）
 * 比较优先级，当ops栈顶符号优先级<=当前符号，则将其压入rpn，最后将当前符号压入ops <br/>
 * <b>5.</b>最后将ops中剩余符号从栈顶开始压入rpn，所得的rpn便是所求的逆波兰表达式 <br/>
 * 最后再通过{@link algorithm.ReversePolishNotation#evalRPN(String[]) evalRPN()}对所求的逆波兰表达式求值可通用解决表达式问题
 *
 * <p>但是如果不需要显性的求出逆波兰表达式而只需要求得最终结果值，则可以将其上述两个函数合并，即<b>将ops中符号取出压入rpn的步骤改为直接计算</b>，
 * 这样只需要一步即可求得表达式的值 {@link algorithm.ReversePolishNotation#evalExpression(String) evalExpression()}
 *
 * <p>表达式求解相关题型：{@link leetcode.editor.cn.BasicCalculator LC224 基础计算器}
 *
 * <p>逆波兰表达式表达式求值相关题型：{@link leetcode.editor.cn.EvaluateReversePolishNotation LC150 逆波兰表达式}
 *
 * <p><b>注意：</b>此类下表达式为默认为一般表达式，包含[]、{}、()、+、-、*、/等运算符，
 * 此外也可能包含多余空格和一元运算符（如-1+2中这个负号）
 *
 * @author Yuri
 * @see <a href="https://blog.csdn.net/qq_44713454/article/details/108834358">中缀表达式转逆波兰表达式</a>
 * @since 2023/3/11 15:28
 */

public class ReversePolishNotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<String> deque = infixToRpn(in.nextLine());
        for (String str : deque) {
            System.out.printf("%s ", str);
        }
    }

    // 预处理函数，可以根据具体题目进行处理
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
            } else if (c == '(') ops.add(String.valueOf(c));
            else if (c == '-' || c == '+' || c == '*' || c == '/') {
                while (!ops.isEmpty() && priority(String.valueOf(c)) <= priority(ops.peekLast())) {
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
    private static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (Objects.equals(token, "+")) {
                Integer a = stack.removeLast();
                Integer b = stack.removeLast();
                stack.add(a + b);
            } else if (Objects.equals(token, "-")) {
                Integer a = stack.removeLast();
                Integer b = stack.removeLast();
                stack.add(b - a);
            } else if (Objects.equals(token, "/")) {
                Integer a = stack.removeLast();
                Integer b = stack.removeLast();
                stack.add(b / a);
            } else if (Objects.equals(token, "*")) {
                Integer a = stack.removeLast();
                Integer b = stack.removeLast();
                stack.add(a * b);
            } else stack.add(Integer.valueOf(token));
        }
        return stack.removeLast();
    }

    // 对于表达式隐式转逆波兰表达式直接求所得值
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
