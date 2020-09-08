class Solution {
    public void judge(int num) {
        if (num==1){
            System.out.println("奇数");
        }
        if (num==0){
            System.out.println("偶数");
        }
        if (num%2==0){
            System.out.println("偶数");
        }else {
            System.out.println("奇数");
        }
    }
}