public class Nth_Tribonacci_Number_Day24 {
    public int tribonacci(int n) {
        if(n<=2){
            return (n==0)?0:1;
        }
        int prev0=0;
        int prev1=1;
        int prev2=1;
        int sum =0;
        for(int i=3;i<=n;i++){
            sum = prev0+prev1+prev2;
            prev0 = prev1;
            prev1 = prev2;
            prev2 = sum;
        }
        return sum;
    }
}
