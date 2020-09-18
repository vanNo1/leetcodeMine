package other;

public class 数值的整数次方 {
    public double myPow(double x, int n) {
        double result=1;
        if (n==0){
            return 1;
        }
        if (n<0){
            n=Math.abs(n);
            for (int i = 0; i < n; i++) {
                result*=1/x;
            }
        }else {
            for (int i = 0; i < n; i++) {
                result*=x;
            }
        }

        return result;
    }
}
