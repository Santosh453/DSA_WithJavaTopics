package stack;

import java.util.Stack;

public class StackClass {
    public static void main(String[] args) {

    }




//    For a given expression in the form of a string, find if there exist any redundant brackets or not. It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.
//    A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.
//    Example:
//    Expression: (a+b)+c
//    Since there are no needless brackets, hence, the output must be 'false'.
//    Expression: ((a+b))
//    The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output will be 'true'.
//    Note:
//    You will not get a partial score for this problem. You will get marks only if all the test cases are passed.
//    Return "false" if no brackets are present in the input.
    public static boolean checkRedundantBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<expression.length(); i++){
            char currentChar = expression.charAt(i);
            if(currentChar != ')'){
                stack.push(currentChar);
            }else if(currentChar == ')'){
                int count=0;
                while(stack.peek() != '('){
                    count++;
                    stack.pop();
                }
                if(count < 2){
                    return true;
                }
                stack.pop();
            }
        }
        return false;
    }


}
