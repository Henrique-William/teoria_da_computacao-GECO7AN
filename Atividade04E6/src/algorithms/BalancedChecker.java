////Atividade 4 - Exericio 6 (10-03-2025)
/// 6 - Faça um algoritmo (na sua linguagem preferida) que receba uma expressão e verifique se está com parênteses / colchetes/ chaves balanceados.
package algorithms;

import java.util.Stack;

public class BalancedChecker {
    private static boolean isMatchingPair(char open, char close){
        return (open == '(' && close == ')' ) || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    public static boolean isBalanced(String expression){
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()){ return false; }
                char last = stack.pop();
                if (!isMatchingPair(last, ch)) {return false;}
            }
        }
        return stack.isEmpty();
    }
}
