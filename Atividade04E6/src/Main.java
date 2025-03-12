import static algorithms.BalancedChecker.*;

public class Main {
    public static void main(String[] args) {
        //Atividade 4 - Exericio 6

        String[] testExpressions = {
                "()", "{}", "[]", "({[]})", "(({{[[]]}}))", "(){}[]", "({[]}){}([])", //pas
                "(", ")", "(]", "({[)]}", "{[}]", "(((", ")))", "{[}", "({})]", // don't pass
                "", "abc", "{a+b*(c-d)]", "{a+b*(c-d)}"  //edge cases (if the expression don't contain vocabulary = pass)
        };

        for (String expr : testExpressions) {
            System.out.println("Expressão: " + expr + " -> " + (isBalanced(expr) ? "Balanceada" : "Não Balanceada"));
        }
    }
}