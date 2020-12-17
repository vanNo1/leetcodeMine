package other;

/**
 * @author Van
 * @date 2020/12/14 - 19:09
 */
public class 整数反转 {
    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return (int) n == n ? (int) n : 0;
    }
}
