package other;

public class 把字符串转换成整数 {
    public static int strToInt(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (stringBuilder.toString().equals("") && (str.charAt(i) != '-' && (str.charAt(i) - '0' < 0 || str.charAt(i) - '0' > 9))) {
                continue;
            }
            if (!stringBuilder.toString().equals("") && (str.charAt(i) != '-' && (str.charAt(i) - '0' < 0 || str.charAt(i) - '0' > 9))) {
                break;
            }
            if (str.charAt(i) == '-' || str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9){
                stringBuilder.append(str.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());
        return Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        strToInt("words and 987");
        strToInt("42");
        strToInt("   -42");
        strToInt("4193 with words");
    }
}

