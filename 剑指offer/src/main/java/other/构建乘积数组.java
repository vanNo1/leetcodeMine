package other;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 总的来说就是从左到右乘一遍，从右到左乘一遍
 */
public class 构建乘积数组 {
    public int[] constructArr(int[] a) {
        int value=1;
        int[]r=new int[a.length];
        for (int i = 0; i < r.length; i++) {
            r[i]=value;
            value*=a[i];
        }
        int value2=1;
        for (int i = a.length-1; i >=0 ; i--) {
            r[i]=r[i]*value2;
            value2*=a[i];
        }
        return r;
    }
}
