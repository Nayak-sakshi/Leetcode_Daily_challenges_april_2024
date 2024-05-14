public class Array_XOR_Equal_to_K_Day29 {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        int xor = 0;
        for(int num: nums){
            xor=xor^num;
        }
        while(xor > 0 || k > 0) {
            if(xor%2 != k%2) {
                count++;
            }
            xor/=2;
            k/=2;
        }
        return count;
    }
}
