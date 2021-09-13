package utils;

/**
 * @Author Yuri
 * @Date 2021/8/26 11:25
 * @Version 1.0
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int count = 0;
        long n = 0L;
        int startNum = 0;
        int max = 0;
        for (int i = 2; i < 1000000; i++) {
            n = i;
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                    count++;

                } else {
                    n = n * 3 + 1;
                    count++;
                }
            }
            if (count + 1 > max) {      //由于在while循环中，n==1时，count没有+1，所以得到的数列长度忽略了1，这里加上
                max = count + 1;
                startNum = i;
            }
            System.out.println(count + 1);
            count = 0;

        }
        System.out.println(startNum);
    }

}
