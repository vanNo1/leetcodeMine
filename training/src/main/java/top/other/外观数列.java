package top.other;

/**
 * @author Van
 * @date 2021/2/18 - 18:17
 */
public class 外观数列 {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String last = countAndSay(n - 1);
        int count = 1;
        char number = last.charAt(0);
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < last.length(); i++) {
            if (number != last.charAt(i)) {
                result.append(count);
                result.append(number);
                count = 1;
                number = last.charAt(i);
            } else {
                count++;
            }
        }
        //失误：这里还要处理一次！！for循环处理不了末尾的！
        result.append(count);
        result.append(number);
        return result.toString();
    }

    public static void main(String[] args) {
        countAndSay(4);
    }
}
