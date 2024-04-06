//A string is a valid parentheses string (denoted VPS) if it meets one of the following:
//Input: s = "(1+(2*3)+((8)/4))+1"
//Output: 3
//Explanation: Digit 8 is inside of 3 nested parentheses in the string.

class Solution {
    public int maxDepth(String s) {
        int currentOpen = 0;
        int maxOpen = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                currentOpen++;
            }else if(s.charAt(i)==')'){
                currentOpen--;
            }
            maxOpen = Math.max(maxOpen, currentOpen);
        }
        return maxOpen;
    }
}