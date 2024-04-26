public class Longest_Ideal_Subsequence_Day25 {
    public int longestIdealString(String s, int k) {
        int n =s.length();
        int dp[][] = new int[n][27];
        //init dp with -1
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return getMaxLenSubseq(s,0,k,'{',dp);
    }
    public int getMaxLenSubseq(String s, int index, int k, char lastChar, int dp[][]){
        //base case
        if(index==s.length()){
            return 0;
        }
        // if state is already visited then return
        if(dp[index][lastChar-'a']!=-1){
            return dp[index][lastChar-'a'];
        }
        //pick or no pick
        int pick=0;
        char currentChar = s.charAt(index);
        int diff = Math.abs((int)lastChar - (int)currentChar);
        if(lastChar=='{' || diff<=k){
            pick = 1 + getMaxLenSubseq(s, index+1, k, currentChar, dp);
        }
        int noPick = 0 + getMaxLenSubseq(s, index+1, k, lastChar, dp);
        return dp[index][lastChar-'a'] = Math.max(pick,noPick);
    }
}
