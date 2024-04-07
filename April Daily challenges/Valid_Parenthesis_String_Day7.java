//public class Valid_Parenthesis_String {
//}
//Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
//
//The following rules define a valid string:
//
//Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//Any right parenthesis ')' must have a corresponding left parenthesis '('.
//Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> extraOpenBracket = new Stack<>();
        Stack<Integer> astrick = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                extraOpenBracket.push(i);
            }else if(ch=='*'){
                astrick.push(i);
            }else{
                // closing bracket
                if(!extraOpenBracket.isEmpty()){
                    extraOpenBracket.pop();
                }else if(!astrick.isEmpty()){
                    astrick.pop(); // * is treated as (
                }
                else{
                    return false;
                }

            }

        }
        while(!extraOpenBracket.isEmpty()){
            if(astrick.isEmpty()){
                return false;
            }
            int openIndex = extraOpenBracket.pop();
            int closeIndex = astrick.pop();
            if(openIndex > closeIndex){
                return false;
            }
        }
        return extraOpenBracket.isEmpty();
    }
}