package dp;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 一到n整数中1出现的次数 {
    public int countDigitOne(int n) {
        int[]dp=new int[n+1];
        dp[0]=0;
        for (int i =1; i <=n ; i++) {
            int num=i;
            int many=0;
            while (num!=0){
                if (num%10==1){
                    many++;
                }
                num/=10;
            }
            dp[i]=many+dp[i-1];
        }
        return dp[n];
    }
}
