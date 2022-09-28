import java.util.Arrays;

/**
 * @author Yuri
 * @since 2021/12/15 11:06
 */
public class Main {
    public static void main(String[] args) {

        String equation = "x+5-3x-x=x+2x-2";
        String substring = equation.replaceAll("(\\D)x|^x", "$11x");

        System.out.println(substring);


        equation = equation.replace("-", "+-");
        int e = equation.indexOf("=");
        String left = equation.substring(0, e);
        String right = equation.substring(e + 1);
        String[] strings = right.split("[+=]");
        System.out.println(Arrays.toString(strings));
    }
}
