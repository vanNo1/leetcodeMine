package top.other;

/**
 * @author Van
 * @date 2021/2/18 - 10:26
 */
public class 阶乘后的零 {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
