public class Freedom_Trail_Day27 {
    public int findRotateSteps(String ring, String key) {
        // cal pos
        //[a] -> {0,1,2}
        // [b]-> {3,6}
        int dp[][] = new int[key.length()][ring.length()];// keyindex , ringindex
        for(int i=0;i<key.length();i++){
            Arrays.fill(dp[i],-1); // init with -1
        }

        ArrayList<Integer> posArr[] = new ArrayList[26];
        for(int i=0;i<ring.length();i++){
            char ch = ring.charAt(i); //a-97 =0
            int index = ch -97;
            //a ,i
            if(posArr[index]==null){
                posArr[index] = new ArrayList<Integer>();
            }
            posArr[index].add(i);
        }
        int minSteps = getMinSteps(key,ring,0,0,posArr,dp);
        return minSteps;

    }

    public int getMinSteps(String key,String ring ,int ringIndex, int keyIndex,ArrayList<Integer> posArr[],int dp[][]){
        //Base case
        if(keyIndex==key.length()){
            return 0;
        }
        if(dp[keyIndex][ringIndex]!=-1){
            return dp[keyIndex][ringIndex];
        }
        // gen all possibilities
        //keyindex
        int charIndex = key.charAt(keyIndex) - 97;//a-0
        ArrayList<Integer> positions = posArr[charIndex];
        int minAns = Integer.MAX_VALUE;
        for(int pos : positions){
            int clockwise = Math.abs(ringIndex-pos);
            int antiClockwiseStep = ring.length() - clockwise;
            int minStep = Math.min(clockwise, antiClockwiseStep);
            int curAns = minStep + getMinSteps(key,ring,pos,keyIndex+1,posArr,dp);
            minAns = Math.min(minAns, curAns);
        }
        return dp[keyIndex][ringIndex]= 1+ minAns; // 1 ia fir the button press
    }
}
