package utils;

/**
 * @Author Yuri
 * @Date 2021/8/26 11:25
 * @Version 1.0
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        int n = gcd(377, 319);
        System.out.println(n);

    }
    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }



}
