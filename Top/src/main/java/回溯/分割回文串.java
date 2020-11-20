package 回溯;

import java.util.List;

public class 分割回文串 {
    public List<List<String>> partition(String s) {

    }



    public boolean isHuiWen(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder reverse = stringBuilder.reverse();
        return s.equals(reverse.toString());
    }

}
