package dp;

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
