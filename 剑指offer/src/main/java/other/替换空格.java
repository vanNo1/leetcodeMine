package other;

/**
 * 弱智题
 */
public class 替换空格 {
    public String replaceSpace(String s) {
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=' '){
                result.append(s.charAt(i));
            }else {
                result.append("%20");
            }
        }
        return result.toString();
    }
}
