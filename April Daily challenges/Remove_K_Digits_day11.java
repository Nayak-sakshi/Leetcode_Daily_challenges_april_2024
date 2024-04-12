
//Given string num representing a non-negative integer num, and an integer k,
// return the smallest possible integer after removing k digits from num.
//Example 1:
//
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.


public class Remove_K_Digits_day11 {
    class Solution {
        public String removeKdigits(String num, int k) {
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<num.length();i++){
                char ch = num.charAt(i);
                // remove from the left
                while(!stack.isEmpty() && k>0 && ch<stack.peek()){
                    stack.pop();
                    k--;
                }
                stack.push(ch);
            }
            // converting stack to Stringbuilder
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                if(k>0){
                    stack.pop();
                    k--;
                }else{
                    sb.insert(0,stack.pop());
                }

            }
            // remove the leading zeros
            while(sb.length()>0 && sb.charAt(0)=='0'){
                sb.deleteCharAt(0);
            }
            return (sb.length()==0)?"0":sb.toString();

        }
    }
}
