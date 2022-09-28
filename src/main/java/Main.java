import java.util.Arrays;

/**
 * @author Yuri
 * @since 2021/12/15 11:06
 */
public class Main {
    public static void main(String[] args) {

        String equation = "x+5-3+x=6+x-2";
        String substring = equation.substring(0, equation.length() - 1);
        System.out.println(substring);


        equation = equation.replace("-", "+-");
        int e = equation.indexOf("=");
        String left = equation.substring(0, e);
        String right = equation.substring(e + 1);
        String[] strings = right.split("[+=]");
        System.out.println(Arrays.toString(strings));
    }
}
