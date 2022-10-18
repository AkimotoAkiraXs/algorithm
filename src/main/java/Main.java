import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2021/12/15 11:06
 */
public class Main {
    public static void main(String[] args) {

        List<String> dictionary = Lists.newArrayList(
                "ale", "apple", "monkey", "plea"
        );
        dictionary = dictionary.stream().sorted((a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            return b.length() - a.length();
        }).collect(Collectors.toList());

        System.out.println(dictionary);
    }
}
