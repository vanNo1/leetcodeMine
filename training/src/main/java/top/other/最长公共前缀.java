package top.other;

/**
 * @author Van
 * @date 2021/2/19 - 10:32
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < ans.length() && j < strs[i].length() && ans.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            if (j == 0) return "";
            // 就两种情况，一个是在ans和current中间停下，第二个是在ans的末尾停下，但无论怎样ans都要变为ans.substring(0,j)
            ans = ans.substring(0, j);
        }
        return ans;
    }
}
