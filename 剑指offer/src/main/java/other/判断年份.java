package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 垃圾桶思想，是数字就装进去，不是就倒一次垃圾桶（垃圾桶有东西的话），最后还要倒一次垃圾筒，防止最后是数字，没倒掉就结束循环了。
 *
 * 替换掉外层while+内层while
 */
public class 判断年份 {
    public static int[] year(String s) {
        List<Integer> result = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                res=res*10+s.charAt(i)-'0';
            }else {
                if (res!=0){
                    result.add(res);
                    res=0;
                }
            }
        }
        //防止最后的char是数字，这里还要判断一次
        if (res!=0){
            result.add(res);
        }
        int[]array=new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i]=result.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        String s="asd2018asd201901lll2000";
        int[]array=year(s);
    }
}
