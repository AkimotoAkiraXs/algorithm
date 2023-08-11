package tips;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * String类如何转为Stream流式编程，再转为String
 *
 * @author Yuri
 * @since 2023/2/17 21:45
 */

public class StringTips {
    public static void main(String[] args) {
        String s = " ";
        // todo 字符串转Int流和转数组转流是不一样的
        s = s.codePoints().distinct().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .reverse().toString();

        // 字符串转流和上面转intStream
        Map<String, Long> collect = Stream.of(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //    统计字符串中每个字符的个数

        // 字符串格式化处理
        String bin = "01";
        DecimalFormat format = new DecimalFormat("00000000");
        bin = format.format(Integer.valueOf(bin));
    }
}
