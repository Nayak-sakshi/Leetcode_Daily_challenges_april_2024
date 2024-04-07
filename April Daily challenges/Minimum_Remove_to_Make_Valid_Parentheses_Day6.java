//public class Minimum_Remove_to_Make_Valid_Parentheses_Day6 {
//}
//Given a string s of '(' , ')' and lowercase English characters.
//
//Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
//
//Formally, a parentheses string is valid if and only if:
//
//It is the empty string, contains only lowercase characters, or
//It can be written as AB (A concatenated with B), where A and B are valid strings, or
//It can be written as (A), where A is a valid string.
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int extraOpen = 0;
        // find indexes of invalid parenthesis
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='('){
                // stack.push()
                sb.append(ch);
                extraOpen++;
            }
            else if(ch==')'){
                if(extraOpen>0){
                    sb.append(ch);
                    extraOpen--;
                }else if(extraOpen==0){
                    continue;
                }

            }else{
                sb.append(ch);
            }
        }
        //remove the xtra open brackets
        n = sb.length();
        for(int i=n-1;i>=0;i--){
            if(extraOpen==0){
                break;

            }
            char ch = sb.charAt(i);
            if(ch=='('){
                sb.deleteCharAt(i);
                extraOpen--;
            }
        }
        return sb.toString();
    }
}
