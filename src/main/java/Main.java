import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2021/12/15 11:06
 */
public class Main {
    public static void main(String[] args) {

        String s = "a good   example";
        String[] s1 = s.split(" ");
        String ss = Arrays.stream(s1).filter(str -> !Objects.equals(str, "") && Objects.nonNull(str))
                .collect(Collectors.joining(" "));
        String sss = new StringBuffer(ss).reverse().toString();

        System.out.println(sss);
    }
}
