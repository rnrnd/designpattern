package designpattern;


import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {
    public static void main(String[] args) {
        int k = 0;
        int[] arr = new int[]{1,2};
        System.out.println(arr[++k] +"," + k);
    }
}
