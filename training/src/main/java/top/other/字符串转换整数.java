package top.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Van
 * @date 2021/2/19 - 10:43
 */
public class 字符串转换整数 {
    public int myAtoi(String s) {
        s=s.trim();
        Pattern pattern=Pattern.compile("^[\\-\\+]?\\d+");
        Matcher matcher=pattern.matcher(s);
        int reslut=0;
        if(matcher.lookingAt()){
            try{
                reslut=Integer.parseInt(s.substring(matcher.start(),matcher.end()));
            }catch(Exception e){
                reslut=s.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
        }
        return reslut;
    }
}
