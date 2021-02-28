package top.other;

/**
 * @author Van
 * @date 2021/2/18 - 16:49
 */
public class 加一 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            digits[i] = sum % 10;
            if (sum / 10 < 1) {
                return digits;
            }
        }
        int[] result=new int[digits.length+1];
        result[0]=1;
        return result;
    }
}
