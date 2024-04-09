//public class Make_The_String_Great_Day4 {
//}
//Given a string s of lower and upper case English letters.
//
//A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
//
//0 <= i <= s.length - 2
//s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
//To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.
//
//Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
//
//Notice that an empty string is also good.

class Solution {
    public String makeGood(String s) {
        // Stringbuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            // int len = ans.length();
            if(!stack.isEmpty() && Math.abs(stack.peek()- ch)==32){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        String ans = new String();
        while(!stack.isEmpty()){
            ans = stack.pop() + ans;
        }
        return ans;
    }
}